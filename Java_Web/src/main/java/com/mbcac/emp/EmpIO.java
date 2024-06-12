package com.mbcac.emp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



public class EmpIO {
	

	   private static String filePath = "C:/Users/802-01/git/Academy/Academy/Java_Web/src/main/webapp/empList.txt";
	  
	   
	   public boolean save(EUser emp)
	   {
	      try {
	         PrintWriter pw = new PrintWriter(new FileWriter(filePath, true));
	         String line = String.format("%d %s %s %s %s", emp.getEmpno(), emp.getEname(), emp.getSal(), emp.getHiredate(), emp.getImage());
	         pw.println(line);
	         pw.close();
	         
	         return true;
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      return false;
	   }


	public List<EUser> getList() {
	
			   try {
				BufferedReader br = new BufferedReader(new FileReader(filePath)); //FileReader는 한글자씩 불러오고 버퍼드 리더가 모아서 한행씩 만든다.
				String line = null;
				List<EUser> list = new ArrayList<>(); 
				while((line=br.readLine())!=null) {
					String[] tok = line.split(" ");

					EUser emp = new EUser(tok);
					list.add(emp);
					
				}
				br.close();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
			   return null;
		   }
	   
	   
	   
	   
	  
	 




	}



