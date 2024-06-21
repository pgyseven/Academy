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
   main {width:fit-content; margin:0.5em auto; }
   main h3 { text-align:center; }
   main div#container {border:1px solid black; border-radius:5px; padding:1em;}
   label {display:inline-block; width:3em; background-color:#ddd; 
         text-align:right; padding:0.3em 0.5em; font-weight: bolder;}/* span 태그는 대표적인 인라이 태그이다. 그래서 여기서 인라인을 조정하기 쉽게 블럭으로 한것 */
   label#content {position:absolute; top:0em; height:6.3em; padding-top:4em;} /* 엡솔루트를 하면 없는 샘쳐져서 그옆에 다른 태그가 있다면 없는샘 치니 위치가 겹쳐진다. 엡솔루트는 절대위치로 한다는 건데 현재 태그를 감싸고 있는 부모 태그들이 포지션 속성을 가지고 있으면 그 포지션을 기준으로 움직인다. */
   div:last-child {position:relative; }
   div:last-child span {display:inline-block; width:20em; height:10em;  
      overflow: auto; border:1px dashed black; margin-top:0.5em; 
      margin-left:4.5em;} /* last-child 과 span 사잉이에 공백이 있는데 공백은 자손 셀렉터 이다, 인라인 테그들은 bolck 으로 해야지 폭과 높이가 지정이 가능하다.
      overflow 장문의 문장의 경우 한 화면창에 다 못 띄우니 스크롤바가 생긴다. 자동으로! */
   #container div:not(:last-child) { border-bottom:1px solid black;} /* 아이디가 컨테이너인 자손의 div가 있는 데 not뒤 에 있는 자식들은 빼고!!!! 그외의 딥태그들 을 지정하는것!! */


</style> -->
<style>
* {
	color: #F6F6F6;
}

body {
	background-color: #212121;
}

main {
	background-color: #3D4045;
	border: 1px solid #F6F6F6;
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

label#content {
	position: absolute;
	top: 0em;
	height: 6.3em;
	padding-top: 4em;
}

table {
	border: 1px solid #F6F6F6;
	border-collapse: collapse;
	text-align: center;
}

td {
	border: 1px solid #F6F6F6;
}
td:first-child{background-color:#FBB96C;}

body {
	background-color: #212121;
	background-image: url('/Board_Test/images/mel.jpg');
	background-repeat: repeat;
	background-size: 500px;
}
</style>
</head>
<body>
	<main>
		<h3>글 상세 정보</h3>
		<table>

			<tr>
				<td>번호</td>
				<td><%=board.getbNum()%></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><%=board.getTitle()%></td>
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
				<td><%=board.getContents()%></td>
			</tr>
			<tr>
				<td>조회수</td>
				<td><%=board.getHits()%></td>
			</tr>

		</table>
		<div>
			<button type="button" onclick="location.href='board?cmd=list'">목록</button>
			<button type="button"
				onclick="location.href='board?cmd=findEdit&bnum=<%=board.getbNum()%>'">수정</button>
			<%-- [<a href="board?cmd=list">목록보기</a>]
      [<a href="board?cmd=findEdit&bnum=<%=board.getbNum()%>">수정하기</a>] --%>
		</div>
	</main>
</body>
</html>