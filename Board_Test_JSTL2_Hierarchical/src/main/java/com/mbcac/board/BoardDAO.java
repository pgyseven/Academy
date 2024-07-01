package com.mbcac.board;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardDAO 
{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Connection getConn()
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");  //ojdbc11.jar 
			conn = DriverManager.getConnection(
	                "jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//board(num, title, author, contents, rdate, parent)
	public List<BoardVO> getHierarchicalList()
	{
		getConn();
		String sql = "SELECT bnum, LPAD('└Re:', (LEVEL-1)*3,  '　') || title AS title, "
				   + "author, rdate "
				   + "FROM board2 "
				   + "START WITH parent=0 "
				   + "CONNECT BY PRIOR bnum=parent";

		List<BoardVO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			int ttlPages = 0;
			while(rs.next())
			{
				int bnum = rs.getInt("BNUM");
				String title = rs.getString("TITLE");
				String author = rs.getString("AUTHOR");
				java.sql.Date rdate = rs.getDate("RDATE");

				BoardVO board = new BoardVO();
				board.setBnum(bnum);
				board.setTitle(title);
				board.setAuthor(author);
				board.setRdate(rdate);

				list.add(board);
			}

			return list;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	
	   public int add(BoardVO board) {//board(num, title, author, contents, rdate, parent)
		      getConn();
		      String sql = "INSERT INTO board2(bnum,title,author,contents,rdate,parent) " +
		                     "VALUES(board2_num_seq.NEXTVAL,?,?,?,SYSDATE,?) " +
		                     "RETURNING bnum INTO ?";

		      try {
		         CallableStatement cstmt = conn.prepareCall("{call "+ sql +"}");
		         cstmt.setString(1, board.getTitle());
		         cstmt.setString(2, board.getAuthor());
		         cstmt.setString(3, board.getContents());
		         cstmt.setInt(4, board.getParent());
		         cstmt.registerOutParameter(5, Types.INTEGER);
		         int rows = cstmt.executeUpdate();
		         int newId = cstmt.getInt(5);

		         cstmt.close();
		         return rows>0 ? newId : 0;
		      }catch(Exception ex) {
		         ex.printStackTrace();
		      }finally {
		         closeAll();
		      }
		      return 0;
		   }
	
	   
	   public Pagination<BoardVO> getHierarchicalList(int page, int IPP)
	   {
	      getConn();
	      String sql2 = "SELECT * FROM "
	               + "("
	               + "    SELECT t2.*,  FLOOR((RN-1)/"+ IPP +"+1) page FROM "
	               + "    ("
	               + "        SELECT t1.*, ROWNUM RN FROM "
	               + "        ( "
	               + "           SELECT * FROM "
	               + "           ( "
	               + "              SELECT bnum, LPAD('└Re:', (LEVEL-1)*4,  '　') || title AS title, "
	               + "              author, rdate, parent, ttlpages FROM "
	               + "            ( "
	               + "                  SELECT * FROM board2 "
	               + "               CROSS JOIN  (SELECT CEIL(COUNT(*)/"+ IPP +") ttlpages FROM board2) "
	               + "               ORDER BY rdate DESC"
	               + "            ) "
	               + "              START WITH parent=0 CONNECT BY PRIOR bnum=parent "
	               + "           ) "
	               + "        )t1 "
	               + "    )t2 "
	               + ") "
	               + "WHERE page=?";

	      List<BoardVO> list = new ArrayList<>();
	      try {
	         pstmt = conn.prepareStatement(sql2);
	         pstmt.setInt(1, page);
	         rs = pstmt.executeQuery();
	         int ttlPages = 0;
	         while(rs.next())
	         {
	            int bnum = rs.getInt("BNUM");
	            String title = rs.getString("TITLE");
	            String author = rs.getString("AUTHOR");
	            java.sql.Date rdate = rs.getDate("RDATE");
	            ttlPages = rs.getInt("TTLPAGES");
	            
	            BoardVO board = new BoardVO();
	            board.setBnum(bnum);
	            board.setTitle(title);
	            board.setAuthor(author);
	            board.setRdate(rdate);

	            list.add(board);
	         }

	         Pagination<BoardVO> pagination = new Pagination(page, IPP, ttlPages);
	         pagination.setItems(list);
	         return pagination;
	      }catch(Exception ex) {
	         ex.printStackTrace();
	      }finally {
	         closeAll();
	      }
	      return null;
	   } 
	   
	 
	public Pagination getList(int page)
	{
		System.out.println(page);
		getConn();
		String sql = "SELECT * FROM "
				   + "("
				   + "    SELECT t2.*,  FLOOR((RN-1)/3+1) page FROM "
				   + "    ("
				   + "        SELECT t1.*, ROWNUM RN FROM "
				   + "        ( "
				   + "            SELECT * FROM board2 CROSS JOIN  (SELECT CEIL(COUNT(*)/3) ttlpages FROM board2) ORDER BY bnum"
				   + "        )t1 "
				   + "    )t2 "
				   + ") "
				   + "WHERE page=?";

		List<BoardVO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page);
			rs = pstmt.executeQuery();
			int ttlPages = 0;
			while(rs.next())
			{
				int bnum = rs.getInt("BNUM");
				String title = rs.getString("TITLE");
				String author = rs.getString("AUTHOR");
				java.sql.Date rdate = rs.getDate("RDATE");
				String contents = rs.getString("CONTENTS");
				ttlPages = rs.getInt("TTLPAGES");
				System.out.println(title);
				
				BoardVO board = new BoardVO();
				board.setBnum(bnum);
				board.setTitle(title);
				board.setAuthor(author);
				board.setRdate(rdate);
				board.setContents(contents);
System.out.println("여기까지 오나요?");
				list.add(board);
			}
			
			//int currentPage, int itemsPerPage, int totalItems
			Pagination<BoardVO> pagination = new Pagination(page, 3, ttlPages);
			pagination.setItems(list);
			return pagination;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	
	
	private void closeAll()
	{
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public BoardVO boardByBnum(int bnum) 
	{
		getConn();
		String sql = "SELECT * FROM board2 WHERE bnum=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bnum);
			rs = pstmt.executeQuery();

			if(rs.next())    // VALUES(board_seq.NEXTVAL, SYSDATE, ?, ?, ?)
			{
				int bn= rs.getInt("BNUM");
				String title = rs.getString("TITLE");
				String author = rs.getString("AUTHOR");
				java.sql.Date rdate = rs.getDate("RDATE");
				String contents = rs.getString("CONTENTS");
				
				BoardVO board = new BoardVO();
				board.setBnum(bn);
				board.setTitle(title);
				board.setAuthor(author);
				board.setRdate(rdate);
				board.setContents(contents);
				return board;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			closeAll();
		}
		return null;
	}
	/*
	public boolean update(EmpVO emp)
	{
		getConn();
		String sql = "UPDATE emp2 SET deptno=?, sal=? WHERE empno=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getDeptno());
			pstmt.setInt(2, emp.getSal());
			pstmt.setInt(3, emp.getEmpno());
			int rows = pstmt.executeUpdate();
			
			return rows>0;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			closeAll();
		}
		return false;
	}
	
	public boolean delete(int empno)
	{
		getConn();
		String sql = "DELETE FROM emp2 WHERE empno=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			int rows = pstmt.executeUpdate();
			
			return rows>0;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			closeAll();
		}
		return false;
	}

	public boolean add(EmpVO emp) {
		getConn();
		String sql = "INSERT INTO emp2 VALUES(?,?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4,  emp.getMgr());
			pstmt.setDate(5, emp.getHiredate());
			pstmt.setInt(6, emp.getSal());
			pstmt.setFloat(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());
			
			int rows = pstmt.executeUpdate();
			
			return rows>0;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			closeAll();
		}
		return false;
	}*/
}

