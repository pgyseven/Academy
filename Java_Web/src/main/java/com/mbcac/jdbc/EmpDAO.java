package com.mbcac.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO 
{
   private Connection conn;
   private Statement stmt;
   private ResultSet rs;
   
    private Connection getConn() 
    {
       try 
       {
         Class.forName("oracle.jdbc.OracleDriver");
         conn = DriverManager.getConnection(
                     "jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
           stmt = conn.createStatement();
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
       String sql = "SELECT * FROM emp2 WHERE deptno=" + deptno;
       List<EmpVO> list = new ArrayList<>();
       try {
          rs = stmt.executeQuery(sql);
    
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
        if(stmt!=null)stmt.close();
        if(conn!=null)conn.close();

       } catch (Exception e) {
           e.printStackTrace();
       }
    }
   /*
    Connection conn = null;
     try {
        Class.forName("oracle.jdbc.OracleDriver");
        conn = DriverManager.getConnection(
                  "jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
        Statement stmt = conn.createStatement();
        
        String deptno = request.getParameter("deptno");
        String sql = "SELECT * FROM emp2 WHERE deptno=" + deptno;
        
        List<EmpVO> list = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(sql);

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
        
        rs.close();
        stmt.close();
        conn.close();

       } catch (Exception e) {
           e.printStackTrace();
       }
       */
}
