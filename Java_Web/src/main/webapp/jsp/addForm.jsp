<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 추가</title>
<style type="text/css">
 main{ border:1px solid black; width:fit-content; margin:0.5em auto; padding:0.5em;}
 main h3 {border:1px solid black; text-align:center} /* 스페이스바 자손 셀렉터 */
 form {border:1px solid black; padding:0.5em; }
 label { border:1px solid black; display:inline-block; width:3em; text-align:right; margin-right:1em;} 
 div:last-child { text-align:center; margin-top:0.5em }

</style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script type="text/javascript">
	function save(){
		var serData = $('#addForm').serialize();
		
		$.ajax({
			url:'emp',
			method:'post',
			cache:false,
			data:serData,
			dataType:'json',
			success:function(res){
				alert(res.saved ? '저장 성공' : '저장 실패')
				if(res.saved){
					
					location.href="emp?cmd=list";
				}
			},
			error:function(xhr,status,err){
				alert('에러: ' + err);
			}
		});

	}

</script>
</head>
<body>

<main>
<h3>사원정보 추가</h3>
	<form id="addForm">
		<input type="hidden" name="cmd" value="add">
		
		<div><label for="empno">사원번호</label>
			<input type="text" name="empno" id="empno" value="1">
		</div>
		<div><label for="ename">사원이름</label>
			<input type="text" name="ename" id="ename" value="smith">
		</div>
		<div><label for="sla">임금</label>
			<input type="text" name="sal" id="sal" value="00000000">
		</div>
		<div><label for="hiredate">입사일</label>
			<input type="text" name="hiredate" id="hiredate" value="20xx년xx월xx일">
		</div>
		<div><label for="image">사진파일명</label>
			<input type="text" name="image" id="image" value="-">
		</div>
		<div>
			<button type="reset">취소</button>
			<button type="button" onclick="save()">저장</button>
		</div>
	</form>
</main>
</body>
</html>