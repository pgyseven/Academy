<%@page import="com.mbcac.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<jsp:useBean id="dao" class="com.mbcac.board.BoardDAO" /> 
<c:set var = "pg" value="${dao.getList(param.page)}"/>
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
button.cp { background-color:#dfd; }


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
			<c:forEach var="list" items="${pg.items}">
			<tr>
				<td>${list.bNum}</td>
				<td><a href="boardDetail.jsp?bnum=${list.bNum}&cmd=findDetail">${list.title}</a></td>
				<td>${list.author}</td>
				<td>${list.rDate}</td>
				<td>${list.hits}</td>
			</tr>
			</c:forEach>
		</table>
		  <p>
   <nav>
     <!-- 이전 페이지 버튼 -->
    <a href="boardList.jsp?page=${pg.getPreviousPage()}">
        <button>&lt;</button>
    </a>
      <c:forEach var="p" items="${pg.getPageNums()}">
         <a href="boardList.jsp?page=${p}">
            <c:choose>
               <c:when test="${p==pg.currentPage}">
                    <button class="cp">${p}</button>
                </c:when>
                <c:otherwise>
                    <button>${p}</button>
                </c:otherwise>
            </c:choose>
         </a>
      </c:forEach>
       <!-- 다음 페이지 버튼 -->
    <a href="boardList.jsp?page=${pg.getNextPage()}">
        <button>&gt;</button>
    </a>
   </nav>
				<p> 
		<button type="button" onclick="location.href='boardInput.jsp'">새
			글 작성</button>
		<!-- <a href="board?cmd=boardInput"><button type="button"></button></a> -->

		<p>
		<form action="boardSearch_Servlet.jsp" method="post">
		<input type="hidden" name="cmd" value="search">
			<div><label>검색 카테고리</label>
				<select name="cat">
					<option value="번호">번호</option>
					<option value="제목">제목</option>
				</select>
				<label>키워드</label>
				<input type="text" name="keyword">
				<button type="submit">검색</button> 
			</div>
		</form>
		
	</div>

    </main>
</body>
</html>