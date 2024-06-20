<%@page import="com.mbcac.vo.Board"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   List<Board> list = (List<Board>) request.getAttribute("list");
   String cat = (String) request.getAttribute("cat");
   String key = (String) request.getAttribute("key");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색결과 목록</title>
<!-- <style type="text/css">
   main {width:fit-content; margin:0.5em auto; }
   main h3 {width:fit-content; margin:0.3em auto; }
   table {border:1px solid black; border-spacing: 0; border-collapse: collapse;}
   th { background-color:#def; border-bottom:3px double black;}
   th,td { border-right:1px solid black; padding:0.2em 0.5em;}
   td { border-bottom:1px solid black; }
   td:first-child, td:last-child { text-align:center; }
   td a { text-decoration: none; color:blue; }
   td a:link { color:blue; }
   td a:visited { color:blue; }
   td a:hover { color:red; }
   td a:active { color:gold; }
   div.search { background-color:#cde; padding:0.2em 0.5em;}
   nav { text-align:center; }
</style> -->
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
</style>



<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>

</script>
</head>
<body>
<main>
   <h3>[<%=cat%>]에서 '<%=key%>'으로 검색한 결과</h3>
   <table>
   <tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>Hits</th></tr>
<%
   for(int i=0;i<list.size();i++) {
      Board b = list.get(i);
      int num = b.getNum();
      String title = b.getTitle();
      String author = b.getAuthor();
      java.util.Date regDate = b.getRegDate();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String strDate = sdf.format(regDate);
      int hits = b.getHits(); %>
      <tr>
         <td><%=num%></td>
         <td><a href="board?cmd=detail&num=<%=num%>"><%=title%></a></td>
         <td><%=author%></td>
         <td><%=strDate%></td>
         <td><%=hits%></td>
      </tr>
<%   }
%>
   </table>
   <p>
   <div class="search">
      <form action="board" method="post">
         <input type="hidden" name="cmd" value="search">
         <div><label>검색 카테고리</label>
            <select name="cat">
               <option value="제목">제목</option>
               <option value="내용">내용</option>
            </select>
            <label>키워드</label>
            <input type="text" name="keyword">
            <button type="submit">검색</button>
         </div>
      </form>
   </div>
   <p>
   <nav><a href="board?cmd=list"><button>목록보기</button></a></nav>
</main>
</body>
</html>