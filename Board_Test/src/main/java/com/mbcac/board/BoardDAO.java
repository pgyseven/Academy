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
		String sql = "INSERT INTO board VALUES(board_num_seq.NEXTVAL,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getAuthor());
			pstmt.setDate(3, board.getrDate());
			pstmt.setString(4, board.getContents());
			pstmt.setInt(5, board.getHits());
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
				board.setbNum(bNum);;
				board.setTitle(title);
				board.setAuthor(author);
				board.setrDate(rDate);
				board.setContents(contents);

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
