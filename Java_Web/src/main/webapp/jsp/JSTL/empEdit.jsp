<%@page import="com.mbcac.jdbc.EmpVO"%>
<%@page import="com.mbcac.jdbc.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="dao" class="com.mbcac.jdbc.EmpDAO" scope="session"/>
<c:set var="emp" value="${dao.empByEmpno(param.empno)}" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 상세보기</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" 
             integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" 
             crossorigin="anonymous">
</script>
<script>
   function empUpdate()
   {
      var serData = $('#updateForm').serialize();
      
      $.ajax
      ({
         url:'empUpdate.jsp',
         method:'post',
         cache:false,
         data:serData,
         dataType:'text',
         success:function(res) 
         {
           var updated = JSON.parse(res.trim()).updated; /* 제이슨으로 받으면 공백때문에 오류나니 텍스트로 받은거 */
            alert(updated ? '수정 성공':'수정 실패');
            if(res.updated) location.href='empDetail_jstl.jsp?empno=${param.empno}';
         },
         error:function(xhr,status,err){alert('에러:' + err);}
      });
   } 
</script>

</head>

           
<body>
<h3>사원정보 상세보기</h3>
검색 대상 사번 : ${param.empno}
<form id = "updateForm">
<input type="hidden" name="empno" value="${emp.empno}">
<div>사번 ${emp.empno}</div>
<div>이름 ${emp.ename}</div>
<div>급여 <input type="text" name="sal" value="${emp.sal}"></div>
<div>부서 <input type="text" name="deptno" value="${emp.deptno}" ></div>
<div>입사 ${emp.hiredate}</div>
<div>관리자 ${emp.mgr}</div>

 <button type="button" onclick="empUpdate()">저장</button>
      <a href="empList.jsp"><button type="button">목록보기</button></a>
</form>
</body>
</html>