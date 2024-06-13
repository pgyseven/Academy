package com.mbcac.emp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.mbcac.vo.User;



public class EmpIO {

	private static String filePath = "C:/Users/802-01/git/Academy/Academy/Java_Web/src/main/webapp/empList.txt";

	public boolean save(EUser emp) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(filePath, true));
			String line = String.format("%d %s %s %s %s", emp.getEmpno(), emp.getEname(), emp.getSal(),
					emp.getHiredate(), emp.getImage());
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
			BufferedReader br = new BufferedReader(new FileReader(filePath)); // FileReader는 한글자씩 불러오고 버퍼드 리더가 모아서 한행씩
																				// 만든다.
			String line = null;
			List<EUser> list = new ArrayList<>();
			while ((line = br.readLine()) != null) {
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

	public EUser findByNo(int no) {
		List<EUser> list = getList();
		for (int i = 0; i < list.size(); i++) {
			EUser u = list.get(i);
			if (u.getEmpno() == no) {
				return u;
			}
		}
		return null;
	}

		  public boolean update(EUser key) {
		         List<EUser> list = getList();
		         for(int i=0;i<list.size();i++) {
		            EUser eu = list.get(i);
		            if(eu.getEmpno()==key.getEmpno()) {  //업데이트 대상 정보를 찾아서
		               eu.setSal(key.getSal()); //새 데이터로 갱신하고
		               return overwrite(list);  //갱신된 메모리의 데이터를 파일에 덮어쓰기 한다.
		            }
		         }
		         return false;
		      }
		  
		   public boolean overwrite(List<EUser> list)
		   {
		      try {
		         PrintWriter pw = new PrintWriter(new FileWriter(filePath));
		         for(int i=0;i<list.size();i++) {
		            EUser eu = list.get(i);
		            String line = String.format("%d %s %s %s %s", 
		               eu.getEmpno(), eu.getEname(), eu.getSal(), eu.getHiredate(), eu.getImage() );
		            pw.println(line);
		         }
		         pw.close();
		         return true;
		         
		      } catch (IOException e) {
		         e.printStackTrace();
		      }
		      return false;
		   }

		public boolean delete(int empno) {
			List<EUser> list = getList();
			for (int i = 0; i < list.size(); i++) {
				EUser u = list.get(i);
				if (u.getEmpno() == empno) {
					list.remove(u);
					return overwrite(list);
				}
			}
			return false;
		}

		public EUser findList(String cat, String keyword) {
			
			if(cat.equals("사번")) {
				int empno = Integer.parseInt(keyword);
				List<EUser> list = getList();
				for (int i = 0; i < list.size(); i++) {
					EUser u = list.get(i);
					if (u.getEmpno() == empno) {
						return u;
					}
				}
				return null;
			}
				
			if(cat.equals("이름")) {
				List<EUser> list = getList();
				for (int i = 0; i < list.size(); i++) {
					EUser u = list.get(i);
					if (u.getEname().equals(keyword)) {
						return u;
					}
				}
				return null;
				
			}
			return null;
		}

		
		
		
		  

}