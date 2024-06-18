<%@page import="com.mbcac.pet.PetVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
   List<PetVO> list = (List<PetVO>) request.getAttribute("list");
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
 
   for(int i=0;i<list.size();i++) {
      PetVO emp = list.get(i); %>
      <div><%=emp.getNo()%>
         <%=emp.getsName()%>
         <%=emp.getYear()%>
         <%=emp.getPrice()%> 
         <%=emp.getWeight()%>
      </div>
      
<%   }
%>
<div>추가</div>
</main>
</body>
</html>