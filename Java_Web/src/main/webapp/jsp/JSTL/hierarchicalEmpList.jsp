<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="dao" class="com.mbcac.jdbc.EmpDAO"/>
<c:set var="list" value="${dao.list}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 목록(계층구조)</title>
<style type="text/css">
   main { width:fit-content; margin:0.5em auto;}
   main h3 { text-align:center; }
   table {border-spacing:0;border-collapse: collapse; border:1px solid black; }
   tr:nth-child(odd):not(first-child) {background-color:#dfd;}
   tr:hover:not(:first-child) {background-color:gold; }
   td { border-bottom:1px dashed black;}
   th,td {padding:0.3em 1em; text-align:center; border-right:1px solid black;}
   th { border-bottom:3px solid black; background-color:#9f9; }
   td.ename {text-align:left;}
</style>
</head>
<body>
<main>
   <h3>사원정보 목록(계층구조)</h3>
   <table>
   <tr><th>사번</th><th>이름</th><th>입사일</th><th>급여</th><th>부서번호</th></tr>
<c:forEach var="e" items="${list}">
   <tr>
      <td>${e.empno}</td>
      <td class="ename">${e.ename}</td>
      <td>${e.hiredate}</td>
      <td>${e.sal}</td>
      <td>${e.deptno}</td>
   </tr>
</c:forEach>
   </table>
</main>
</body>
</html>