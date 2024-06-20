<%@page import="com.mbcac.emp.EUser"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록</title>
<!-- 제이커리 함수중에 $ 제이쿼리 레디 함수 두번째 $ 모든함수가 돌아갈 모든 준비가 되면 그때 이게 돌아간다. 달라안에 바로 선언되어 있는 함수가 레디함수 즉 제이커리 함수안에 익명 함수가 선언되면 이 함수 자체를 제이쿼리 레디함수라하고 html 이 전체가 객체화 되어 돌아갈 준비가 되면 한번 돌아감 
td.name 여기서 점은 클래스 셀렉터이다. 테블안에  td에 있는 클래스가 name에 on 이벤트 핸들러 ~~할 때 마우스가 올라가면 어디로? 이름위로 그때 evt의 타겟 마우스가 올라각 객체 target의 텍스트 즉 마우스가 올라가 있는 사원의 이름! 아이디가 픽펴인 태그의 속석에 이미지를 붙어준다.
아우스가 올라간 곳의 사원이름을 가져와 이미지 경로에 넣어서
img src 속성에 이름을 가져가 경로를 구성하여  img 태그에는 속성 값으로 맨아래는 안보이지만 src 속성이 있는거고 펑션에서 그 안보이는 속성을 가리킨거다 -->

<style type="text/css">
       /* body 스타일 */
    body {
        font-family: 'Roboto', sans-serif; /* 전체 텍스트에 적용되는 폰트 설정 */
        background: linear-gradient(to right, #E4F7BA, #BDBDBD); /* 그라데이션 배경 설정 */
        color: #f5f5f5; /* 텍스트 색상 설정 */
        margin: 0; /* 바깥쪽 여백 제거 */
        padding: 0; /* 내부 여백 제거 */
        display: flex; /* 요소들을 플렉스 박스로 설정하여 내부 정렬 용이하게 함 */
        flex-direction: column; /* 요소들을 세로로 정렬하기 위해 column으로 설정 */
        justify-content: center; /* 가로축(주축)을 기준으로 가운데 정렬 */
        align-items: center; /* 세로축(교차축)을 기준으로 가운데 정렬 */
        height: 100vh; /* 화면의 100% 높이를 차지하도록 설정 */
    }

    /* 테이블 스타일 */
    table {
        text-align: center; /* 테이블 내부 텍스트를 가운데 정렬 */
    }

    /* h3 스타일 */
    h3 {
        text-align: center; /* h3 텍스트를 가운데 정렬 */
    }

    /* #picture 스타일 */
    #picture {
        margin-top: 20px; /* 이미지와 테이블 사이의 간격을 조절 */
    }
</style>
 

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function(){
		$("td.name").on('mouseover', function(evt){
			let name =evt.target.innerText;
			$('img#picture').attr("src", "/Java_Web/images/"+name+".png");
			
		});
	});
</script>

</head>



<body>
<%

	
	List<EUser> eList = (List<EUser>)request.getAttribute("list");  //리퀘스트에서 리스트를 꺼내서 꺼낸걸 리스트로 변경하기 위해 List<User>
	
%>

<h3>사원 목록</h3>

<table>
	<thead>
		<tr><th>번호</th><th>이름</th><th>임금</th><th>입사일</th><th>사진</th></tr> 
	</thead>
	<tbody>
	<%
		for(int i=0;i<eList.size();i++)	{ 
			EUser eu =eList.get(i); %>
			<tr><td><a href="emp?cmd=search&empno=<%=eu.getEmpno()%>"><%=eu.getEmpno()%></a></td><td class="name"><%=eu.getEname()%></td><td><%=eu.getSal()%></td>
			<td><%=eu.getHiredate()%></td><td><img src="/Java_Web/images/<%=eu.getImage()%>.png" alt="사진" width="70" height="70"></td></tr>	
	<%	}
	%>
	</tbody>
	<tfoot>

	</tfoot>
</table>
	<p> 

		<form action="emp" method="post">
		<input type="hidden" name="cmd" value="search">
			<div><label>검색 카테고리</label>
				<select name="cat">
					<option value="사번">사번</option>
					<option value="이름">이름</option>
				</select>
				<label>키워드</label>
				<input type="text" name="keyword">
				<button type="submit">검색</button> 
			</div>
		</form>
		
	</div>
<p>
<img id="picture" width="250" height="250">

</body>
</html>