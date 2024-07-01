<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="dao" class="com.mbcac.board.BoardDAO"/>
<c:set var="b" value="${dao.boardByBnum(param.bnum)}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<style type="text/css">
	main {width:fit-content; margin:0.5em auto; }
	main h3 { text-align:center; }
	main div#container {border:1px solid black; border-radius:5px; padding:1em;}
	label {display:inline-block; width:3em; background-color:#ddd; 
			text-align:right; padding:0.3em 0.5em; font-weight: bolder;}
	label#content {position:absolute; top:0em; height:6.3em; padding-top:4em;}
	div:last-child {position:relative; }
	div:last-child span {display:inline-block; width:20em; height:10em; 
		overflow: auto; border:1px dashed black; margin-top:0.5em; 
		margin-left:4.5em;}
	#container div:not(:last-child) { border-bottom:1px solid black;}
	nav {text-align:center;}
</style>
</head>
<body>
<main>
	<h3>게시글 상세보기</h3>
	<div id="container">
		<div><label>번호</label>
			${b.bnum}
		</div>
		<div><label>제목</label>
			${b.title}
		</div>
		<div><label>작성자</label>
			${b.author}
		</div>
		<div><label>작성일</label>
			${b.rdate}
		</div>
		<div><label id="content">내용</label>
			<span>${b.contents}</span>
		</div>
	</div>
	<p>
	<nav>
		<a href="replyForm.jsp?parent=${b.bnum}">댓글쓰기</a>
		<a href="hierarchicalBoardList.jsp?page=${param.page}&ipp=3"><button>목록보기</button></a>
	</nav>
</main>
</body>
</html>