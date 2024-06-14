<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mbcac.jdbc.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
   List<EmpVO> list = (List<EmpVO>) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 목록보기</title>
</head>
<body>
<main>
<h3>사원정보 목록보기</h3>
<%
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   for(int i=0;i<list.size();i++) {
      EmpVO emp = list.get(i); %>
      <div><%=emp.getEmpno()%>
         <%=emp.getEname()%>
         <%=emp.getSal()%>
         <%=sdf.format(emp.getHiredate())%> 
         <%=emp.getDeptno()%>
      </div>
<%   }
%>
</main>
</body>
</html>