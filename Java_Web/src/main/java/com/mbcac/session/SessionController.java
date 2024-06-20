package com.mbcac.session;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/ssc")
public class SessionController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8"); 
		request.setCharacterEncoding("utf-8");
		
	    String viewPath = new SessionService(request,response).process();
	      
	    if(viewPath!=null)
	         this.getServletContext().getRequestDispatcher(viewPath).forward(request, response);
	    
	   }

}
