<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원님 환영합니다.</title>
<!-- <script type="text/javascript">
   function checkbox_test()
   {
	  /*  모든 데이터는 문자열로 보내면 보낼수 있고 그걸 제이슨으로 만들면 뭐든 보낼 수 있다. 체크박스 오브젝트를 제이슨으로 만들고 제이슨 문자로 만든다. */
	   var cbarr = document.querySelectorAll('input[type=checkbox]');  /* 웹문서 다큐멘트 객체를 이용하여 즉 현재 웹페이지에서 셀렉터 문법을사용하여 query 질의를 한다.   CSS 셀렉터 문법  셀렉터인데 속성 셀렉터 인풋테그인데 타입속성이 체크박스로 되어있는것 이런거 만족하는 모든걸 All 가져온다 그럼 이건 배열이 될것이다. */
	  /*  다수의 오브젝트가 든 배열이 cbarr */
	   var cbjs = {};
	   cbarr.forEach(function(cb) {
		   //console.log(cb.value + "->" + cb.checked);
		   	//체크박스의 상태를 JSON 오브젝트로 표현해보세요.
		   	cbjs[cb.value] = cb.checked;   /* cbjs[cb.value] 이게 키가 되고 cb.checkd 체크가 되었나 안되었나는 벨류가 된다.  객체란 개념언 그 언어에 종속된거 그래서 아래서 텍스트로 바꾼다.*/
		   	
		   	함수가 eaxh 함수가 함수를 받은거 function
		   
 	});
 	/* cbarr <<배열 원소를 each 가각의 원소를 for 반복해서 주겠다 (원소 만큼 반복되는 for 루프) function 익명 함수 이름없는 함수다 외부에서 호출할게 아니기 때문에! 이름없는 원소 이함수는 원소가 한개씩 넘어오면 받는 용 이 함수 블록에서는 이 원소를 처리하는 로직이 들어간다. */
	
 	console.log(JSON.stringify(cbjs)); /*  JSON 자바스크립트에서 기본제공 */
 	/* 여기서 제이슨 오브젝트 생성 제이슨 오브젝트가 다른 언어로 가면 해석 안되니 텍스트로 바꿔줘야함 */
 
   
   
   }
   
   
 </script> -->
</head>
<body>
<main>
	<h3>메뉴 페이지</h3>
	<div>
		<a href="ssc?cmd=mouse">마우스 쇼핑 페이지</a>
	</div>
	<div>
		<a href="ssc?cmd=memory">메모리 쇼핑 페이지</a>
	</div>
	<div>
		<a href="ssc?cmd=monitor">모니터 쇼핑 페이지</a>
	</div>
	<p>
  <!-- <div id="div1">
      Java<input type="checkbox" value="java" id="java">
      HTML<input type="checkbox" value="html" id="html">
      CSS<input type="checkbox" value="css" id="css">
      Javascript<input type="checkbox" value="javascript" id="javascript">
      Python<input type="checkbox" value="python" id="python">
   </div>
   <div>
      <button type="button" onclick="checkbox_test()">확인</button>
   </div> -->

</main>
</body>
</html>