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
</style>  -->

<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	function save() {
		var serForm = $('#inputForm').serialize();
		$.ajax({
			url:'board',
			method:'post',
			cache:false,
			data:serForm,
			dataType:'json',
			success:function(res) {
				alert(res.saved ? '게시글 저장 성공' : '게시글 저장 실패');
				if (res.saved) location.href='board?cmd=list';
			},
			error : function(xhr, status, err) {
				alert('에러:' + err);
			}
		});
	}
</script>
</head>
<body>
	<main>
		<h3>게시글 쓰기</h3>
		<form id="inputForm">
			<input type="hidden" name="cmd" value="save">
			<div>
				<label for="title">제목</label> <input type="text" name="title" value="제목">
			</div>
			<div>
				<label for="author">작성자</label> <input type="text" name="author" value="작성자">
			</div>
			<div>
				<label for="contents">내용</label>
				<textarea name="contents" placeholder="내용"></textarea>
			</div>
			<div>
				<button type="reset">취소</button>
				<button type="button" onclick="save()">저장</button>
			</div>
		</form>
	</main>

</body>
</html>