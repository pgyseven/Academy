<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.mbcac.session.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   List<Item> list = (List<Item>) request.getAttribute("list");
   int total = (Integer) request.getAttribute("total");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 구매목록 보기</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script type="text/javascript">
   function itemChange(itemName,price, idx) {
      var param = {};
      param.cmd = 'itemChange';
      param.itemname = itemName;
      param.price = price;
      param.qty = $('#qty'+idx).val();
      
      $.ajax({
         url:'ssc',
         method:'post',
         cache:false,
         data:param,
         dataType:'json',
         success:function(res){
            alert(res.changed ? '장바구니 상품변경 성공':'실패');
            if(res.changed) location.href="ssc?cmd=showcart";
         },
         error:function(xhr,status,err){
            alert('에러:' + err);
         }
      });
   }
   
   
   function delItem(itemName, price) {
	   if(!confirm("항목을 삭제하시겠어요?")) return;
	      var param = {};
	      param.cmd = 'delItem';
	      param.itemname = itemName;
	      param.price = price;
	      
	      $.ajax({
	         url:'ssc',
	         method:'post',
	         cache:false,
	         data:param,
	         dataType:'json',
	         success:function(res){
	            alert(res.deleted ? '삭제 성공':'삭제 실패');
	            if(res.deleted) location.href="ssc?cmd=showcart";
	         },
	         error:function(xhr,status,err){
	            alert('에러:' + err);
	         }
	      });
	   }
   
   
   
   
   
/* 상품명과 단가가가 한상품의 오브젝트니깐 이걸 함쳐서 배열로 만들고 제이슨 오브젝트로!!!!!!!!!!!!!!!!!!!!!!!!배열의 원소가 [여기서 시작해서 ]여기로 끝나는 그안에 많은 제이슨 오브젝트가 있다 프라이스와 이름을 아이템 오브젝트로 만들어야한다.
   [] 빈배열 cheched 체크가 되었다면으로 해석 제이슨 오브젝트는  {}
   push 배열에는 자바스크립트에서는 push 임 */
   function delBatch() {
	   if(!confirm("항목을 삭제하시겠어요?")) return;

	      var cbarr = document.querySelectorAll('input[type=checkbox]'); //인풋타입이 셀렉터가 가르키는 체크박스인걸 모두 가져와라 현재의 다큐먼트 현재의 웹페이지에서 가져와서 cbarr로 객체의 참조 배열로 다루게!
	      var jsArr = [];
	      let checkCnt=0;
	      
	      cbarr.forEach(function(cb){ //cb는 이름없는 함수 익명 함수 그게 하나씩 아래를 돌거다 cbarr 에서 하나씩 나와서!!! cbarr 객체에 대한 어떠한 함수로 자바스크립는 for문을 가지고 있다  즉 cbarr 을 다루기 위한 함수
	         if(cb.checked) { //그게 체크 되었다면 {} 안의 작업을 해라
	            var jsobj = {};
	            let idx = cb.value; //이건 인덱스 i 번호 여기서 let을 쓰나 var 쓰나 의미 없다 var는 함수 스코프고 let은 {} 블록 스코프다 var는 밖에서도 쓸수 있다. var 변수선언 키워드임  let 도 변수선언 키워드지만 스코프가 작다 지역변수이다.
	            jsobj.itemname = $('#itemname'+idx).val(); //$('#itemname'+idx)  태그의 .val() 값을 가져온다.
	            jsobj.price = $('#price'+idx).val();
	            jsArr.push(jsobj); //자바그크립의 배열은 리스트와 같다.
	         }
	      });
	      if(checkCnt==0){
	    	  alert('선택된 항목이 없습니다.')
	    	  return;
	      }
	     /*  alert(JSON.stringify(jsArr)); //제이슨 문자 모양의 문자열 화 해봐라 제이슨 문자열은 다시 제이슨 오브젝트 변환이 가능하다.  */
	     var param = {};
	     param.cmd = 'delBatch';
	     param.deljs = JSON.stringify(jsArr);
	     $.ajax({
	         url:'ssc',
	         method:'post',
	         cache:false,
	         data:param,
	         dataType:'json',
	         success:function(res){
	            alert(res.deleted ? '삭제 성공':'삭제 실패');
	            if(res.deleted) location.href="ssc?cmd=showcart";
	         }
	        
	      });
	     
	     
	   }
   
   
   
   function cartEmpty() {
	   if(!confirm("항목을 삭제하시겠어요?")) return;

	      var cbarr = document.querySelectorAll('input[type=checkbox]'); 
	      var jsArr = [];
	      
	      cbarr.forEach(function(cb){ 
		            var jsobj = {};
		            let idx = cb.value; 
		            jsobj.itemname = $('#itemname'+idx).val(); 
		            jsobj.price = $('#price'+idx).val();
		            jsArr.push(jsobj); //자바그크립의 배열은 리스트와 같다.
		         
		      });
		    
		     var param = {};
		     param.cmd = 'delBatch';
		     param.deljs = JSON.stringify(jsArr);
		     $.ajax({
		         url:'ssc',
		         method:'post',
		         cache:false,
		         data:param,
		         dataType:'json',
		         success:function(res){
		            alert(res.deleted ? '삭제 성공':'삭제 실패');
		            if(res.deleted) location.href="ssc?cmd=showcart";
		         }
		        
		      });
		     
		     
		   }
   
   
   
   function order() {
	   
		   if(!confirm("주문을 완료할까요?")) return;
		      var param = {};
		      param.cmd = 'order';

		      
		      $.ajax({
		         url:'ssc',
		         method:'post',
		         cache:false,
		         data:param,
		         dataType:'json',
		         success:function(res){
		            alert(res.ordered ? '주문 성공':'주문 실패');
		            if(res.ordered) location.href="ssc?cmd=showcart";
		         }
		      });
		   }
	      
	</script>



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

    
   main { text-align:center;}
   table {margin:0.3em auto; border:1px solid black; border-spacing: 0; border-collapse: collapse;}
   th {background-color:#abc; border-bottom:3px double black; }
   th,td { padding:0.3em; border-right:1px solid black;}
   td {border:1px solid black; padding:0.2em 0.5em; }
   td:nth-child(even) { text-align:right; }  /*  td 인데 (even)짝수 번째 차일드 즉 여기서는 단가 '열'과 '계' 열 */
   tr:last-child td:first-child{text-align:right; }  /* 마지막 tr 안에 첫번째 td */
   input {width:3em;}
  
  
</style>
</head>

<body>
<main>
   <h3>장바구니 구매목록 보기</h3>
 <table>
      <tr><th>상품명</th><th>단가</th><th>수량</th><th>계</th>
         <th><button type="button" onclick="delBatch()">삭제</button></th>
      </tr>

   <%
   NumberFormat nf = NumberFormat.getCurrencyInstance( Locale.KOREA); /* 돈의 단위에 세자기 마다 , 찍어주는 기능 넘버 포맷 클래스를 사용하고 돈의 인스턴스 생성하고 그 단위는 한국의 돈으로 */
      for(int i=0;i<list.size();i++){
         Item item = list.get(i); 
         int price = item.getPrice();
         int qty = item.getQty();
   %>

    <tr>
            <input type="hidden" id="itemname<%=i%>" value="<%=item.getGname()%>">
            <input type="hidden" id="price<%=i%>" value="<%=item.getPrice()%>">
            
            <td><%=item.getGname()%></td>
            <td><%=nf.format(price)%></td>
            <td><input type="number" min="1" value="<%=qty%>" name="qty<%=i%>" id="qty<%=i%>">
             <%-- 위에 이기능 넣을 수 있다.onchange 누르면 실시한다 뒤에 명령한거를   onchange ="itemChange('<%= item.getGname() %>', <%=price%>, <%= i%> )" --%>
               <button type="button" onclick="itemChange('<%=item.getGname()%>',<%=price%>, <%=i%>)">적용</button>
            </td>
            <td><%=nf.format(price*qty)%></td>
            <td><input type="checkbox" value="<%=i%>"></td>
         </tr>
   <%   }
   %>
      <tr><td colspan="3">구매 총금액</td><td colspan="2"><%=nf.format(total)%></td></tr>
   </table>
   <p>
   <nav>
      <a href="ssc?cmd=showIndex"><button>메뉴 페이지로 이동</button></a>
      <a href="ssc?cmd=mouse"><button>마우스 쇼핑</button></a>
      <a href="ssc?cmd=memory"><button>메모리 쇼핑</button></a>
      <a href="ssc?cmd=cartEmpty"><button>지우기2</button></a>
      <a href="javascript:cartEmpty()"><button>장바구니 비우기</button></a>
      <a href="javascript: order()"><button>주문</button></a>
   </nav>
</main>
</body>
</html>