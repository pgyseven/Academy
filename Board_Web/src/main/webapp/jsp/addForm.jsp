<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 쓰기</title>
<!-- <style type="text/css">
   main { width:fit-content; margin:0 auto; }
   main h3{width:fit-content; margin:0.5em auto; }
   label {display:inline-block; width:3em; margin:0.3em 0.5em; text-align:right;}
   form { border:1px solid black; padding:1em;}
   form div:last-child {width:fit-content; margin:0.3em auto; }
   input { width:20em;}
   textarea {width:20em; height:7em;margin-top:0.6em;}
   label[for=contents] {display:inline-block; position:relative; top:-3em;}
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
    form {
        display: flex;
        flex-direction: column;
    }
    label {
        text-align: left;
        margin-bottom: 0.5em;
        font-weight: bold;
    }
    input, textarea {
        width: 100%;
        padding: 0.5em;
        margin-bottom: 1em;
        border: 1px solid #ddd;
        border-radius: 5px;
    }
    textarea {
        resize: none;
    }
    button {
        background-color: #e96443;
        border: none;
        color: white;
        padding: 0.5em 1em;
        margin: 0.5em;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
        font-size: 1em;
    }
    button:hover {
        background-color: #c0392b;
    }
</style>


<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script type="text/javascript">
   function saveBoard() 
   {
      var serForm = $('#addForm').serialize();
      $.ajax({
         url:'board',
         method:'post',
         cache:false,
         data:serForm,
         dataType:'json',
         success:function(res){
            alert(res.saved ? '게시글 저장 성공':'저장 실패');
         },
         error:function(xhr,status,err){
            alert('에러:' + err);
         }
      });
   }
</script>
</head>
<body>
<!-- <main>
   <h3>게시글 쓰기</h3>
   <form id="addForm">
      <input type="hidden" name="cmd" value="save">
      <div><label for="title">제목</label>
         <input type="text" name="title">
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
</main> -->

<main>
    <h3>게시글 쓰기</h3>
    <form id="addForm">
        <input type="hidden" name="cmd" value="save">
        <div>
            <label for="title">제목</label>
            <input type="text" name="title">
        </div>
        <div>
            <label for="author">작성자</label>
            <input type="text" name="author">
        </div>
        <div>
            <label for="contents">글내용</label>
            <textarea name="contents" placeholder="글 입력..."></textarea>
        </div>
        <div>
            <button type="reset">취소</button>
            <button type="button" onclick="saveBoard()">저장</button>
        </div>
    </form>
</main>

</body>
</html>