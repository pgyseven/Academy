package com.mbcac.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO 
{
   private Connection conn;
   private PreparedStatement pstmt;
   private Statement stmt;
   private ResultSet rs;
   /*
    * java.sql 패키지에 포함된 Interface들은 메소드 헤더만 선언되어 있고 실제 기능은 없다.
    * 데이터베이스를 다루는 기능을 작성하는 DB제조사에서는 java.sql 패키지의 인터페이스를 구현하여 JDBC Driver 를 작성해야 한다.
    * 
    */
   
    private Connection getConn() //private 인 이유는 외부에서 호출하지 말라인데 그렇게 일을하면 안된다고 선언한거나 것과 같다.
    {
       try 
       {
         Class.forName("oracle.jdbc.OracleDriver"); //"oracle.jdbc.OracleDriver 오라클사에서 만든 ojdbc.jar 안에 있는 클래스 이름이다. 각. 앞에 있는 디렉토리 경로에 가면 최종 oracleDriver가 있다. 데이터 베이스 들어가기위한 중간 소프트웨어 미드웨어 그러면 jar 에 있는 클래스를 메모리에 로드하고 이러면 오라클에 들어갈수 있는 것 이다.
         //forname 은 이름을 가지고 클래스를 로드하는 기능. 즉 뒤에 ""안에 있는 것을 로드
         //드라이버가 로드가 되면 DriverManager.getConnection 을 쓸 수 있다. 
        
         conn = DriverManager.getConnection( //오라클 데이터 베이스 연결
                     "jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");  //db url "jdbc:oracle:thin:@localhost:1521:xe" 이건 오라클사가 만든 것.
           //pstmt = conn.createStatement(); //오라클에 데이터 입출력 할 수 있는 방법 전달 방법 createStatement(); sql 문장을 다룰 수 있는 스테이트먼트 sql 문장이란 뜻
          
           return conn;
      } 
       catch (Exception e) 
       {
         
         e.printStackTrace();
      }
        return null;
    }

    public List<EmpVO> empByDeptno(int deptno) 
    {
       getConn();
       //String sql = "SELECT * FROM emp2 WHERE deptno=" + deptno;
       String sql = "SELECT * FROM emp2 WHERE deptno=?"; //?처리하고 나중에 물음표 자기에 무엇을 너라 라고 하는 방법도 있다 즉 오라클에 들어가서 거기서 결정되게 할 수도 있다. 그리고 이게 성능이 더 빠르다. 즉 파라미터 자리만 비워두고 하는게! 요것만 바꿔서 실행해 라고 오라클에 할 수 있다. 성능도 좋고 에러도 덜 하다.
       //그럴려면 프리페어드 스테이트 먼트로 바꿔냥 한다. private Statement stmt; 이걸 미리준비되어있는의 뜻이 있는 prepareStatement로 임포트부터 쭉 바꾸고 위치도 바꾼다.
      
       List<EmpVO> list = new ArrayList<>();
       try {
    	   //rs = stmt.executeQuery(sql); 
          //stmt.executeQuery 자바에 없는 언어다 오라클에서 만든 것 sql이 오라클에 전달되는 과정이다. 쿼리를 실행한다 그럼 그결과가 여기로 옴 즉 오라클이 메모리에 올려두고 그 주소가 여기 온다. 그럼 그주소가면 있다.
          pstmt = conn.prepareStatement(sql);
          pstmt.setInt(1, deptno); //sql 문장에 물음표가 여러개가 있을 수 있다! 첫번째 물을표에 deptno를 넣어라
          rs=pstmt.executeQuery();  //pstmt 가 sql 문장을 이미 가지고 있으니 지난번과 다르게 바로 실행하라고만 하면됨
          //executeQuery(); Select 문장실행만 사용, Update 데이터 갱신 ,insert 한줄 바꾸기, Delete 삭제 이 세가지는 성격이 셀렉트 문과는 다르다. 이건 DB가 갱신된다하여 executeUpdate 여야함!
          //update,insert, delete 문장은 pstmt.executeUpdate()를 사용한다. return 값은  서버에서 몇개를 조작 했는가 성공한 행수가 나온다. 1줄을 고치거나 삭제하라고 했으면 잘 했으면 1이 나온다.
          while(rs.next())
          {
             int empno = rs.getInt("EMPNO");
             String ename = rs.getString("ENAME");
             java.sql.Date hiredate = rs.getDate("HIREDATE");
             int salary = rs.getInt("SAL");
             int dno = rs.getInt("DEPTNO");
             //한행을 하나의 오브젝트로 만든다 이걸 맵핑이라 한다.
             EmpVO  emp = new EmpVO();
             emp.setEmpno(empno);
             emp.setEname(ename);
             emp.setSal(salary);
             emp.setHiredate(hiredate);
             emp.setDeptno(dno);
             list.add(emp); //jsp에서 출력하기 좋게 리스트로 저장
          }
          
          return list;
       }catch(Exception ex) {
          ex.printStackTrace();
       }finally {  //서버는 동시 접속자 수에 한계가 있다 이건 서버 가격에 따라 다르다. 그리고 그렇기에 이 작업이 끝나면 서버와 끊으니 접속자 수에서 줄것
    	   //finally는 에어가 났던 아니던 DB를 닫아야다. while 문 안에 넣으면 중간에 오류나면 DB 연결이 지속되고 접속자수에서 제외 시킬 수 있다.
    	   //커넥션 풀이란게 있는데 getconn으로 연결하면 이게 1초 정도 걸린다고 하는데 즉 DB 연결과정에서 시간이 많이 드니깐 커넥션 객체를 만들어두고 놀고있던 객체에 연결해서 빠르게 하는게 커넥션 풀 즉 접속하는 시간을 단축! DB와 연결을 미리 만든것!
          closeAll();
       }
       return null;
    }
    
 


	public List<EmpVO> getList() {
		 getConn();
	       String sql = "SELECT * FROM emp2"; 
	      
	       List<EmpVO> list = new ArrayList<>();
	       try {
	    	   
	          
	          pstmt = conn.prepareStatement(sql);
	          rs=pstmt.executeQuery();  
	          while(rs.next())
	          {
	             int empno = rs.getInt("EMPNO");
	             String ename = rs.getString("ENAME");
	             java.sql.Date hiredate = rs.getDate("HIREDATE");
	             int salary = rs.getInt("SAL");
	             int dno = rs.getInt("DEPTNO");
	             
	             EmpVO  emp = new EmpVO();
	             emp.setEmpno(empno); 
	             emp.setEname(ename);
	             emp.setSal(salary);
	             emp.setHiredate(hiredate);
	             
	             emp.setDeptno(dno);
	             list.add(emp);
	          }
	          
	          return list;
	       }catch(Exception ex) {
	          ex.printStackTrace();
	       }finally { 
	          closeAll();
	       }
		
		return null;
	}
	
	   private void closeAll() 
	    {
	       try
	       {
	       if(rs!=null)rs.close();
	        if(pstmt!=null)pstmt.close();
	        if(conn!=null)conn.close();

	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	    }
	   public EmpVO empByEmpno(int eno) 
	   {
	      getConn();
	      String sql = "SELECT * FROM emp2 WHERE empno=?";

	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, eno);
	         rs = pstmt.executeQuery();

	         if(rs.next())
	         {
	            int empno = rs.getInt("EMPNO");
	            String ename = rs.getString("ENAME");
	            java.sql.Date hiredate = rs.getDate("HIREDATE");
	            int salary = rs.getInt("SAL");
	            int dno = rs.getInt("DEPTNO");
	            String job = rs.getString("JOB");
	            int mgr = rs.getInt("MGR");
	            float comm = rs.getFloat("COMM");
	            
	            EmpVO  emp = new EmpVO();
	            emp.setEmpno(empno);
	            emp.setEname(ename);
	            emp.setSal(salary);
	            emp.setHiredate(hiredate);
	            emp.setDeptno(dno);
	            emp.setJob(job);
	            emp.setMgr(mgr);
	            emp.setComm(comm);
	            return emp;
	         }
	      }catch(Exception ex) {
	         ex.printStackTrace();
	      }finally {
	         closeAll();
	      }
	      return null;
	   }

	public boolean saveUpdate(int empno, int deptno, int sal) {
		
		
		 getConn();
	      String sql = "UPDATE emp2 SET deptno=?, sal=? WHERE empno=? ";

	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, deptno);
	         pstmt.setInt(2, sal);
	         pstmt.setInt(3, empno);
	        
	         int res = pstmt.executeUpdate(); //select 할때 exeutequery
	         return res>0;
	         
	      }catch(Exception ex) {
	         ex.printStackTrace();
	      }finally {
	         closeAll();
	      }
		
		return false;
	}
	
	public boolean delete(int empno) {
		
		
		 getConn();
	      String sql = "DELETE FROM emp2 WHERE empno=?";

	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, empno);
	         int res = pstmt.executeUpdate(); 
	         System.out.println(res);
	         if(res==1)
	         {
	        	 return true;
	         }
	         
	      }catch(Exception ex) {
	         ex.printStackTrace();
	      }finally {
	         closeAll();
	      }
		
		return false;
	}

	public boolean save(EmpVO key) {
		 getConn();
	      String sql = "INSERT INTO emp2 (empno, ename, hiredate, sal, deptno) VALUES(?,?,?,?,?) ";
	      try {
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setInt(1, key.getEmpno());
		         pstmt.setString(2, key.getEname());
		         pstmt.setDate(3, key.getHiredate());
		         pstmt.setInt(4, key.getSal());
		         pstmt.setInt(5, key.getDeptno());
		         int res = pstmt.executeUpdate(); 
		         
		         System.out.println(res);
		         if(res==1)
		         {
		        	 return true;
		         }
		         
		      }catch(Exception ex) {
		         ex.printStackTrace();
		      }finally {
		         closeAll();
		      }
			
		return false;
	}
	}

