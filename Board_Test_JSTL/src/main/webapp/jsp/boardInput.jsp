<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 쓰기</title>
<style>
body {
	background-color: #212121;
}

* {
	color: #F6F6F6;
}

main {
	background-color: #3D4045;
	border: 1px solid #F6F6F6;
	width: fit-content;
	margin: 3em auto;
	border-collapse: collapse;
	text-align: center;
	padding:1em;
}

button {
	background: linear-gradient(#FAF4C0, #CEFBC9);
	border-radius: 8px;
	border: none;
	box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.3);
	cursor: pointer;
	color: #353535;
}

main h3 {
	border: 1px solid black;
	text-align: center
} /* 스페이스바 자손 셀렉터 */
label {
	display: inline-block;
	width: 3em;
	text-align: left;
	margin-right: 5em;
}

div:last-child {
	text-align: center;
	margin-top: 0.5em
}

textarea {
	width: 10em;
	height: 7em;
	margin-top: 0.6em;
	background-color: #86E57F;
}

body {
	background-color: #212121;
	background-image: url('/Board_Test/images/mel.jpg');
	background-repeat: repeat;
	background-size: 500px;
}
</style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
	
<script type="text/javascript">
	function save() {
		var serForm = $('#inputForm').serialize();
		$.ajax({
			url : 'boardInput_Servlet.jsp',
			method : 'post',
			cache : false,
			data : serForm,
			dataType : 'json',
			success : function(res) {
				alert(res.saved!=0 ? '게시글 저장 성공' : '게시글 저장 실패');
				if (res.saved)
					location.href = 'boardDetail.jsp?bnum='+res.saved+'&cmd=findEdit';
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
			<div>
				<label for="title">제목</label> <input type="text" name="title"
					value="제목" style="width: 10em; background-color: #86E57F;">
			</div>
			<div>
				<label for="author">작성자</label> <input type="text" name="author"
					value="작성자" style="width: 10em; background-color: #86E57F;">
			</div>
			<div>
				<label for="contents">내용</label>
				<textarea name="contents" placeholder="내용"></textarea>
			</div>
			<div>
				<button type="reset">취소</button>
				<button type="button" onclick="save()">저장</button>
				<button type="button" onclick="location.href='board?cmd=list'">목록</button>

			</div>
		</form>
	</main>

</body>
</html>