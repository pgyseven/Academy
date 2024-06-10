<%@page import="java.util.ArrayList"%>
<%@page import="com.mbcac.vo.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedHashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Table 연습</title>
<style type="text/css"> 
	table { border:1px solid black; border-collapse: collapse; border-spacing: 0;}  
	th { border-bottom:3px double black; background-color:#ddd;}
	td { border-bottom:1px solid black;}
	th, td { border-right:1px solid black; padding:0.2em 0.4em; }
	td:nth-child(1) { text-align:center; }
	 /* td:nth-child(1) { text-align:center; } 해당열의 첫 번째 자식 여기서 콜른은 td 이면서 ~~~ 첫 번째 자식   boarder-collapse: 이건 표 외곽 뭉게서 1픽셀로 세련되게 collapse; boarder-spacing:0; td가 겹치면 2픽셀되니 안겹쳐지게 boarder-bootom 아래줄 */
</style> 

</head>
<body>
<%
	String headline = "JSP에서 테이블 사용하기";
	
	List<User> ulist = (List<User>)request.getAttribute("list");  //리퀘스트에서 리스트를 꺼내서 꺼낸걸 리스트로 변경하기 위해 List<User>
	
%>

<h3><%=headline%></h3>
<table>
	<thead>
		<tr><th>번호</th><th>이름</th></tr> <!-- table date 또는 th는 컬럼명 좀 진하게 나온다 table head row 행 -->
	</thead>
	<tbody>
	<%
		for(int i=0;i<ulist.size();i++)	{ //<a href = "http://localhost:8080/user?cmd=find&no=u.getNo"
			User u =ulist.get(i); %>
			<tr><td><a href="user?cmd=find&no=<%=u.getNo() %>"><%=u.getId() %></a></td><td><%=u.getPwd() %></td></tr>	
	<%	}
	%>
	</tbody>
	<tfoot>
	<tr><td colspan="2">여기는 tfoot, 컬럼 합치기의 예</td></tr> <!-- colum span 컬럼 넓이는 2이다. 반대로 위라래 합치는건 row span -->
	</tfoot>
</table>

</body>
</html>