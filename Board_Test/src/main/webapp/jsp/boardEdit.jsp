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
<!-- <style type="text/css">
main {
	margin: 0.5em auto;
	padding: 1em;
	width: fit-content;
}

main h3 {
	text-align: center;
}

div#container {
	border: 1px solid black;
	width: fit-content;
	padding: 0.5em;
}

#container>div {
	border-bottom: 1px solid black;
}

label {
	display: inline-block;
	width: 3em;
	padding: 0.5em;
	text-align: right;
	border-right: 1px solid black;
	background-color: #def;
}
</style> -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<script>
   function saveEdit() {
      var serData = $('#editBoard').serialize(); 
      $.ajax({
         url:'board',
         method:'post', 
         cache:false,
         data:serData,
         dataType:'json',
         success:function(res){
            alert(res.saved? '수정 성공' : '수정 실패'); 
            if(res.saved) 
            	location.href="board?cmd=list"

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
		<container id="">
		<form id="editBoard">
			<input type="hidden" name="cmd" value="saveEdit">
			<input type="hidden" name="bnum" value="<%=board.getbNum()%>">
			<div>
				<label>번호</label>
				<%=board.getbNum()%></div>
			<div>
				<label>제목</label>
				 <input type="text" name="title"
					value="<%=board.getTitle()%>"></div>
			<div>
				<label>작성자</label><%=board.getAuthor()%>
			</div>
			<div>
				<label>작성일</label>
				<%=board.getrDate()%></div>
			<div>
				<label>제목</label>
				 <input type="text" name="contents"
					value="<%=board.getContents()%>"></div>
			<div>
			<div>
				<label>조회수</label>
				<%=board.getHits()%></div>
			<div>
		</form>
		</div>
		<div>
			[<a href="emp?cmd=list">목록보기</a>] [<a href="javascript:saveEdit()">저장</a>]
		</div>
	</main>
</body>
</html>