<%@page import="com.mbcac.jdbc.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 수정</title>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
   function savePet() {
      var petDate= $('#addPet').serialize();
      $.ajax({
         url:'jdbc',
         method:'post', 
         cache:false,
         data:petDate,
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

   <form id="addPet">
   	  <input type="hidden" name="cmd" value="save">
      <div><label>번호</label>
      <input type="text" name="no" value=""></div>
      <div><label>이름(종)</label>
      <input type="text" name="name" value=""></div>
      <div><label>나이</label> 
      <input type="text" name="year" value=""></div>
      <div><label>가격</label> 
      <input type="text" name="price" value=""></div>
      <div><label>몸무게</label> 
      <input type="text" name="weight" value=""></div>
	  

   </div>
   <button type="reset">취소</button>
   <button type="button" onclick="savePet()">저장</button>
   </form>
</main>
</body>
</html>