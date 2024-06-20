package com.mbcac.survlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/gugu")
public class GuguServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8"); 
		request.setCharacterEncoding("utf-8");

				String sDan	= request.getParameter("dan");
				String msg = "";
				if(sDan==null||sDan.equals("")){
					msg = "dan 파라미터가 없습니다.";
						}else {
							int dan = Integer.parseInt(sDan);
							for(int i =1;i<=9;i++) {
								msg += String.format("%d*%d=%d<br>", dan, i, dan*i); //웹브라우저는 div 이라 br(break)을 써야 줄바꿈 된다.
							}
						}

				
	
				PrintWriter out = response.getWriter();

				out.println(msg);
				out.println("<a href=\"html/gugu.html\">구구단 요청 페이지로 이동</a>"); // ""문자열 시작과 끝을 나타낼때 쓰는 문자다 근데 html에서는 속성형을 나타내는거니 html에서는 홋따옴표 권장하지 않으니 \역슬레시를 그으면 이거 뒤에 오는 쌍따옴표는 문자열의 끝이 아니야! 즉 기능을 해제 시키는것! \이스케이프 문자다.  즉 html 규격을 만족시키기 위해서 쓴거다 문자열 \역슬래시 안에 넣어주는건 
				out.flush();
				
		
	}

}
