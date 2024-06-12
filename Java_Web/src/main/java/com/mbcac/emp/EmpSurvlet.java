package com.mbcac.emp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.mbcac.session.SessionService;



@WebServlet("/emp")
public class EmpSurvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *Emp:empno,  ename, sal, hiredata, image
	 *CRUD 작성하기
	 *http://localhost:8080/Java_Web/emp?cmd=addForm
	 *cmd=add, cmd=list, cmd=edit&empno=11, cmd=update
	 *cmd=delete&empno=11, cmd=search&empno=11, cmd=searchByName&ename=smith
	 *data file : empList.txt
	 *style, html, css, javascript
	 */
	

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			response.setContentType("text/html; charset=utf-8"); 
			request.setCharacterEncoding("utf-8");
			
		    String viewPath = new EmpService(request,response).process();
		      
		    if(viewPath!=null)
		         this.getServletContext().getRequestDispatcher(viewPath).forward(request, response);
		    
		   }

	}

	