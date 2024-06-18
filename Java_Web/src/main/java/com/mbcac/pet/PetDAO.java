package com.mbcac.pet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mbcac.pet.PetVO;

public class PetDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;

	private Connection getConn() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean save(PetVO key) {
		getConn();
		String sql = "INSERT INTO pet (no, name, year, price, weight) VALUES(?,?,?,?,?)";
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, key.getNo());
			pstmt.setString(2, key.getsName());
			pstmt.setInt(3, key.getYear());
			pstmt.setInt(4, key.getPrice());
			pstmt.setFloat(5, key.getWeight());
			int res = pstmt.executeUpdate();

			System.out.println(res);
			return res>0;
			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeAll();
		}

		return false;
	}

	private void closeAll() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<PetVO> petList()  {
		 getConn();
	       String sql = "SELECT * FROM pet"; 
	      
	       List<PetVO> list = new ArrayList<>();
	       try {
	          pstmt = conn.prepareStatement(sql);
	          rs=pstmt.executeQuery();  
	          while(rs.next())
	          {
	             int no = rs.getInt("NO");
	             String name = rs.getString("NAME");
	             int year = rs.getInt("YEAR");
	             int price = rs.getInt("PRICE");
	             int weight = rs.getInt("WEIGHT");
	             
	             PetVO pet = new PetVO();
	             pet.setNo(no); 
	             pet.setsName(name);
	             pet.setYear(year);
	             pet.setPrice(price);
	             pet.setWeight(weight);
	             
	             
	             list.add(pet);
	          }
	          
	          return list;
	       }catch(Exception ex) {
	          ex.printStackTrace();
	       }finally { 
	          closeAll();
	       }
		
		return null;
	}

}
