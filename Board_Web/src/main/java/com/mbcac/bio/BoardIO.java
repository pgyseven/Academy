package com.mbcac.bio;



import com.mbcac.vo.Board;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BoardIO 
{
   private static String filePath = "C:/eclipse-workspace/Board_Web/src/main/webapp/board.dat";
   private static int maxNum;
   
   
   static { // static 초키화 블럭(Initialization block)
	   try {
			BufferedReader br = new BufferedReader(new FileReader(filePath)); //FileReader는 한글자씩 불러오고 버퍼드 리더가 모아서 한행씩 만든다.
			String line = null;
			
			while((line=br.readLine())!=null) {
				String[] tok = line.split("\\|");

				Board b = new Board(tok);
				maxNum = b.getNum()>maxNum?b.getNum():maxNum;
				
			}
			br.close();
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		   
   }
   //객체 생성 안되도 자동으로 돌아가는 스태틱 블록 호출 방법이 없기에 프로그램이 돌아가면 자동으로 실행됨 //항상 언제돌려도 최고 번호가 들어가겠금 보장되게 프로그램한거임 메소드 호출 못하는것도 객체 생성안된 상황이라 호출이 안됨
   
   public static int getMaxNum() {
      return maxNum;
   }
   
   public boolean save(Board b)
   {
      try {
         PrintWriter pw = new PrintWriter(new FileWriter(filePath, true));
         pw.println(b);
         pw.close();
         int bnum = b.getNum();
         maxNum = bnum > maxNum ? bnum : maxNum;
         return true;
      } catch (IOException e) {
         e.printStackTrace();
      }
      return false;
   }

   public List<Board> getList() 
   {
	   try {
		BufferedReader br = new BufferedReader(new FileReader(filePath)); //FileReader는 한글자씩 불러오고 버퍼드 리더가 모아서 한행씩 만든다.
		String line = null;
		List<Board> list = new ArrayList<>(); 
		while((line=br.readLine())!=null) {
			String[] tok = line.split("\\|");

			Board b = new Board(tok);
			list.add(b);
			
		}
		br.close();
		return list;
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return null;
   }

   public Board findByNo(int no) {
	          upHit(no);
		      List<Board> list = getList();
		      for(int i=0;i<list.size();i++) {
		         Board u = list.get(i);
		         if(u.getNum()==no) {
		            return u;
		         }
		      }
	
	return null;
   }

private void upHit(int no) {
	
     List<Board> list = getList();
     list = getList();
     for(int i=0;i<list.size();i++) {
        Board u = list.get(i);
        if(u.getNum()==no) {
           u.setHits(u.getHits()+1);
           overwrite(list);

           
        }
     }


}




public void overwrite(List<Board> list)
{
   try {
      PrintWriter pw = new PrintWriter(new FileWriter(filePath));
      for(int i=0;i<list.size();i++) {
         Board u = list.get(i);
         String line = u.toString();
         pw.println(line);
      }
      pw.close();

   } catch (IOException e) {
      e.printStackTrace();
   }

}

	





public boolean delete(int no) {
    List<Board> list = getList();
    for(int i=0;i<list.size();i++) {
       Board u = list.get(i);
       if(u.getNum()==no) {
          list.remove(i);
          overwrite(list);
           return true;
       }
    }
    return false;
 }
	




 

public List<Board> search(String category, String keyword) 
{
   List<Board> list = null;
   if(category.equals("제목")) list = searchByTitle(keyword);
   else if(category.equals("내용")) list = searchByContents(keyword);
   return list;
}

private List<Board> searchByContents(String keyword) {
   List<Board> list = getList();
   List<Board> found = new ArrayList<>();
   for(int i=0;i<list.size();i++) {
      Board b = list.get(i);
      if(b.getContents().contains(keyword)) {
         found.add(b);
      }
   }
   return found;
}

private List<Board> searchByTitle(String keyword) {
   List<Board> list = getList();
   List<Board> found = new ArrayList<>();
   for(int i=0;i<list.size();i++) {
      Board b = list.get(i);
      if(b.getTitle().contains(keyword)) {
         found.add(b);
      }
   }
   return found;
}









}
