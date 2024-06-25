<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="dao" class="com.mbcac.jdbc.EmpDAO"/>
<jsp:useBean id="emp" class="com.mbcac.jdbc.EmpVO">
   <jsp:setProperty name = "emp" property="empno" param = "empno"/>
   <jsp:setProperty name = "emp" property="ename" param = "ename"/>
   <jsp:setProperty name = "emp" property="sal" param = "sal"/>
   <% emp.setHiredate(request.getParameter("hiredate")); %>
</jsp:useBean>


<c:set var="added" value="${dao.save(emp)}"/>
{"added" : ${added}, "empno" : ${emp.empno}}