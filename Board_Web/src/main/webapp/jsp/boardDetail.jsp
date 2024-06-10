<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.mbcac.vo.Board"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   Board b = (Board) request.getAttribute("found");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String strDate = sdf.format(b.getRegDate());

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세정보</title>
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

<style type="text/css">
    @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');
    body {
        font-family: 'Roboto', sans-serif;
        background: linear-gradient(to right, #e96443, #904e95);
        color: #f5f5f5;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    main {
        background-color: rgba(0, 0, 0, 0.7);
        padding: 2em;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        width: 400px;
        text-align: center;
    }
    main h3 {
        margin-bottom: 1em;
        font-size: 1.5em;
        font-weight: 700;
    }
    #container {
        margin-bottom: 1em;
    }
    #container > div {
        margin-bottom: 0.5em;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 0.5em;
        border-bottom: 1px solid #ddd;
    }
    label {
        font-weight: bold;
        flex-basis: 30%;
    }
    .info {
        background-color: #333;
        padding: 0.5em;
        border-radius: 5px;
        flex-basis: 65%;
        text-align: left;
    }
    button {
        background-color: #e96443;
        border: none;
        color: white;
        padding: 0.5em 1em;
        margin: 0.5em 0.25em;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
        font-size: 1em;
    }
    button:hover {
        background-color: #c0392b;
    }
    a {
        text-decoration: none;
    }
</style>


<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script type="text/javascript">
   function deleteBoard() {
      if(!confirm("현재 정보를 정말로 삭제하시겠어요?")) return;
      var param = {};
      param.cmd = 'delete',
      param.no = <%=b.getNum()%>;
      $.ajax({
         url:'board',
         method:'get',
         cache:false,
         data:param,
         dataType:'json',
         success:function(res){
            alert(res.deleted ? '삭제 성공':'삭제 실패');
            if(res.deleted) location.href='board?cmd=list';
         },
         error:function(xhr,status,err){
            alert('에러:' + err);
         }
      });
   }
</script>

</head>
<body>
<%-- <main>
   <h3>게시글 상세보기</h3> <!-- h는 웹브라우저 행 전체를 차지하는 블록형이다. 그래서 마진으로는 제어가 안된다 그러니 알맹이 글자를 조정해야한다. 그래서 text-aligh을 사용한다. 또는 h를 축소를 해서 하는 방법도 있다  -->
  <div id="container">
      <div><label>번호</label>
         <%=b.getNum()%>
      </div>
      <div><label>제목</label>
         <%=b.getTitle()%>
      </div>
      <div><label>작성자</label>
         <%=b.getAuthor()%>
      </div>
      <div><label>작성일</label>
         <%=strDate%>
      </div>
      <div><label>Hits</label>
         <%=b.getHits()%>
      </div>
      <div><label id="content">내용</label>
         <span><%=b.getContents()%></span>
      </div>
   </div>

   <div>
   	
      <a href="board?cmd=list"><button type="button">목록보기</button></a>  <!-- 온클릭은 스크립트를 돌릴때 쓴다. 폼안에다가 버튼을 누르면 폼에 종속되어서 폼을 보내버린다. 즉 폼의 기능이 되어 폼에 종속된 버튼이된다. -->
      <a href="board?cmd=edit"><button type="button">수정</button></a>
      <a href="javascript:deleteBoard()"><button type="button">삭제</button></a>
   </div>
</main> --%>
<main>
   <h3>게시글 상세보기</h3>
   <div id="container">
      <div><label>번호</label> <div class="info"><%=b.getNum()%></div></div>
      <div><label>제목</label> <div class="info"><%=b.getTitle()%></div></div>
      <div><label>작성자</label> <div class="info"><%=b.getAuthor()%></div></div>
      <div><label>작성일</label> <div class="info"><%=strDate%></div></div>
      <div><label>Hits</label> <div class="info"><%=b.getHits()%></div></div>
      <div><label>내용</label> <div class="info" style="height: 10em; overflow: auto;"><%=b.getContents()%></div></div>
   </div>
   <div>
      <a href="board?cmd=list"><button type="button">목록보기</button></a>
      <a href="board?cmd=edit&no=<%=b.getNum()%>"><button type="button">수정</button></a>
      <a href="javascript:deleteBoard()"><button type="button">삭제</button></a>
   </div>
</main>
</body>
</html>