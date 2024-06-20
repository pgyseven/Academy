package com.mbcac.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("서버 진입 확인 메세지"); // http://localhost/Board_Test/board

		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		
		String viewPath = new BoardSvc(request, response).process();
		if (viewPath != null) {
			this.getServletContext().getRequestDispatcher(viewPath).forward(request, response);
		}

	}
}