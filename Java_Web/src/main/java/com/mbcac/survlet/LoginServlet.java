package com.mbcac.survlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;

import com.mbcac.svc.LoginService;


@WebServlet("/login")  //호출하는거
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("LoginServlet service() 실행됨");
		
		response.setContentType("text/html; charset=utf-8"); //응답을 하는데 브라우저가 이해하게 응답해줘야한다. 
		//지금 응답하는건 텍스트고 그포멧은 html이다. 문자 집잡은 유티에프 8이다 즉 영문한자!
		request.setCharacterEncoding("utf-8");
		//요청할때 데이터들은 유티에프 8이다. 이두개는 항상 해준다고 생각해라
		
		String jsStr = new LoginService(request, response).process(); //아래 두줄 한줄 버전
	     
	     //LoginService svc = new LoginService(request, response);
	     //String jsStr = svc.process();
	     
	     /*
	      String id = request.getParameter("id"); //헤더에서 뒤져서 아이디를 가져와라
	      String pwd = request.getParameter("pwd"); //원래는 이것도 다른곳으로 빼는게 좋다 한곳에만 속성된 기능은 좋지 않다.
	     
	      //MVC Design Pattern 코드를 쪼개자 유지보수가 편하도록 성능은 떨어지지고 개발은 힘들지만 비용이 제일 많이 드는 유지보수를 쉽게하기 위해서 그리고 성능도 그렇게까지 떨어지지는 않는다.
	      
	      /*클래스를 몇개로 나누는 기준이 될 것이다.  아래서 모델은 데이터 모델을 말한다. 데이터를 클래스로 모델링한거, 즉 VO 클래스 같은거 
	       *
	       * model : 프로그램에서 처리할 데이터를 클래스로 모델링(VO, DAO), 데이터 위주의 클래스들 
	       * view : 화면에 표시되는 내용(html, css, javascript) 화면 위주의 클래스들 창~
	       * controller : 요청을 접수하고 다른 콤포넌트를 연결하여 흐름 제어,  위 두개를 연결하는 통제자 이자 브릿지 역활 , 서블릿을 이야기 하는것 
	       * Service :   아래처럼 연산하는거
	       
	      
	      //원래는 이전에 아래에서는 로그인 성공 여부를 판가름 하지만 원래는 서블릿은 컨트롤러로 관문이다 즉 무언가를 실행하기 위한 컨트롤러 역할을 해야한다. 통제자 일의 흐름을 관리하는~ 로그인 하면 로그인 담당자 이리오세요! 이런느낌이다.
	      */
	    
	      PrintWriter out = response.getWriter();
	      out.print(jsStr);
	      out.flush();
	   }

	}