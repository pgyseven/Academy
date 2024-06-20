<%@page import="com.mbcac.board.BoardVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@page import="java.util.LinkedHashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Table 연습</title>
<!-- <style type="text/css"> 
   main{width:fit-content; margin : 0.5em auto;}
   main h3{width:fit-content; margin:0.3em auto;}
   table { border:1px solid black; border-collapse: collapse; border-spacing: 0;}  
   th { border-bottom:3px double black; background-color:#abd;}
   td { border-bottom:1px solid black;}
   th, td { border-right:1px solid black; padding:0.2em 0.4em; }
   td:nth-child(1) { text-align:center; }
   td:nth-child(5) { text-align:center; }
   td a{text-decoration:none; color:blue; }
   td a:link { color:blue; }
   td a:visited {color:blue;}
   td a:hover{color:red;}
   td a:active{ color: gold;}  
	div.search { background-color: #000 }  <!-- .은 클래스 셀럭터이다 아래에 보면 아이디와 다르게 클래스로 한것들에 대해서 적용된다. 
	
</style>   -->
</head>
<body>
<main>
    <h3>목록</h3>
    <table>
        <tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>Hits</th></tr>
        <% for(int i = 0; i < list.size(); i++) { 
            BoardVO board = list.get(i);
            int bNum = board.getbNum();
            String title = board.getTitle();
            String author = board.getAuthor();
            java.sql.Date rDate = board.getrDate();
            int hits = board.getHits();
        %>
        <tr>
            <td><%=bNum%></td>
            <td><%=title%></td>
            <td><%=author%></td>
            <td><%=rDate%></td>
            <td><%=hits%></td>
        </tr>
        <% } %>
    </table>
    <a href="board?cmd=boardInput"><button type="button">새 글 작성</button></a>
</main>
</body>
</html>