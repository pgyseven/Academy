<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="dao" class="com.mbcac.jdbc.EmpDAO"/>

<jsp:useBean id="emp" class="com.mbcac.jdbc.EmpVO">
   <jsp:setProperty name="emp" property="*"/>  
</jsp:useBean>

<c:set var="updated" value="${dao.update(emp.empno)}"/>

{"updated":${updated}}