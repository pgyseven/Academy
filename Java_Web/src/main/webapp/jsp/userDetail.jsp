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
<title>이용자 상세정보</title>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script type="text/javascript">
   function deleteUser() {
      if(!confirm("현재 정보를 정말로 삭제하시겠어요?")) return;
      var param = {};
      param.cmd = 'delete',
      param.no = <%=u.getNo()%>;
      $.ajax({
         url:'user',
         method:'get',
         cache:false,
         data:param,
         dataType:'json',
         success:function(res){
            alert(res.deleted ? '삭제 성공':'삭제 실패');
            if(res.deleted) location.href='user?cmd=list';
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
   <h3>이용자 상세정보</h3>
   <div id="container">
      <div><label>번호</label> <%=u.getNo()%></div>
      <div><label>아이디</label> <%=u.getId()%></div>
      <div><label>암호</label> <%=u.getPwd()%></div>
      <div><label>전화</label> <%=u.getPhone()%></div>
      <div><label>이메일</label> <%=u.getEmail()%></div>
   </div>
   <div>
      [<a href="emp?cmd=list">목록보기</a>]
      [<a href="emp?cmd=edit&no=<%=u.getNo()%>">수정</a>]
      [<a href="javascript:deleteUser()">삭제</a>]
   </div>
</main>
</body>
</html>