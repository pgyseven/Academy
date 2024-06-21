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
/* div#train {
    background-image: url('/Board_Test/images/sky.gif');
    background-size: cover; /* 이미지 크기 조정 */
    /* background-repeat: no-repeat; */
    width: 100%; /* 가득 채우기 */
    height: 100%; /* 원하는 높이 설정 */
    position: absolute; /* 절대 위치 설정 */
    top: 0; /* 상단에 배치 */
    left: 0; /* 좌측에 배치 */
    z-index: -1; /* 배경 이미지를 main 요소 뒤로 보냄 */
} */
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
			<%
			for (int i = 0; i < list.size(); i++) {
				BoardVO board = list.get(i);
				int bNum = board.getbNum();
				String title = board.getTitle();
				String author = board.getAuthor();
				java.sql.Date rDate = board.getrDate();
				int hits = board.getHits();
			%>
			<tr>
				<td><%=bNum%></td>
				<td><a href="board?cmd=findDetail&bnum=<%=board.getbNum()%>"><%=title%></a></td>
				<td><%=author%></td>
				<td><%=rDate%></td>
				<td><%=hits%></td>
			</tr>
			<%
			}
			%>
		</table>
		<button type="button" onclick="location.href='board?cmd=boardInput'">새
			글 작성</button>
		<!-- <a href="board?cmd=boardInput"><button type="button"></button></a> -->
	</main>
</body>
</html>