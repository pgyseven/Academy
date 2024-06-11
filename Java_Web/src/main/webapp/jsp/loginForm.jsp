<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
<style type="text/css">
 main{ border:1px solid black; width:fit-content; margin:0.5em auto; padding:0.5em;}
 main h3 {border:1px solid black; text-align:center} /* 스페이스바 자손 셀렉터 */
 form {border:1px solid black; padding:0.5em; }
 label { border:1px solid black; display:inline-block; width:3em; text-align:right; margin-right:1em;} 
 div:last-child { text-align:center; margin-top:0.5em }

</style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script type="text/javascript">
	function login(){
		var serData = $('#loginForm').serialize();
		console.log('폼 데이터 직렬화: ' + serData);
		$.ajax({
			url:'ssc',
			method:'post',
			cache:false,
			data:serData,
			dataType:'json',
			success:function(res){
				alert(res.ok ? '로그인 성공' : '로그인 실패')
				if(res.ok){
					location.href="ssc?cmd=showIndex";
				}
			},
			error:function(xhr,status,err){
				alert('에러: ' + err);
			}
		});
		
		
		
		
	}
<%
	Object objCause = session.getAttribute("cause");
	String cause = ""; //여기를 null 로 하면 loginFrom으로 들어갔을때 null 이라고 뜬다. ""으로 초기화 하는것과 null 이 다르다는 것 인지
	if(objCause!=null)
		cause = (String) objCause;
	session.removeAttribute("cause");
%>

var cause = '<%=cause%>'; /* "요청하신 기능은 로그인 후에 사용할 수 있습니다."; */
if(cause!='')
	alert(cause);
</script>
</head>
<body>

<main>
<h3>로그인</h3>
	<form id="loginForm">
		<input type="hidden" name="cmd" value="login">
		<div><label for="id">아이디</label>
			<input type="text" name="id" id="id" value="smith">
		</div>
		<div><label for="pwd">암호</label>
			<input type="password" name="pwd" id="pwd" value="pwsmith">
		</div>
		<div>
			<button type="reset">취소</button>
			<button type="button" onclick="login()">로그인</button>
		</div>
	</form>
</main>
</body>
</html>