package com.mbcac.board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

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

	public boolean save(BoardVO board) {
		getConn();
		//String sql = "INSERT INTO board VALUES(board_num_seq.NEXTVAL,?,?,?,?,?)";
		String sql = "INSERT INTO board VALUES(board_num_seq.NEXTVAL,?,?,SYSDATE,?,?)";
		/* VALUES(board_seq.NEXTVAL, SYSDATE, ?, ?, ?) */
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println();
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getAuthor());
			//pstmt.setDate(3, board.getrDate());
			pstmt.setString(3, board.getContents());
			pstmt.setInt(4, board.getHits());
			int res = pstmt.executeUpdate();
			System.out.println(sql);

			return res > 0;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeAll();
		}

		return false;
	}

	public boolean saveEdit(BoardVO board) {
		getConn();
		String sql = "UPDATE board SET title=?, contents=?  WHERE bnum=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContents());
			pstmt.setInt(3, board.getbNum());
			int res = pstmt.executeUpdate();

			return res > 0;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeAll();
		}

		return false;
	}

	public List<BoardVO> list() {
		getConn();
		String sql = "SELECT * FROM board ORDER BY bnum";

		List<BoardVO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bNum = rs.getInt("BNUM");
				System.out.println(bNum);
				String title = rs.getString("TITLE");
				String author = rs.getString("AUTHOR");
				java.sql.Date rDate = rs.getDate("RDATE");
				String contents = rs.getString("CONTENTS");
				int hits = rs.getInt("HITS");
				BoardVO board = new BoardVO();
				board.setbNum(bNum);
				board.setTitle(title);
				board.setAuthor(author);
				board.setrDate(rDate);
				board.setContents(contents);
				board.setHits(hits);

				list.add(board);
			}

			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeAll();
		}

		return null;
	}

	public BoardVO find(int bNum, String cmd) {
		int hits = 0;
		if (cmd.equals("findDetail")) {
			hits = upHits(bNum);
		} else if (cmd.equals("findEdit")) {
			hits = checkHits(bNum);
		}
		System.out.println("hits를 확인하는 메세지 : " + hits);
		getConn();
		BoardVO board = new BoardVO();
		String sql = "SELECT * FROM board WHERE bnum=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int fingbNum = rs.getInt("BNUM");
				String title = rs.getString("title");
				String author = rs.getString("AUTHOR");
				java.sql.Date rDate = rs.getDate("RDATE");
				String contents = rs.getString("CONTENTS");

				board.setbNum(fingbNum);
				board.setTitle(title);
				board.setAuthor(author);
				board.setrDate(rDate);
				board.setContents(contents);
				board.setHits(hits);

				return board;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeAll();
		}

		return null;
	}

	private int checkHits(int bNum) {
		getConn();
		String sql = "SELECT * FROM board WHERE bnum=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int hits = rs.getInt("hits");
				return hits;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeAll();
		}
		return 0;

	}

	private int upHits(int bNum) {
		int hits = checkHits(bNum);
		int upHits = ++hits;
		getConn();
		String sql = "UPDATE board SET hits=? WHERE bnum=?";
		/* "UPDATE board SET hits=hits+1 WHERE bnum=?" */

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hits);
			pstmt.setInt(2, bNum);
			int res = pstmt.executeUpdate();
			if (res > 0) {
				return upHits;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			closeAll();
		}
		return 0;

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

}
