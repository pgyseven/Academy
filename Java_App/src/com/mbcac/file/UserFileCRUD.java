package com.mbcac.file;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import java.io.*;

public class UserFileCRUD
{
   static String menu = "추가(a), 목록(s), 검색(f), 수정(u), 삭제(d), 종료(x):";
   static Scanner kbd = new Scanner(System.in);
   static String filePath = "C:/eclipse-workspace/Java_Web/src/main/webapp/users.txt";
   static List<User> userList;
   
   public static void main(String[] args)
   {
      boolean go = true;
      while(go)
      {
         String m = menu();
         switch(m)
         {
            case "x": go = false;      break;
            case "a": add();         break;
            case "s": showList();      break;
            case "f": findUser();      break;
            case "u": update();         break;
           
            default: System.err.println("메뉴입력 오류");
         }
      }
      System.out.println("프로그램 종료");
   }
   
   static void update() {
      System.out.print("이용자 아이디, 새 전화번호:");
      String id = kbd.next().trim();            // trim()
      String newPhone = kbd.nextLine().trim();      // trim()
      User key = new User(id); //유저 아이디만 있어도 객체 생성할 수있게 아래서 만들어줘서 가능하다
      userList = getList();
      boolean updated = false;
      if(userList.contains(key)) { // 윗줄에서 객체를 생성했기에 여기서 컨테인스 가능한것이다.
         int idx = userList.indexOf(key);
         User found = userList.get(idx);
         found.setPhone(newPhone);
         //메모리에서 변경된 정보를 파일에 덮어쓰기한다
         updated = overwrite(userList);
      }
      if(updated) System.out.println("전화번호 수정 성공");
      else System.err.println("전화번호 수정 실패");
   }
   
   /** 메모리에서 변경된 데이터를 기존 파일에  덮어쓰기한다 */
   static boolean overwrite(List<User> list) {
      try {
         PrintWriter pw = new PrintWriter(new FileWriter(filePath)); //프린터 리터는 가공스트림 필터 스트림이다 여기서 가공해서 한행으로 만들어주고 이걸 리턴 받는게 br.readLine 이다. //파일리더(노드 스트림 : 데이터 말단에 붙어있어야 하는)가 한행씩 읽는대 버퍼가 한행으로 만든!
         String line = null;
         for(int i=0;i<list.size();i++) {
            User u = list.get(i);
            line = String.format("%d %s %s %s %s",
               u.getNo(), u.getId(), u.getPwd(), u.getPhone(), u.getEmail());
            pw.println(line);
         }
         pw.close();
         return true;
      } catch (IOException e) {
         e.printStackTrace();
      }
      return false;
   }
   
   static void findUser() {
      System.out.print("검색할 이용자 아이디:");
      String uid = kbd.nextLine().trim();
      User key = new User(uid);
      userList = getList();
      if(userList.contains(key)) {
         int idx = userList.indexOf(key);
         User found = userList.get(idx);
         found.printUser();
      }
   }
   
   /** 번호, 아이디, 암호, 전화, 이메일 */
   static void add() {
      System.out.print("번호, 아이디, 암호, 전화, 이메일:");
      int no = kbd.nextInt();
      String id = kbd.next().trim();
      String pwd = kbd.next().trim();
      String phone = kbd.next().trim();
      String email = kbd.nextLine().trim();
     
      User u = new User(no, id, pwd, phone, email);
      saveUser(u);
   }
   
   /** User 오브젝트를 텍스트파일에 한 행으로 쓴다 */
   static void saveUser(User u) {
      try {
         PrintWriter pw = new PrintWriter(new FileWriter(filePath, true));
         String line = String.format("%d %s %s %s %s",
               u.getNo(), u.getId(), u.getPwd(), u.getPhone(), u.getEmail());
         pw.println(line);
         pw.close();
         System.out.println("사용자 정보 파일에 추가 성공");
      } catch (IOException e) {
         System.err.println("파일에 저장 중에 실패");
         e.printStackTrace();
      }
   }
   
   /** 텍스트 파일에서 한행씩 읽어서 Emp 객체 생성 및 리스트에 저장/리턴 */
   static List<User> getList()
   {
      try {
         BufferedReader br = new BufferedReader(new FileReader(filePath));
         String line = null;
         List<User> list = new ArrayList<>();
         while((line=br.readLine())!=null) {
            String[] utoken = line.split(" ");
            User user = new User(utoken);
            list.add(user);
         }
         br.close();
         return list;
      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   
   static void showList() {
      printList(getList());
   }
   
   static void printList(List<User> list) {
      for(int i=0;i<list.size();i++) {
         list.get(i).printUser();
      }
   }
   
   static String menu() {
      System.out.print(menu);
      String m = kbd.nextLine().trim();
      return m;
   }
}
/* 텍스트파일을 사용한 사용자 정보 CRUD
 * 프로그램이 시작되면 메뉴가 표시되고 메뉴에 따라 아래의 기능이 실행되도록 한다
 * 추가, 목록, 검색, 수정, 삭제, 프로그램 종료
 * 사용자 번호, 아이디, 암호, 전화, 이메일
 * users.txt 파일에 사용자의 모든 정보가 입력되고 관리되도록 한다
 * User 클래스를 사용한다(텍스트파일의 내용이 로드될 때는 User인스턴스를 사용한다)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class User
{
   private int no;
   private String id;
   private String pwd;
   private String phone;
   private String email;
   
   public User(String id)
   {
      this.id = id;
   }

   public User(String[] utoken) {
      this.no = Integer.parseInt(utoken[0]);
      this.id = utoken[1];
      this.pwd = utoken[2];
      this.phone = utoken[3];
      this.email = utoken[4];
   }
   
   public boolean equals(Object obj) {
      User other = (User)obj;
      return this.id.equals(other.id);
   }
   
   public void printUser()
   {
      System.out.printf("%d\t%s\t%s\t%s\t%s%n", no,id,pwd,phone,email);
   }

}