<%@page import="com.mbcac.jdbc.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   EmpVO emp = (EmpVO) request.getAttribute("emp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 상세보기</title>
<style>
   div.container { width:fit-content; }
   .container>div { border-bottom:1px solid black;}
   .container>div:nth-child(odd) {background-color:#cde; }
   label {display:inline-block; width:3em; text-align:right; padding:0.2em 1em; font-weight: bolder;}
</style>
</head>
<body>
<main>
   <h3>사원정보 상세보기</h3>
   <div class="container">
      <div><label>사번</label><%=emp.getEmpno()%></div>
      <div><label>이름</label><%=emp.getEname()%></div>
      <div><label>부서</label><%=emp.getDeptno()%></div>
      <div><label>급여</label><%=emp.getSal()%></div>
      <div><label>입사</label><%=emp.getHiredate()%></div>
      <div><label>MGR</label><%=emp.getMgr()%></div>
      <div><label>COMM</label><%=emp.getComm()%></div>
      <div><label>JOB</label><%=emp.getJob()%></div>
   </div>
   <div> <a href = "jdbc?cmd=find&empno=<%=emp.getEmpno()%>">수정</a></div>
</main>
</body>
</html>