package com.mbcac.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.json.simple.JSONObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmpSvc {

	private HttpServletRequest request; 
	private HttpServletResponse response;
	
	public EmpSvc(HttpServletRequest request, HttpServletResponse response) {
	
		this.request = request;
		this.response = response;
	}

	public String process() {

		String cmd = request.getParameter("cmd");
		System.out.println(cmd);
		if(cmd.equals("empByDeptno"))
		{
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			EmpDAO dao = new EmpDAO();  //DAO database acess 
			dao.empByDeptno(deptno);
			List<EmpVO> list = dao.empByDeptno(deptno);
			request.setAttribute("list", list);
			return "/jsp/jdbc/empList.jsp";
		}
		
		else if(cmd.equals("list"))
		{
			EmpDAO dao = new EmpDAO(); 
			List<EmpVO> list = dao.getList();
			request.setAttribute("list", list);
			return "/jsp/jdbc/empList.jsp";
		}
		
		else if(cmd.equals("detail"))
		{   int empno = Integer.parseInt(request.getParameter("empno"));
			EmpDAO dao = new EmpDAO(); 
			EmpVO emp = dao.empByEmpno(empno);
			request.setAttribute("emp", emp);
			return "/jsp/jdbc/empDetail.jsp";
		}
		else if(cmd.equals("find")) {
			int empno = Integer.parseInt(request.getParameter("empno"));
			EmpDAO dao = new EmpDAO(); 
			EmpVO emp = dao.empByEmpno(empno);
			request.setAttribute("emp", emp);
			return "/jsp/jdbc/empUpdate.jsp";
			
		}
		else if(cmd.equals("update")) {
			int empno = Integer.parseInt(request.getParameter("empno"));
			System.out.println(empno);
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			int sal = Integer.parseInt(request.getParameter("sal"));		
			System.out.println(deptno);
			System.out.println(sal);
			EmpDAO dao = new EmpDAO(); 
			boolean updated = dao.saveUpdate(empno, deptno, sal);
			sendJSON("updated", updated);
			
		}
		else if(cmd.equals("delete")) {
			int empno = Integer.parseInt(request.getParameter("empno"));
			System.out.println(empno);
			EmpDAO dao = new EmpDAO(); 
			boolean deleted = dao.delete(empno);
			sendJSON("deleted", deleted);
			
		}
		else if(cmd.equals("addForm")) {
			return "/jsp/jdbc/addForm.jsp";
		}
		else if(cmd.equals("save")) {
			int empno = Integer.parseInt(request.getParameter("empno"));
			String ename = request.getParameter("ename");
			int sal = Integer.parseInt(request.getParameter("sal"));
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			
			
			
			 String shire = request.getParameter("hiredate");
			    System.out.println(shire);
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			    java.sql.Date hiredate = null;
			    try {
			        hiredate = new java.sql.Date(sdf.parse(shire).getTime());
			    } catch (ParseException e) {
			        e.printStackTrace();
			    }
			
			EmpVO key = new EmpVO();
			key.setEmpno(empno);
			key.setEname(ename);
			key.setSal(sal);
			key.setHiredate(hiredate);
			key.setDeptno(deptno);
			
			EmpDAO dao = new EmpDAO(); 
			
			boolean saved = dao.save(key);
			sendJSON("saved", saved);
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

