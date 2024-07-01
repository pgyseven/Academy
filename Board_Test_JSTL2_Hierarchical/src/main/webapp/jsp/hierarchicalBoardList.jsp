<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="dao" class="com.mbcac.board.BoardDAO"/>
<c:set var="pg" value="${dao.getHierarchicalList(param.page,param.ipp)}"/>

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
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="list" items="${pg.items}">
			<tr>
				<td>${list.bnum}</td>
				<td><a href="boardDetail.jsp?bnum=${list.bnum}&cmd=findDetail&page=${pg.currentPage}">${list.title}</a></td>
				<td>${list.author}</td>
				<td>${list.rdate}</td>
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
         <a href="hierarchicalBoardList.jsp?page=${p}&ipp=3">
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
    <a href="hierarchicalBoardList.jsp?page=${pg.getNextPage()}&ipp=3">
        <button>&gt;</button>
    </a>
   </nav>
   
   <p> 
		<button type="button" onclick="location.href='addForm.jsp'">새
			글 작성</button>
		

		<p>
	
</main>
</body>
</html>