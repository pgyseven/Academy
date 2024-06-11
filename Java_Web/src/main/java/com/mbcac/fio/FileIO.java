package com.mbcac.fio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.mbcac.vo.User;

public class FileIO 
{
   private static String filePath = "C:/Users/802-01/git/Academy/Academy/Java_Web/src/main/webapp/users.txt";

   public boolean login(User user) {
      List<User> list = getList();
      boolean ok = list.contains(user);
      return ok;   // User.equals()사용됨
   }
   
   public List<User> getList() {
      try {
         BufferedReader br = new BufferedReader(new FileReader(filePath));
         String line = null;
         List<User> list = new ArrayList<>();
         while((line=br.readLine())!=null) {
            String[] tok = line.split(" ");
            User u =  new User();
            
            u.setNo(Integer.parseInt(tok[0]));
            u.setId(tok[1]);
            u.setPwd(tok[2]);
            u.setPhone(tok[3]);
            u.setEmail(tok[4]);
            list.add(u);
         }
         br.close();
         return list;
      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   public boolean addUser(User u) {
      try {
         PrintWriter pw = new PrintWriter(new FileWriter(filePath, true));
         String line = String.format("%d %s %s %s %s", 
            u.getNo(),u.getId(),u.getPwd(),u.getPhone(),u.getEmail());
         pw.println(line);
         pw.close();
         return true;
      } catch (IOException e) {
         e.printStackTrace();
      }
      return false;
   }

   public User findByNo(int no) {
      List<User> list = getList();
      for(int i=0;i<list.size();i++) {
         User u = list.get(i);
         if(u.getNo()==no) {
            return u;
         }
      }
      return null;
   }
   
   public boolean update(User key) {
         List<User> list = getList();
         for(int i=0;i<list.size();i++) {
            User u = list.get(i);
            if(u.getNo()==key.getNo()) {  //업데이트 대상 정보를 찾아서
               u.setPhone(key.getPhone()); //새 데이터로 갱신하고
               u.setEmail(key.getEmail()); //갱신된 메모리의 데이터를 파일에 덮어쓰기 한다.
               return overwrite(list);  //갱신된 메모리의 데이터를 파일에 덮어쓰기 한다.
            }
         }
         return false;
      }
   
   public boolean overwrite(List<User> list)
   {
      try {
         PrintWriter pw = new PrintWriter(new FileWriter(filePath));
         for(int i=0;i<list.size();i++) {
            User u = list.get(i);
            String line = String.format("%d %s %s %s %s", 
               u.getNo(),u.getId(),u.getPwd(),u.getPhone(),u.getEmail());
            pw.println(line);
         }
         pw.close();
         return true;
      } catch (IOException e) {
         e.printStackTrace();
      }
      return false;
   }
   
   
   public boolean delete(int no) {
         List<User> list = getList();
         for(int i=0;i<list.size();i++) {
            User u = list.get(i);
            if(u.getNo()==no) {
               list.remove(i);
                return overwrite(list);
            }
         }
         return false;
      }



}