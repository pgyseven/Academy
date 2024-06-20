package com.mbcac.oop;

import java.util.Arrays;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BoardMgr
{
   public static void main(String[] args)
   {
      // CRUD, Board, Arrays
      // 글번호, 작성자, 제목, 본문, 히트수
      // 프로그램이 시작되면 게시글 리스트가 표시된다
      // 목록에는 글번호, 작성자, 제목, 히트수만 표시되어야 함(본문 제외)
      // 목록에는 게시글 본문은 포함하지 않고 상세글 보기에서 본문이 보이도록 할 것임
      // 추가(a), 목록(s), 검색(f), 상세보기(t), 수정(u), 삭제(d), 종료(x):
     
	   //상세글보기 화면에는 메뉴 중에 '댓글쓰기(r)' 메뉴가 표시되도록 한다.
	   //댓글도 Board 배열에 추가되어야 하고, 부모글을 볼 때 하단에 보여져야 한다.
	   
	   /*
	   제목 검색시 아래 기능 사용
	   String title = "HelloWorld";
	   System.out.println("HelloWorld".contains("oWo")); //문자열 속에 들어있다. 그러면 트루가 뜸
	    */

	   
	   createList();
	      showList();
	      boolean go = true;
	      while(go)

      {
        
         String m = showMenu();

         
         switch(m)
         {
            case "x": go = false;               break;
            case "a": addBoard(0);                          break;
            case "f": findByTitle();                          break;
            case "s": showList();                          break;
            case "t": showDetail();                          break;

            default: System.err.println("\t메뉴입력 오류");
         }
      }
     
      System.out.printf("프로그램 종료%n");
   

      
   }// end of main()
   
   /*
   static String[] reply1 = new String[5];
   static int rep1;
   static String[] reply2 = new String[5];
   static int rep2;
   static String[] reply3 = new String[5];
   static int rep3;
   static String[] reply4 = new String[5];
   static int rep4;
   static String[] reply5 = new String[5];
   static int rep5;
   */
   
   static Board[] blist = new Board[10];
   static Scanner kbd = new Scanner(System.in);
   static int cnt;
   
   private static Board[] searchByTitle(String title)
   {
      int ttlCnt = 0;
      for(int i=0;i<cnt;i++) {
         if(blist[i].getTitle().contains(title)) ttlCnt++;
      }
      Board[] found = new Board[ttlCnt];
      ttlCnt = 0;
      for(int i=0;i<cnt;i++) {
         if(blist[i].getTitle().contains(title)) {
            found[ttlCnt++] = blist[i];
         }
      }
      return found;
   }
   
   private static void findByTitle()
   {
      System.out.print("제목의 일부분:");
      String key = kbd.nextLine();
      Board[] found = searchByTitle(key);
      System.out.println();
      System.out.println("\t ** 제목으로 검색한 결과 **");
      System.out.printf("%s\t%10s\t%s\t%s%n","번호","제목","작성자","히트수");
      System.out.println("=====================================");
      for(int i=0;i<found.length;i++) {
         found[i].print();
      }
   }
   
   
   /*
   private static void findByTitle()
   {
	      System.out.print("검색할 제목:");
	      String ti = kbd.nextLine();

	      for(int i=0;i<cnt;i++)
	      {
	    	  if(blist[i].getTitle().contains(ti))
	    	  {   
	    		  System.out.println(blist[i].getNum() + " " + blist[i].getTitle() + " " + blist[i].getContents());
	    		  return;
	    	  }
	      }
		 System.out.println("\t같은게 없어요");
		
	      
   }
   */
   private static void add(int pnum)
   {
      System.out.print("글번호:");
      int bnum = kbd.nextInt();
      kbd.nextLine();
      System.out.print("글제목:");
      String title = kbd.nextLine();
      System.out.print("작성자:");
      String author = kbd.nextLine();
      System.out.print("내용:");
      String contents = kbd.nextLine();
     
      Board b = new Board(bnum,title,author,contents,0,pnum);
      blist[cnt++] = b;
      System.out.println("\t 게시글을 추가했습니다");
   }
   
   private static void createList()
   {  
      blist[cnt++] = new Board(11, "게시판 개시", "김윤정", "와우~ 축하드려요!",0,0);
      blist[cnt++] = new Board(12, "자바를 내것으로", "김희석", "꼭 알아야 합니다",0,0);
      blist[cnt++] = new Board(13, "축하 메시지", "윤석열", "내가 범인이다",0,0);
      blist[cnt++] = new Board(14, "안녕~", "김건희", "천공을 아시나요?",0,0);
      blist[cnt++] = new Board(15, "국가안보는...", "이종섭", "나만 몰라요~",0,0);
   }
   
   private static void showList()
   {
      System.out.println();
      System.out.println("\t ** 게시글 목록 **");
      System.out.printf("%s\t%10s\t%s\t%s%n","번호","제목","작성자","히트수");
      System.out.println("=====================================");
      for(int i=0;i<cnt;i++) {
         blist[i].print();
      }
   }
   
   private static String showMenu() {
	      System.out.println();
	      System.out.print("추가(a), 목록(s), 검색(f), 상세보기(t), 수정(u), 삭제(d), 종료(x):");
	      String m = kbd.nextLine().trim();
	      return m;
	   }
   
   private static Board findByNum(int bnum)
   {
		 for(int i=0;i<blist.length;i++)
	      {
	    	  if(blist[i].getNum()==bnum)
	    	  {   
	    		  return blist[i];
	    	  }
	      }
		 System.out.println("\t검색 실패");
		return null;
   }
   
   private static void addBoard(int pnum)
   {
      System.out.print("글번호:");
      int bnum = kbd.nextInt();
      kbd.nextLine();
      System.out.print("글제목:");
      String title = kbd.nextLine();
      System.out.print("작성자:");
      String author = kbd.nextLine();
      System.out.print("내용:");
      String contents = kbd.nextLine();
     
      Board b = new Board(bnum,title,author,contents,0,pnum);
      blist[cnt++] = b;
      System.out.println("\t 게시글을 추가했습니다");
   }
   
   private static void showDetail()
   {
      System.out.print("글번호:");
      int bnum = kbd.nextInt();
      kbd.nextLine();
     
    

      
      Board b = findByNum(bnum);//공통 로직 즉 여기서도 필요한건 검색에서도 필요한 기능이니 메소드로 만들어서 재활용 해야한다.
      if(b==null)//null 이 들어올 수 있으니 
    	  {
         System.err.println("\t검색된 게시글이 없습니다");
         return;
      }
      System.out.println();
      System.out.println("\t ** 상세글 보기 **");
      System.out.printf("%s\t%10s\t%s\t%s%n","번호","제목","작성자","히트수");
      System.out.println("=====================================");
      b.print();
      System.out.println("-------------------------------------");
      System.out.println("본문 --> " + b.getContents());
      System.out.println("=====================================");
     
      Board[] child = getChild(bnum);
     
      for(int i=0;i<child.length;i++) {
         System.out.printf("댓글 %d. %s%n",i+1, child[i].getContents());
      }
      System.out.println();
     
      System.out.print("나가기(o), 댓글쓰기(r):");
      String m = kbd.nextLine();
      if(m.equals("r")) {
         addBoard(bnum);
      }
   }
   
   private static Board[] getChild(int pnum)
   {
      int childCnt = 0;
      for(int i=0;i<cnt;i++)
         if(blist[i].getPnum()==pnum) childCnt++;
     
      Board[] child = new Board[childCnt];
     
      childCnt = 0;
      for(int i=0;i<cnt;i++)
         if(blist[i].getPnum()==pnum)
            child[childCnt++] = blist[i];
     
      return child;
   }
/*
   private static String[] callReply(Board re )
   {

	    	 if(re.getPnum()==1)
	    	 {
	    		 return reply1;
	    	 }

	    	 if(re.getPnum()==2)
	    	 {
	    	 return reply2;
	    	 }

	    	 if(re.getPnum()==3)
	    	 {
	    		 return reply3;
	    	 }
	     

	    	 if(re.getPnum()==4)
	    	 {
	    		 return reply4;
	    	 }

	  
	    	 if(re.getPnum()==5)
	    	 {
	    		 return reply5;
	    	 }
	     
		return null;
	    
   }
   private static void wrReply(Board re)
   {
	     //reply = new String[5];
	     System.out.println("댓글 입력:");
	     String com = kbd.nextLine();
	     //reply[re.getPnum()] = com;

	    	 if(re.getPnum()==1)
	    	 {
	    	 reply1[rep1] = com;
	    	 //System.out.println(reply1[rep1]);
	    	 rep1++;
	    	 }

	   
	    	 if(re.getPnum()==2)
	    	 {
	    	 reply2[rep2] = com;
	    	 rep2++;
	    	 }

	     	
	    	 if(re.getPnum()==3)
	    	 {
	    	 reply3[rep3] = com;
	    	 rep3++;
	    	 }

	     
	    	 if(re.getPnum()==4)
	    	 {
	    	 reply4[rep4] = com;
	    	 rep4++;
	    	 }

	    	 if(re.getPnum()==5)
	    	 {
	    	 reply5[rep5] = com;
	    	 rep5++;
	    	 }
	     
	    
	     //.getIndex().setReply(com);
	     System.out.println("댓글 입력 완료!");

   }
   */

}// end of BoardMgr

@Data
@AllArgsConstructor
@NoArgsConstructor
class Board
{
   private int num;
   private String title;
   private String author;
   private String contents;
   private int hit;
   private int pnum;
   
   public void print()
   {
      System.out.printf("%d\t%10s\t%s\t%d\t%d%n", num,title,author,hit,pnum);
   }
}

   

   /*
   // 댓글 추가 메소드
   public void addComment(String comment) {
       if (commentCount < comments.length) {
           comments[commentCount++] = comment;
       } else {
           System.out.println("더 이상 댓글을 추가할 수 없습니다.");
       }
   }

   // 댓글 출력 메소드
   public void printComments() {
       if (comments != null) {
           System.out.println("댓글:");
           for (String comment : comments) {
               if (comment != null) {
                   System.out.println("- " + comment);
               }
           }
       } else {
           System.out.println("댓글이 없습니다.");
       }
   }
*/
 


  
