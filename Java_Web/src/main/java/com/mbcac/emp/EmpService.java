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

	public String process() {
		String cmd = request.getParameter("cmd");
		System.out.println(cmd);
		if (cmd.equals("addForm")) {
			return "/jsp/addForm.jsp";
		} else if (cmd.equals("add")) {
			String sEmpno = request.getParameter("empno");
			String ename = request.getParameter("ename");
			String sal = request.getParameter("sal");
			String hiredate = request.getParameter("hiredate");
			String image = request.getParameter("image");
			int empno = Integer.parseInt(sEmpno);

			EUser emp = new EUser(empno, ename, sal, hiredate, image);

			EmpIO eio = new EmpIO();
			boolean saved = eio.save(emp);
			sendJSON("saved", saved);

		} else if (cmd.equals("list")) {
			EmpIO eio = new EmpIO();
			List<EUser> list = eio.getList();
			request.setAttribute("list", list);
			return "/jsp/empList.jsp";

		} else if (cmd.equals("search")) {
			String sEmpno = request.getParameter("empno");
			String cat = request.getParameter("cat");
			String keyword = request.getParameter("keyword");
			System.out.println(cat);
			System.out.println(keyword);
			
			if(sEmpno!=null) {
			int no = Integer.parseInt(sEmpno);
			EmpIO eio = new EmpIO();
			EUser found = eio.findByNo(no);
			request.setAttribute("found", found);
			return "/jsp/empDetail.jsp";
			}
			
			if(cat!=null)
			{
				EmpIO eio = new EmpIO();
				EUser found = eio.findList(cat, keyword);
				request.setAttribute("found", found);
				return "/jsp/empDetail.jsp";
			}
			
			return null;
			
			
			

		} else if (cmd.equals("edit")) {
			String sEmpno = request.getParameter("empno");
			int no = Integer.parseInt(sEmpno);
			EmpIO eio = new EmpIO();
			EUser found = eio.findByNo(no);
			request.setAttribute("found", found);
			return "/jsp/empEdit.jsp";

		} else if (cmd.equals("update")) {

			/*
			 * String sEmpno = request.getParameter("empno"); System.out.println(sEmpno);
			 * 
			 * String ename = request.getParameter("ename"); System.out.println(ename);
			 * 
			 * String sal = request.getParameter("sal"); String hiredate =
			 * request.getParameter("hiredate"); String image =
			 * request.getParameter("image"); int empno = Integer.parseInt(sEmpno);
			 * System.out.println(empno + ename + sal + hiredate + image);
			 * 
			 * EUser key = new EUser(empno, ename, sal, hiredate, image);
			 */

			String sEmpno = request.getParameter("empno");
			System.out.println(sEmpno);
			String sal = request.getParameter("sal");
			System.out.println(sal);
			int empno = Integer.parseInt(sEmpno);
			EUser key = new EUser();
			key.setEmpno(empno);
			key.setSal(sal);

			EmpIO eio = new EmpIO();
			boolean updated = eio.update(key);
			System.out.println(updated);

			JSONObject jsObj = new JSONObject();
			jsObj.put("updated", updated);

			try {
				PrintWriter out = response.getWriter();
				out.print(jsObj.toJSONString());
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (cmd.equals("delete")) {
			String sEmpno = request.getParameter("empno");
			int empno = Integer.parseInt(sEmpno);

			EmpIO eio = new EmpIO();
			boolean deleted = eio.delete(empno);
			JSONObject jsObj = new JSONObject();
			jsObj.put("deleted", deleted);

			try {
				PrintWriter out = response.getWriter();
				out.print(jsObj.toJSONString());
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;

	}

	private void sendJSON(String key, Object obj) {
		try {
			JSONObject jsObj = new JSONObject();
			jsObj.put(key, obj);
			PrintWriter out = response.getWriter(); // 응답받아야 하는 컴퓨터의 정보가 리스펀스에 있다.
			out.print(jsObj.toJSONString());
			out.flush();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
