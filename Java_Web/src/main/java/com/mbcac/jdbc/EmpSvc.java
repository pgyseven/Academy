package com.mbcac.jdbc;

import java.util.List;

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
		if(cmd.equals("empByDeptno"))
		{
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			EmpDAO dao = new EmpDAO();  //DAO database acess 
			dao.empByDeptno(deptno);
			List<EmpVO> list = dao.empByDeptno(deptno);
			request.setAttribute("list", list);
			return "/jsp/jdbc/empList.jsp";
		}
		
		
		
		
		return null;
	}

}
