<%@page import="com.mbcac.emp.EUser"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% EUser f = (EUser) request.getAttribute("found"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<!-- <style type="text/css">
   main {width:fit-content; margin:0.5em auto; }
   main h3 { text-align:center; }
   main div#container {border:1px solid black; border-radius:5px; padding:1em;}
   label {display:inline-block; width:3em; background-color:#ddd; 
         text-align:right; padding:0.3em 0.5em; font-weight: bolder;}/* span 태그는 대표적인 인라이 태그이다. 그래서 여기서 인라인을 조정하기 쉽게 블럭으로 한것 */
   label#content {position:absolute; top:0em; height:6.3em; padding-top:4em;} /* 엡솔루트를 하면 없는 샘쳐져서 그옆에 다른 태그가 있다면 없는샘 치니 위치가 겹쳐진다. 엡솔루트는 절대위치로 한다는 건데 현재 태그를 감싸고 있는 부모 태그들이 포지션 속성을 가지고 있으면 그 포지션을 기준으로 움직인다. */
   div:last-child {position:relative; }
   div:last-child span {display:inline-block; width:20em; height:10em;  
      overflow: auto; border:1px dashed black; margin-top:0.5em; 
      margin-left:4.5em;} /* last-child 과 span 사잉이에 공백이 있는데 공백은 자손 셀렉터 이다, 인라인 테그들은 bolck 으로 해야지 폭과 높이가 지정이 가능하다.
      overflow 장문의 문장의 경우 한 화면창에 다 못 띄우니 스크롤바가 생긴다. 자동으로! */
   #container div:not(:last-child) { border-bottom:1px solid black;} /* 아이디가 컨테이너인 자손의 div가 있는 데 not뒤 에 있는 자식들은 빼고!!!! 그외의 딥태그들 을 지정하는것!! */


</style> -->




<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script type="text/javascript">
   function empDel() {
      if(!confirm("현재 정보를 정말로 삭제하시겠어요?")) return;
      var param = {};
      param.cmd = 'delete',
      param.empno = <%=f.getEmpno()%>;
      $.ajax({
         url:'emp',
         method:'get',
         cache:false,
         data:param,
         dataType:'json',
         success:function(res){
            alert(res.deleted ? '삭제 성공':'삭제 실패');
            if(res.deleted) location.href='emp?cmd=list';
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
   <h3>게시글 상세보기</h3>
   <div id="container">
      <div><label>번호</label> <div class="info"><%=f.getEmpno()%></div></div>
      <div><label>이름</label> <div class="info"><%=f.getEname()%></div></div>
      <div><label>임금</label> <div class="info"><%=f.getSal()%></div></div>
      <div><label>입사일</label> <div class="info"><%=f.getHiredate()%></div></div>
      <div><label>사진</label> <div class="info"><img src="/Java_Web/images/<%=f.getImage()%>.png" alt="사진" width="70" height="70"></div>

   </div>
   <div>
      <a href="emp?cmd=list"><button type="button">목록보기</button></a>
      <a href="emp?cmd=edit&empno=<%=f.getEmpno()%>"><button type="button">수정</button></a>
      <a href="javascript:empDel()"><button type="button">삭제</button></a>
   </div>
</main>
</body>
</html>