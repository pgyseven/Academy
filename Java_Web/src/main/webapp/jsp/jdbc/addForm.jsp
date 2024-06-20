<%@page import="com.mbcac.jdbc.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
   function saveForm() {

      var serDate= $('#addForm').serialize();
      
      //alert(serData)
      $.ajax({
         url:'jdbc',
         method:'post', 
         cache:false,
         data:serDate,
         dataType:'json',
         success:function(res){
            alert(res.saved? '성공' : '실패'); 
            if(res.saved) 
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

   <form id="addForm">
   	  <input type="hidden" name="cmd" value="save">
      <div><label>사번</label>
      <input type="text" name="empno" value=""></div>
      <div><label>이름</label>
      <input type="text" name="ename" value=""></div>
      <div><label>부서</label> 
      <input type="text" name="deptno" value=""></div>
      <div><label>급여</label> 
      <input type="text" name="sal" value=""></div>
      <div><label>입사일</label> 
      <input type="text" name="hiredate" value=""></div>
	  

   </div>
   <button type="reset">취소</button>
   <button type="button" onclick="saveForm()">저장</button>
   </form>
</main>
</body>
</html>