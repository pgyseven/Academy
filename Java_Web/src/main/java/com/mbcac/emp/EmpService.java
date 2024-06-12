package com.mbcac.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.simple.JSONObject;


import com.mbcac.fio.FileIO;

import com.mbcac.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmpService 

{
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public EmpService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	   public String process() 
	   {
	      String cmd = request.getParameter("cmd");
	      
	      if(cmd.equals("addForm"))
	      {
	         return "/jsp/addForm.jsp";
	      }
	      else if(cmd.equals("add"))
	      {
	    	  String sEmpno = request.getParameter("empno");
	    	  String ename = request.getParameter("ename");
	    	  String sal = request.getParameter("sal");
	    	  String hiredate = request.getParameter("hiredate");
	    	  String image =  request.getParameter("image");
	    	  int empno = Integer.parseInt(sEmpno);
	          
	          EUser emp = new EUser(empno,ename,sal,hiredate,image);

	         EmpIO eio = new EmpIO();
	         boolean saved = eio.save(emp);
	         sendJSON("saved", saved);
	      }
	      
	      else if(cmd.equals("list")) 
	      {
	         EmpIO eio = new EmpIO();
	         List<EUser> list = eio.getList();
	         request.setAttribute("list", list);
	         return "/jsp/empList.jsp";
	      }
	      
	      
	      
		return null;

	   }

	private void sendJSON(String key, Object obj)
	{
		try {
			JSONObject jsObj = new JSONObject();
			jsObj.put(key,obj);
			PrintWriter out = response.getWriter(); //응답받아야 하는 컴퓨터의 정보가 리스펀스에 있다.
			out.print(jsObj.toJSONString());
			out.flush();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}

}
