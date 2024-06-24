<%@page import="com.mbcac.jdbc.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<jsp:useBean id="empDao" class="com.mbcac.jdbc.EmpDAO"/> <!-- 여기서 EmpDAO 객체가 생성된거임 jsp로 시작하는건 액션 태그라 한다. 즉 useBean 액션이다. 어떤 기능을 생성하기 때문에 액션이라 한다. 유즈빈 액션 태그를 사용하여 어떠한 객체를 생성할 수 있다. -->
<%-- <%
	List<EmpVO> list = empDao.getList();
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 목록보기</title>
</head>
<body>
<p>
${pageScope.list }
	<h3>사원정보 목록보기</h3>
<c:forEach var="e" items="${empDao.getList()}">
<fmt:formatDate var="hiredate" value="${e.hiredate}" pattern="yyyy-MM-dd"/>  <!-- 닫는 태그 안하려면 오픈테그에 / 이걸 넣어주면 된다. -->
<fmt:formatNumber value="${e.sal}" type="currency" currencySymbol="\\" />  <!-- 역슬레시는 익스케이프 기능이니 그앞에 하나를 더 넣어주면 해당 기능을 제거해서 원화가 됨 -->
<div>${e.empno} ${e.ename} ${hiredate} ${sal}</div></c:forEach>
</body>
</html>