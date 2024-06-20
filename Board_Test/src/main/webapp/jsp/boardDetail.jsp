<%@page import="com.mbcac.board.BoardVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   BoardVO board = (BoardVO) request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용자 상세정보</title>
<!-- <style type="text/css">
   main{margin:0.5em auto; padding:1em; width:fit-content;}
   main h3 { text-align:center;}
   div#container{border:1px solid black;  width:fit-content; padding:0.5em;}
   #container>div {border-bottom:1px solid black;}
   label { display:inline-block; width:3em; padding:0.5em; text-align:right; 
         border-right:1px solid black; background-color:#def;}
</style> -->

</head>
<body>
<main>
   <h3>글 상세 정보</h3>
   <div id="container">
      <div><label>번호</label><%=board.getbNum()%></div>
      <div><label>제목</label><%=board.getTitle()%></div>
      <div><label>작성자</label><%=board.getAuthor()%></div>
      <div><label>작성일</label><%=board.getrDate()%></div>
      <div><label>내용</label><%=board.getContents()%></div>
      <div><label>조회수</label><%=board.getHits()%></div>

   </div>
   <div>
      [<a href="board?cmd=list">목록보기</a>]
      [<a href="board?cmd=edit&bnum=<%=board.getbNum()%>">수정하기</a>]
   </div>
</main>
</body>
</html>