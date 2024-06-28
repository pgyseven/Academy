<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="dao" class="com.mbcac.board.BoardDAO"/>
<jsp:useBean id="board" class="com.mbcac.board.BoardVO">
   <jsp:setProperty name = "board" property="title" param = "title"/>
   <jsp:setProperty name = "board" property="author" param = "author"/>
   <jsp:setProperty name = "board" property="contents" param = "contents"/>
</jsp:useBean>

<c:set var="saved" value="${dao.saveTwo(board)}"/>

<%-- <c:if test="${saved[0]}">
    <c:set var="isSaved" value="true" />
    <c:set var="generatedBNum" value="${saved[1]}" />
</c:if>
<c:if test="${not saved[0]}">
    <c:set var="isSaved" value="false" />
    <c:set var="generatedBNum" value="0" />
</c:if>

{"saved": ${isSaved}, "generatedBNum": ${generatedBNum} } --%>
<%-- <c:set var="saved" value="${dao.save(board)}"/> --%>
{"saved" : ${saved}}