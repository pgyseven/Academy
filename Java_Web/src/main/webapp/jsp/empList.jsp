<%@page import="com.mbcac.emp.EUser"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Table 연습</title>


</head>
<body>
<%

	
	List<EUser> eList = (List<EUser>)request.getAttribute("list");  //리퀘스트에서 리스트를 꺼내서 꺼낸걸 리스트로 변경하기 위해 List<User>
	
%>

<h3>사원 목록</h3>
<table>
	<thead>
		<tr><th>번호</th><th>이름</th><th>임금</th><th>입사일</th><th>사진</th></tr> 
	</thead>
	<tbody>
	<%
		for(int i=0;i<eList.size();i++)	{ 
			EUser eu =eList.get(i); %>
			<tr><td><%=eu.getEmpno()%></td><td><%=eu.getEname()%></td><td><%=eu.getSal()%></td>
			<td><%=eu.getHiredate()%></td><td><img src="/Java_Web/images/<%=eu.getImage()%>.png" alt="사진" width="5" height="5"></a></td></tr>	
	<%	}
	%>
	</tbody>
	<tfoot>

	</tfoot>
</table>

</body>
</html>