<%@page import="com.mbcac.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<jsp:useBean id="dao" class="com.mbcac.board.BoardDAO" /> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Table 연습</title>
<style type="text/css">
* {
	color: #F6F6F6;
}

main {
	background-image: url('/Board_Test/images/sky.gif');
	background-color: #3D4045;
	border: 1px solid #F6F6F6;
	width: fit-content;
	margin: 3em auto;
	border-collapse: collapse;
	text-align: center;
	padding: 1em;
}

table {
	border: 1px solid #F6F6F6;
	border-collapse: collapse;
	text-align: center;
}

th {
	border: 1px solid #F6F6F6;
	background: #FBB96C;
}

td {
	border: 1px solid #F6F6F6;
}

button {
	background: linear-gradient(#FAF4C0, #CEFBC9);
	border-radius: 8px;
	border: none;
	box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.3);
	cursor: pointer;
	color: #353535;
}

body {
	background-color: #212121;
	background-image: url('/Board_Test/images/mel.jpg');
	background-repeat: repeat;
	background-size: 500px;
}

</style>
</head>
<body>
<div id="train"></div>
	<main>
		<h3>작성글 목록</h3>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>Hits</th>
			</tr>
			<c:forEach var="list" items="${dao.search(param.cat,param.keyword)}">
			<tr>
				<td>${list.bNum}</td>
				<td><a href="boardDetail.jsp?bnum=${list.bNum}&cmd=findDetail">${list.title}</a></td>
				<td>${list.author}</td>
				<td>${list.rDate}</td>
				<td>${list.hits}</td>
			</tr>
			</c:forEach>
		</table>
		<button type="button" onclick="location.href='boardInput.jsp'">새
			글 작성</button>
		<!-- <a href="board?cmd=boardInput"><button type="button"></button></a> -->
	</main>
</body>
</html>