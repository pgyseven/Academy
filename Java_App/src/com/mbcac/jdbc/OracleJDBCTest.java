package com.mbcac.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleJDBCTest 
{
   public static void main(String[] args) 
   {
      System.out.println("jdk20, Oracle 11gR2 XE, ojdbc11.jar 테스트"); 
      Connection conn = null;
      try {
         Class.forName("oracle.jdbc.OracleDriver"); //jar 파일에 있는걸 쓸려고 로드하는 것 class 라는 클래스에 forname 이라는 메소드가 있는것 클래스의 이름을 가지고 로드하는 기능 그 이름은 () 안에 이클래스가 있어야만이 ORACLE 로드가 가능함
         conn = DriverManager.getConnection( // 위에서 드라이버 로드후 연결을 시도한 것
                   "jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER"); // 오라클 db url 그리고 1521:xe이건 포트 이건 우리가 바꾸는게 아니고 오라클이 정해준거고 @localhost 이것만 우리걸로 그리고 쉼표 이후 아이디와 비번
        //이제 conn이 드라이버 연결된 곳을 안다.
         Statement stmt = conn.createStatement(); // Statement SQL 문장을 다룰 수 있는 객체
         ResultSet rs = stmt.executeQuery("SELECT * FROM emp2 WHERE deptno=20"); //SQL 문장을 준다. JDBC 를 통하여 오라클레 보내지면 실행을하고 그결과를 여기로 리턴한다. rs 가르키는 메모리 주소에 가보면 오라클이 보내준 정보가 있다.
         
         while(rs.next()) //.next 로 rs의 항행까지 가져온다. 없으면 false 로 뜬다.그럼 빠져나옴
         {
            int empno = rs.getInt("EMPNO");  //오라클과 자바의 자료형이 다르니 이런식으로 변환하는 작업이 필요하다 오라클의 넘버였으니 여기서는 int로 바꿔야하니 getInt로 바꾼것
            String ename = rs.getString("ENAME"); //varch~~ 였으니 자바에선 스트링이니 바꾼것
            java.sql.Date hiredate = rs.getDate("HIREDATE");  //유틸의 데이트가 있고 sql date 가 있지만 이건 일반 적인 유틸게 아니니 직관적으로 개발자도 알수 있게  java.sql.Date 이렇게 쓴다.
            float salary = rs.getFloat("SAL"); //getdouble도 가능하다. int로 하면 소수점이 잘린다. 그건 우리가 알맞게 골라서 쓴다.
            
            System.out.printf("%d\t%s\t%s\t%f \n", empno,ename,hiredate,salary);
         }
         
         rs.close();// 위에서 열었던 순서의 역수으로 닫는다 제일 먼저 연것을 제일 나중에 닫아준다.
         stmt.close();
         conn.close();
         
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
}
