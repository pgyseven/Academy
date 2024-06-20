package com.mbcac.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import org.json.simple.JSONObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardSvc {

	private HttpServletRequest request;
	private HttpServletResponse response;

	public BoardSvc(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public String process() {
		String cmd = request.getParameter("cmd");
		System.out.println(cmd);
		if (cmd.equals("boardInput")) {
			return "/jsp/boardInput.jsp";

		} else if (cmd.equals("save")) {
			BoardVO board = getParam();
			System.out.println(board.getrDate());
			BoardDAO bio = new BoardDAO();
			boolean saved = bio.save(board);
			sendJSON("saved", saved);
			
		} else if (cmd.equals("list")) {
			List<BoardVO> list = new BoardDAO().list();
			request.setAttribute("list", list);
			return "/jsp/boardList.jsp"; 
		}

		return null;

	}

	private BoardVO getParam() {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		java.util.Date regUtilDate = new java.util.Date();
		System.out.println("날짜 확인하기 입니다." + regUtilDate.toString());
		/* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); */

		java.sql.Date rDate = null;
		try {
			/* rDate = new java.sql.Date(sdf.parse(sdf.format(regUtilDate)).getTime()); */
			rDate = new java.sql.Date(regUtilDate.getTime());
			/* System.out.println(sdf.format(regUtilDate)); */
		} catch (Exception e) {
			e.printStackTrace();
		}
		String contents = request.getParameter("contents");
		int hits = 0;

		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setAuthor(author);
		board.setContents(contents);
		board.setrDate(rDate);
		board.setContents(contents);
		board.setHits(hits);

		return board;
	}

	private void sendJSON(String key, Object value) {
		JSONObject jsObj = new JSONObject();
		jsObj.put(key, value);

		try {
			PrintWriter out = response.getWriter();
			out.print(jsObj.toJSONString());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
