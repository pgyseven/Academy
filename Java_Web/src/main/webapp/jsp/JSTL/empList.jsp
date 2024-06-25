<%@page import="com.mbcac.jdbc.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<jsp:useBean id="empDao" class="com.mbcac.jdbc.EmpDAO" /> <!-- 여기서 EmpDAO 객체가 생성된거임 jsp로 시작하는건 액션 태그라 한다. 즉 useBean 액션이다. 어떤 기능을 생성하기 때문에 액션이라 한다. 유즈빈 액션 태그를 사용하여 어떠한 객체를 생성할 수 있다. -->
<%--
		
	Model 1 : Servlet 제외, Jsp Java  jsp가 요청을 받아야한다. 받고 화면도 출력한다 모델1은 MVC 불가능하다. 위의 usebean 처럼 java를 불러다 쓴다
	모델1은 쉽고 작은규모 사이트에 많이 쓴다.
	Model 2(MVC) : Servlet,  Jsp, Java
	모델2는 어렵고 큰 규모 프로젝트에 어울린다.
	
	자바를 최대한 덜 쓰고 모델 1을 태그를 이용해서 훈련중이다.
	el은 영역 개체를 다루는데 특화되어 있다.
	items="${empDao.getList()}" 이것도 empDao 를 영역에 있는 것 처럼 바로 쓸 수있다. 위에서 선언한게 다인데! 그 이유는 <jsp:useBean id="empDao" class="com.mbcac.jdbc.EmpDAO" /> 여기/슬래시 앞에 컨트롤 스페이스바 누르면 스코프 있는데 기본이 페이지 영역이고 생략해도 이건 기본으로 페이지 영역으로 들어가기 때문이다. 
	어떤객체를 영역에 두면 el로 쓰기 편하다.
	el을 통해서 empDao 오브젝트를 다루고 있다. 
	
 --%>
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
<div>${e.empno} 
<a href="empDetail_jstl.jsp?empno=${e.empno}">${e.ename}</a> ${hiredate} ${sal}</div></c:forEach>
</body>
</html>