<%@page import="com.mbcac.pet.petVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
   List<petVO> list = (List<petVO>) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>사원정보 목록보기</title>

 <style>
    body {
        background-image: url("/Java_Web/images/zzang.png");
  background-repeat: no-repeat;


  
    background-size: cover;
    }
    main {text-align:center;}
</style>

</head>
<body>
<main>
<h3>사원정보 목록보기</h3>
<%
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   for(int i=0;i<list.size();i++) {
      EmpVO emp = list.get(i); %>
      <div><%=emp.getEmpno()%>
         <a href = "jdbc?cmd=detail&empno=<%=emp.getEmpno()%>"><%=emp.getEname()%></a>
         <%=emp.getSal()%>
         <%=sdf.format(emp.getHiredate())%> 
         <%=emp.getDeptno()%>
      </div>
      
<%   }
%>
<div><a href = "jdbc?cmd=addForm">추가</a></div>
</main>
</body>
</html>