
<%@page import="com.mbcac.emp.EUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   EUser eu = (EUser) request.getAttribute("found");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 변경</title>
<style type="text/css">
   main{margin:0.5em auto; padding:1em; width:fit-content;}
   main h3 { text-align:center;}
   div#container{border:1px solid black;  width:fit-content; padding:0.5em;}
   #container>div {border-bottom:1px solid black;}
   label { display:inline-block; width:3em; padding:0.5em; text-align:right; 
         border-right:1px solid black; background-color:#def;}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
   function saveChange() {
      var serData = $('#editEmp').serialize(); 
      //alert(serData)
      $.ajax({
         url:'emp',
         method:'post', 
         cache:false,
         data:serData,
         dataType:'json',
         success:function(res){
            alert(res.updated? '수정 성공' : '수정 실패'); 
            if(res.updated) 
            	location.href="emp?cmd=search&empno=<%=eu.getEmpno()%>";
          
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
   <h3>정보변경</h3>
   <div id="container">
   <form id = "editEmp">
   <input type="hidden" name="cmd" value="update">  <!-- hidden 사용자는 안보이지만 개발자에게 참고하라고 넘겨주는 정보 -->
	<input type="hidden" name="empno" value="<%=eu.getEmpno()%>">
      <div><label>번호</label> <%=eu.getEmpno()%></div>
      <div><label>이름</label> <%=eu.getEname()%></div>
      <div><label>임금</label> 
      <input type="text" name="sal" value="<%=eu.getSal()%>"></div>
            <div><label>이름</label> <%=eu.getHiredate()%></div>
      <div><label>사진</label><img src="/Java_Web/images/<%=eu.getImage()%>.png" alt="사진" width="70" height="70"></div>
   	  </form>
   </div>
     <div>
     [<a href="emp?cmd=list">목록보기</a>]
     [<a href="javascript:saveChange()">저장</a>]
    </div>
</main>
</body>
</html>