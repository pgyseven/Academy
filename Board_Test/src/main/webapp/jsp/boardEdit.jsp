<%@page import="com.mbcac.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
BoardVO board = (BoardVO) request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 변경</title>
<style>
* {
	color: #F6F6F6;
}

body {
	background-color: #212121;
}

main {
	background-color: #3D4045;
	border: 1px solid black;
	width: fit-content;
	margin: 3em auto;
	border-collapse: collapse;
	text-align: center;
	padding:1em;
}

button {
	background: linear-gradient(#FAF4C0, #CEFBC9);
	border-radius: 8px;
	border: none;
	box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.3);
	cursor: pointer;
	color: #353535;
}

textarea {
	width: 10em;
	height: 7em;
	margin-top: 0.6em;
	background-color: #86E57F;
}

body {
	background-color: #212121;
	background-image: url('/Board_Test/images/mel.jpg');
	background-repeat: repeat;
	background-size: 500px;
}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<script>
	function saveEdit() {
		var serData = $('#editBoard').serialize();
		$.ajax({
			url : 'board',
			method : 'post',
			cache : false,
			data : serData,
			dataType : 'json',
			success : function(res) {
				alert(res.saved ? '수정 성공' : '수정 실패');
				if (res.saved)
					location.href = "board?cmd=list"

			},
			error : function(xhr, status, err) {
				alert('에러:' + err);
			}
		});
	}
</script>
</head>
<body>
	<main>
		<h3>수정</h3>
		<form id="editBoard">
			<table>
				<input type="hidden" name="cmd" value="saveEdit">
				<input type="hidden" name="bnum" value="<%=board.getbNum()%>">
				<tr>
					<td>번호</td>
					<td><%=board.getbNum()%></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"
						value="<%=board.getTitle()%>"
						style="width: 10em; background-color: #86E57F;"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><%=board.getAuthor()%></td>
				</tr>
				<tr>
					<td>작성일</td>
					<td><%=board.getrDate()%></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="contents" placeholder="내용"><%=board.getContents()%></textarea></td>
				</tr>
				<td>조회수</td>
				<td><%=board.getHits()%></td>
				</tr>
			</table>
			<div>
				<button type="button" onclick="location.href='board?cmd=list'">목록</button>
				<button type="button"
					onclick="location.href='javascript:saveEdit()'">저장</button>
				<!-- [<a href="board?cmd=list">목록보기</a>] [<a href="javascript:saveEdit()">저장</a>] -->
			</div>
	</main>
</body>
</html>