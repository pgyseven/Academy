<%@page import="com.mbcac.jdbc.EmpVO"%>
<%@page import="com.mbcac.jdbc.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="dao" class="com.mbcac.jdbc.EmpDAO" scope="session"/>
<%-- <c:set var="empno" value="<%=request.getParameter(\"empno\")%>" /> <!-- 따옴표 안에 따옴표가 들어가서 \"이렇게 쓴것 --> --%>
<%-- <c:set var="empno" value="${param.empno}" /> <!--위에꺼를 el로 대체 이것도 스코프 쳐보면 scop page 라고 되어있다 page 영역에 들어감 즉 el 로 불러서 쓸 수 있다.-->
<c:set var="emp" value="${dao.empByEmpno(empno)}" /> --%>
<c:set var="emp" value="${dao.empByEmpno(param.empno)}" /> <!-- 위에꺼 두줄을 요거 한줄로 하면된다.-->
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
   function empDelete(empno)
   { 
      var param = {};
      param.empno = empno
      
      $.ajax
      ({
         url:'empDelete.jsp',
         method:'post',
         cache:false,
         data:param,
         dataType:'text', //이걸 json으로 바꿔두됨 그럼 아래서 제이슨 parse 가 아니라 res.deleted 로 하면됨
         success:function(res)
         {
           var deleted = JSON.parse(res).deleted; /* 제이슨으로 받으면 공백때문에 오류나니 텍스트로 받은거 */
            alert(deleted ? '수정 성공':'수정 실패');
            if(deleted) location.href='empList.jsp';
         },
         error:function(xhr,status,err){alert('에러:' + err);}
      });
   } 
</script>
</head>
<body>
<h3>사원정보 상세보기</h3>
검색 대상 사번 : ${param.empno}
<div>사번 ${emp.empno}</div>
<div>이름 ${emp.ename}</div>
<div>급여 ${emp.sal}</div>
<div>부서 ${emp.deptno}</div>
<div>입사 ${emp.hiredate}</div>
<div>관리자 ${emp.mgr}</div>
<a href="empEdit.jsp?empno=${param.empno}"><button>수정</button></a>
 <button type="button" onclick="empDelete(${emp.empno})">삭제</button>
 <a href="empAdd.jsp"><button>추가</button></a>
</body>
</html>