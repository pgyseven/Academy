<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="dao" class="com.mbcac.board.BoardDAO"/>
<c:set var="list" value="${dao.hierarchicalList}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록(계층구조)</title>
<style type="text/css">
	main { width:fit-content; margin:0.5em auto;}
	main h3 { text-align:center; }
	table {border-spacing:0; border-collapse: collapse; border:1px solid black; }
	tr:nth-child(odd):not(first-child) {background-color:#dfd;}
	tr:hover:not(:first-child) {background-color:gold; }
	td { border-bottom:1px dashed black;}
	th,td {padding:0.3em 1em; text-align:center; border-right:1px solid black;}
	th { border-bottom:3px solid black; background-color:#9f9; }
	td.title {text-align:left;}
	a { color:blue; text-decoration: none; }
</style>
</head>
<body>
<main>
	<h3>게시글 목록(계층구조)</h3>
	<table>
	<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
<c:forEach var="b" items="${list}">
	<tr>
		<td>${b.bnum}</td>
		<td class="title">
			<a href="boardDetail.jsp?bnum=${b.bnum}">${b.title}</a>
		</td>
		<td>${b.author}</td>
		<td>${b.rdate}</td>
	</tr>
</c:forEach>
	</table>
</main>
</body>
</html>