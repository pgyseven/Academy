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
<title>목록보기</title>
   <style>
   table { border:1px solid black; border-collapse: collapse; border-spacing: 0;}  
   
   td {border:1px solid black;  width:fit-content; text-align:center;}
   
   </style>
</head>
<body>
<main>
<h3>검색보기</h3>
<table>
<tr><td>번호</td><td>사진</td><td>이름</td><td>나이</td><td>가격</td><td>몸무게</td></tr>
<%
   for(int i=0;i<list.size();i++) {
      PetVO pet = list.get(i); %>
     
     <tr><td><%=pet.getNo()%></td>
        <td><img src="/Java_Web/images/<%=pet.getName()%>.png" width="100px" ></td><td><%=pet.getName()%></td>
         <td><%=pet.getYear()%></td>
         <td><input type="text" name="price<%=i%>" id="price<%=i%>" value="<%=pet.getPrice()%>"></td> 
         <td><%=pet.getWeight()%></td>

<%   }
%>
</table>
<button type="button" onclick="location.href='pet?cmd=list'">돌아가기</button>

</main>
</body>
</html>