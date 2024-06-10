package com.mbcac.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.mbcac.svc.UserService;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html; charset=utf-8");
      request.setCharacterEncoding("utf-8");
      
      System.out.println("서블릿 창이다.");
      //서블릿은 MVC Controller로 사용되므로 요청을 직접 처리하지 않고 서비스 레이어를
      String viewPath = new UserService(request, response).process();
      
      //제어를 다른 JSP로 전달한다. //이서블릿에서 jsp 연결 //jsp 경로만 잘주면 된다고 생각해라 앞에 코드가 제어권을 jsp에게 주는과정
      if(viewPath!=null)
      this.getServletContext().getRequestDispatcher(viewPath).forward(request, response);
      //서블릿을 실행해주는 환경 즉 톰캣 그리고 서블릿컨택트 객체가 나오는데. 디스팩처 파견 즉 파견보내주는~ 이걸 해야지 뒤에서 포워드 즉 보낼수 있다  그래서 포워드 요청과 주소가 파견에 나와있는 주소로 파견을 보낸다.
      
      
   
   
   
   }
   
   

}