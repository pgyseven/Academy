package com.mbcac.board;

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

		}
		return null;

	}
}