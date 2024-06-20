<%@page import="com.mbcac.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   User u = (User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용자 정보 변경</title>
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
      var serData = $('#editForm').serialize(); 
      //alert(serData)
      $.ajax({
         url:'user',//유저라는 서블릿으로 보내겠다.
         method:'post', //<!-- 요청 방식은 겟과 포스트가 있는데, 마우스 클릭 링크 클릭 하는건 겟방식을 쓰는 편이고 대부분 폼은 포스트를 쓴다.서버로 전송 할 수 있게 양식을 맞춤 액션 속성과 메소드 속성은 폼에만 있다 즉 폼이 있어야 제출할 수 있다. -->
         cache:false,
         data:serData,
         dataType:'json',
         success:function(res){
            alert(res.updated?'수정 성공': '수정 실패');  //제이슨 오브젝트니깐 res하고. 점을 찍고 사용할 수 있다.
            if(res.updated) location.href='user?cmd=find&no=<%=u.getNo()%>';
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
   <h3>이용자 정보변경</h3>
   <div id="container">
   <form id = "editForm">
   <input type="hidden" name="cmd" value="update">  <!-- hidden 사용자는 안보이지만 개발자에게 참고하라고 넘겨주는 정보 -->
   <input type="hidden" name="no" value="<%=u.getNo()%>">
      <div><label>번호</label> <%=u.getNo()%></div>
      <div><label>아이디</label> <%=u.getId()%></div>
      <div><label>암호</label> <%=u.getPwd()%></div>
      <div><label>전화</label> 
      	<input type="text" name="phone" value="<%=u.getPhone()%>"></div>
      <div><label>이메일</label> 
      	<input type="text" name="email" value="<%=u.getEmail()%>"></div>
   	  </form>
   </div>
     <div>
     [<a href="user?cmd=list">목록보기</a>]
     [<a href="javascript:saveChange()">저장</a>]
    </div>
</main>
</body>
</html>