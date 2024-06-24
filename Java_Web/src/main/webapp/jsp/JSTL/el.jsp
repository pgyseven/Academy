

<%@page import="com.mbcac.jdbc.Emp"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   <!-- 태그의 접두를 결정 코어의 약자로 C 그리고 이 접두어로 아래서 쓸거다 이렇게 쓰면 태그 라이브러리 쓸 준비 완료 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <!-- 포맷의 약자로 많이 쓴다 fmt 그리고 날짜를 출력하기 위한 것이다.-->



<%

		/* 
			영역 오브젝트(Scope Object)
			page 영역				pageContext  jsp 페이지 마다 있음 가장 좁은 영역임 다른 페이지와 공유 안됨 1개의 jsp나 1개의 서블릿 jsp는 서블릿이라는 개념이니깐 
			request 영역			request		요청할 때마다 포워드 되는 영역과 그 주최되는것 요청이 처리되고 나면 사라짐
			session 영역			session		이용자가 접속할 때마다 한사람이 지나다니는 곳 사이트에서 활동안하고 30분 지나면
			application 영역 		application  서버에 1개뿐인임 즉 누구나 다 공유할 수 있는 영역 톰캣을 켜면 생성되고 톰캣이 정리되면 사라짐
			
			이 JSP 는 MVC 에 해당 안되니 바로 돌려도 된다.
			
			큰 사이트를 만들때는 지금 까지 우리가 배운 모델 2를 쓰고 소규모 사이트는 지금 이페이지 처럼 jsp를 통해서 요청하고 응답도 jsp가! 즉 서블릿을 안쓰는 모델 1의 방식으로 한다.
			
		*/
		List<String> sList = new ArrayList<>();
		sList.add("홍길동");
		sList.add("박세리");
		sList.add("이재문");
		sList.add("윤성렬");
		sList.add("안문식");
		 
		//pageContext.setAttribute("list", sList); 페이지 영역으로 저장 페이지 영역으로 저장했다는건 다른곳에서 안쓸거란것 el은 영역을 중점으로 꺼내주는 역할

		Date today = new Date();
		
		Emp emp = new Emp();
		emp.setEmpno(7369);
		emp.setEname("smith");
		emp.setSal(2800);
		emp.setHiredate(new Date());
%>
<c:set var="list" value="<%=sList %>" scope="page"></c:set>
<c:set var="emp" value="<%=emp %>" scope="session"></c:set>
<c:set var="list" value="<%=sList %>" scope="page"></c:set> <!-- 결국 서버 쪽에서 자바로 봐뀐다. 페이지 영역에 리스트라는 이름으로 slist를 저장하겠다. c 프리픽스 접두어 set 태그 이렇게 하면 위에 주석처리 된 pageContext.setAttribute("list", sList);  이것과 같은 기능을 한다.-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Test</title>
</head>
<body>
	<h3>EL Test</h3>
	<%
	for(int i=0;i<sList.size();i++){
		String name = sList.get(i); %>
		<div><%=name %></div>
	<%}
	%>
<hr> <!-- horizㅐn 수평선 -->
<!-- EL : Expression Language 출력 전용 언어이다 영역에 있는 데이터를 가져다가 출력하기 위한, 오로지 jsp에서만 돌아간다. 확장자가 .html에서는 안 돌아간다. 꼭 .jsp여야함 -->
${list} <!-- 영역에 저장되면 이름만 가지고도 접근이 가능하다 -->
<p>
${pageScope.list } <%-- 영역을 지정해 줄 수 있다! 세션 스코프, 어플리케이션등을 할 수 있다 현재로서는 위와 같은것이다. ${list} 가장 낮은 영역부터 찾아간다. 그러나 영역을 지정하면 해당 영역만 검생하고 끝낸다 즉 성능이 빠를 수 있다. --%> 
<!-- 이와 같은건 한줄로 출력되는데 이걸 위에서 처럼 Java 처럼 한문장씩 꺼내쓰는 언어 jstl이다. 자바코드를 대신하는 언어고 자바코드가 본 화면에 안보일 것이다. 라이브러리가 필요하다. 다운 받고 위에 선언을 해야한다. -->

<p>
<h1>태그로 포문 돌리기</h1> <%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<c:forEach var="name" items="${list}"> <!-- sList이걸 퍼센트 씌어서 해도 된다. 태그를 이용하여 많은 루브 돌리기 많은 데이터를 원소 한개 한개를 출력하겠다 items 데이터가 있는 컬렉션은 어디에 있냐? 영역에 있는 원소가 하나씩 name으로 넘어오고 그리고 name 이름으로 영역에 저장하게 된다 이런걸 jstl 변수라한다. -->
	 <div>${name}</div> <!-- 에어서 영역에 저장했으니 el 로 접근가능하기에 이렇게 할 수 있다. -->
</c:forEach>

<p>
<h1>데이트 포맷 태그로 날짜 출력하기</h1> <%-- 위에서 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 지정 필수--%>
<div>오늘은 <%=today %> 입니다.</div> 
<fmt:formatDate var="today" value="<%=today %>" pattern="yyyy-MM-dd HH:mm:ss"/> <!-- 이건 today 변수에 저장해라 라는것 아랫줄과 다르게 출력하란 말이 아님! -->
<div>오늘은<fmt:formatDate value="<%=today %>" pattern="yyyy-MM-dd HH:mm:ss"/></div>
<div>날짜 ${today}</div>

<p>
<h1>넘버 포맷 태그로 숫자 출력하기</h1>
<c:set value="123456" var="price"></c:set> <!-- 페이지 영역에 프라이스라는 이름으로 123456을 저장한다. 영역에 저장하기 기능 표시가 없으면 가장 작은 영역 페이지 영역에 저장 스코프 따로 넣어도 되지만 디폴트로 빼고 쓴다 -->
금액 : <fmt:formatNumber value="${price}" type="currency" currencySymbol="\\"></fmt:formatNumber> <!-- 참고로 달러는 하나만 해도 된다. -->

<p>
<h1>개체 속성 출력 객체 쉽게 쓰기 get set 안쓰고</h1>
<div>사원정보 사번:${emp.empno}, 이름:${emp.ename}</div>
급여 <fmt:formatNumber value="${emp.sal}" type="currency" currencySymbol="\\"></fmt:formatNumber>
입사 <fmt:formatDate value="${emp.hiredate}" pattern="yyyy-MM-dd HH:mm:ss"/>

</body>
</html>