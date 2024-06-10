package com.mbcac.survlet;

import java.io.IOException;

import com.mbcac.svc.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardServlet extends HttpServlet 
{
   @Override 
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html; charset=utf-8");
      request.setCharacterEncoding("utf-8");
      
      System.out.println("---서블릿 진입---");
      String viewPath = new BoardService(request,response).process();
      
      if(viewPath!=null)
         this.getServletContext().getRequestDispatcher(viewPath).forward(request, response);
   }

}

