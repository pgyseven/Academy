<%@page import="com.mbcac.jdbc.EmpVO"%>
<%@page import="com.mbcac.jdbc.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 문맥에 해석에 방해가 안되게 자바 코드는 가능하면 다 이곳에 */
	int empno = Integer.parseInt(request.getParameter("empno"));
	EmpDAO dao = new EmpDAO();
	EmpVO emp = dao.empByEmpno(empno);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 상세보기</title>
</head>
<body>
<h3>사원정보 상세보기</h3>
<div>사번 <%=emp.getEmpno() %></div>
<div>이름 <%=emp.getEname() %></div>
<div>급여 <%=emp.getSal() %></div>
<div>부서 <%=emp.getDeptno() %></div>
<div>입사 <%=emp.getHiredate() %></div>
<div>관리자 <%=emp.getMgr() %></div>
</body>
</html>