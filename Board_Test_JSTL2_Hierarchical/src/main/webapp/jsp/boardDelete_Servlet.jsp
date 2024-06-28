<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="dao" class="com.mbcac.board.BoardDAO"/>

<c:set var="deleted" value="${dao.delete(param.bnum)}"/>

{"deleted":${deleted}}