<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글 쓰기</title>
<style type="text/css">
   main { width:fit-content; margin:0 auto; }
   main h3{width:fit-content; margin:0.5em auto; }
   label {display:inline-block; width:3em; margin:0.3em 0.5em; text-align:right;}
   form { border:1px solid black; padding:1em;}
   form div:last-child {width:fit-content; margin:0.3em auto; }
   input { width:20em;}
   textarea {width:20em; height:7em;margin-top:0.6em;}
   label[for=contents] {display:inline-block; position:relative; top:-3em;}
   nav { text-align:center; }
</style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script type="text/javascript">
   function saveBoard() 
   {
      var serForm = $('#addForm').serialize();
      $.ajax({
         url:'boardAdd.jsp',
         method:'post',
         cache:false,
         data:serForm,
         dataType:'text',
         success:function(res){
            var added = JSON.parse(res.trim()).added;
            alert(added>0 ? '저장 성공':'저장 실패');
            if(added>0) location.href = "boardDetail.jsp?bnum"+added; // added=bnum
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
   <h3>답글 쓰기</h3>
   <form id="addForm">
      <div><label for="title">제목</label>
         <input type="text" name="title" >
      </div>
      <div><label for="author">작성자</label>
         <input type="text" name="author">
      </div>
      <div><label for="contents">글내용</label>
         <textarea name="contents" placeholder="글 입력..."></textarea>
      </div>
      <div>
         <button type="reset">취소</button>
         <button type="button" onclick="saveBoard()">저장</button>
      </div>
   </form>
   <p>
   <nav><a href="hierarchicalBoardList.jsp"><button>목록보기</button></a></nav>
</main>
</body>
</html>