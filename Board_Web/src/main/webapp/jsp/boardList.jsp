<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mbcac.vo.Board"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@page import="java.util.LinkedHashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	List<Board> list = (List<Board>) request.getAttribute("list"); // (List<Board>)괄호 안에 자료 형이 있는거 형변환 연산자다
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Table 연습</title>
<!--  <style type="text/css"> 
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
	div.search { background-color: #000 } <!-- .은 클래스 셀럭터이다 아래에 보면 아이디와 다르게 클래스로 한것들에 대해서 적용된다. 
	
</style>  
 -->

<style type="text/css">
    @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');
    body {
        font-family: 'Roboto', sans-serif;
        background: linear-gradient(to right, #e96443, #904e95);
        color: #f5f5f5;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    main {
        background-color: rgba(0, 0, 0, 0.7);
        padding: 2em;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        width: 600px;
        text-align: center;
    }
    main h3 {
        margin-bottom: 1em;
        font-size: 1.5em;
        font-weight: 700;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 1em;
    }
    th, td {
        border: 1px solid #ddd;
        padding: 0.5em;
        text-align: center;
    }
    th {
        background-color: #556;
        color: #f5f5f5;
        font-weight: bold;
    }
    td a {
        color: #e96443;
        text-decoration: none;
        transition: color 0.3s ease;
    }
    td a:hover {
        color: #c0392b;
    }
    button {
        background-color: #e96443;
        border: none;
        color: white;
        padding: 0.5em 1em;
        margin: 0.5em 0.25em;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
        font-size: 1em;
    }
    button:hover {
        background-color: #c0392b;
    }
    div.search { background: linear-gradient(to right, #e96443, #904e95);  border-radius: 10px; }
	div.box{ transition-dela}

</style>

</head>
<body>

<%-- <main>
<h3>게시글 목록</h3>


	<table>
	<tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>Hits</th></tr>
<%
		for(int i=0;i<list.size();i++)	{
			Board b =list.get(i); //보드를 하나씩 꺼낸다.
			int num = b.getNum();
			String title = b.getTitle();
			String author = b.getAuthor();
			java.util.Date regDate = b.getRegDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strDate = sdf.format(regDate);
			int hits = b.getHits();
			
%>	
		
			<tr>
			<td><%=num%></td>
			<td><a href="board?cmd=find&no=<%=b.getNum()%>"><%=title%></a></td>
			<td><%=author%></td>
			<td><%=strDate%></td>
			<td><%=hits%></td>
			</tr>
		
			
			
				
	<%	}%>
	
	</table>
	
</main> --%>

<main>
    <h3>게시글 목록</h3>
    <table>
        <tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>Hits</th></tr>
        <% for(int i = 0; i < list.size(); i++) { 
            Board b = list.get(i);
            int num = b.getNum();
            String title = b.getTitle();
            String author = b.getAuthor();
            java.util.Date regDate = b.getRegDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = sdf.format(regDate);
            int hits = b.getHits();
        %>
        <tr>
            <td><%=num%></td>
            <td><a href="board?cmd=find&no=<%=b.getNum()%>"><%=title%></a></td>
            <td><%=author%></td>
            <td><%=strDate%></td>
            <td><%=hits%></td>
        </tr>
        <% } %>
    </table>
    <a href="board?cmd=addForm"><button type="button">새 글 작성</button></a>
	<p> <!-- p는 문단을 나누는 -->
	<div class="search"> <!-- id는 꼭 한개여야 하는데 클래스는 같은 이름이 여러개여도 괜찮다 클래스의 의미 자체가 그룹이니깐 즉 이건 어떤 부류냐의 뜻이다. -->
		<form action="board" method="post">
		<input type="hidden" name="cmd" value="search">
			<div><label>검색 카테고리</label>
				<select name="cat">
					<option value="제목">제목</option>
					<option value="내용">내용</option>
				</select>
				<label>키워드</label>
				<input type="text" name="keyword">
				<button type="submit">검색</button>  <!-- 서브미트 기능이라 폼안에 있는게 보내준다 여기서는 카테고리와 키워드가 넘어간다 액션에 써있는 서블릿으로 -->
			</div>
		</form>
		
	</div>
</main>
</body>
</html>