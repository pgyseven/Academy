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
<title>사원정보 수정</title>
<style>
   div.container { width:fit-content; }
   .container>div { border-bottom:1px solid black;}
   .container>div:nth-child(odd) {background-color:#cde; }
   label {display:inline-block; width:3em; text-align:right; padding:0.2em 1em; font-weight: bolder;}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
   function empUpdate() {

      var serDate= $('#updateForm').serialize();
      
      //alert(serData)
      $.ajax({
         url:'jdbc',
         method:'post', 
         cache:false,
         data:serDate,
         dataType:'json',
         success:function(res){
            alert(res.updated? '수정 성공' : '수정 실패'); 
            if(res.updated) 
            	location.href="jdbc?cmd=list";
          
         },
         error:function(xhr,status,err){
            alert('에러:' + err);
         }
      });
   }
   function deleted(empno) {
	      var param = {}; 
	      param.cmd = 'delete';
	      param.empno = empno;
	      $.ajax({
	         url:'jdbc',
	         method:'post', 
	         cache:false,
	         data:param,
	         dataType:'json',
	         success:function(res){
	            alert(res.deleted? '성공' : '실패'); 
	            if(res.deleted) 
	            	location.href="jdbc?cmd=list";
	          
	         },
	         error:function(xhr,status,err){
	            alert('에러:' + err);
	         }
	      });
	   }
</script>
</head>
<body>
<main>
   <h3>사원정보 수정</h3>

   <form id="updateForm">
   
      <input type="hidden" name="cmd" value="update">
      <input type="hidden" name="empno" value="<%=emp.getEmpno()%>">
      <div><label>사번</label><%=emp.getEmpno()%></div>
      <div><label>이름</label><%=emp.getEname()%></div>
      <div><label>부서</label> 
      <input type="text" name="deptno" value="<%=emp.getDeptno()%>"></div>
      <div><label>급여</label> 
      <input type="text" name="sal" value="<%=emp.getSal()%>"></div>


   </div>
   <button type="reset">취소</button>
   <button type="button" onclick="empUpdate()">적용</button>
   <button type="button" onclick="deleted(<%=emp.getEmpno()%>)">삭제</button>
   </form>
</main>
</body>
</html>