<%@page import="com.mbcac.pet.PetVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
   List<PetVO> list = (List<PetVO>) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>목록보기</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
   function update(no,idx) {

      var param={};
      param.cmd = 'update';
      param.no = no;
      param.price = $('#price'+idx).val();

      $.ajax({
         url:'pet',
         method:'post', 
         cache:false,
         data:param,
         dataType:'json',
         success:function(res){
            alert(res.updated? '수정 성공' : '수정 실패'); 
            if(res.updated) 
            	location.href="pet?cmd=list";
          
         },
         error:function(xhr,status,err){
            alert('에러:' + err);
         }
      });
   }
   function pDelete(no) {

	      var param={};
	      param.cmd = 'delete';
	      param.no = no;
	    

	      $.ajax({
	         url:'pet',
	         method:'post', 
	         cache:false,
	         data:param,
	         dataType:'json',
	         success:function(res){
	            alert(res.deleted? '삭제 성공' : '삭제 실패'); 
	            if(res.deleted) 
	            	location.href="pet?cmd=list";
	          
	         },
	         error:function(xhr,status,err){
	            alert('에러:' + err);
	         }
	      });
	   }
   
   $(document).ready(function() {
       $('#searchCategory').change(function() {
           var selectedValue = $(this).val();
           if (selectedValue === '가격') {
               /* $('#keywordLabel').text('최소 가격'); */
               $('#keywordInput').hide();
               $('#minPrice').show();
               $('#maxPrice').show();
           } else {
               /* $('#keywordLabel').text('키워드'); */
               $('#keywordInput').show();
               $('#minPrice').hide();
               $('#maxPrice').hide();
           }
       });
   });
   
   <%
	Object objCause = session.getAttribute("cause");
	String cause = ""; //여기를 null 로 하면 loginFrom으로 들어갔을때 null 이라고 뜬다. ""으로 초기화 하는것과 null 이 다르다는 것 인지
	if(objCause!=null)
		cause = (String) objCause;
	session.removeAttribute("cause");
%>
   </script>
   <style type="text/css">
   table {background: linear-gradient(to right, #F6FFCC, #B7F0B1); border:1px solid black; border-collapse: collapse; border-spacing: 0;}  
   
   td { border:1px solid #81BA7B;  width:fit-content; text-align:center;}
   
   </style>
</head>
<body>
<main>
<h3>목록보기</h3>
<table>
<tr><td>번호</td><td>사진</td><td>이름</td><td>나이</td><td>가격</td><td>몸무게</td><td>가격변경</td><td>목록에서 삭제</td></tr>
<%
   for(int i=0;i<list.size();i++) {
      PetVO pet = list.get(i); %>
     
     <tr><td><%=pet.getNo()%></td>
        <td><img src="/Java_Web/images/<%=pet.getName()%>.png" width="100px" ></td><td><%=pet.getName()%></td>
         <td><%=pet.getYear()%></td>
         <td><input type="text" name="price<%=i%>" id="price<%=i%>" value="<%=pet.getPrice()%>"></td> 
         <td><%=pet.getWeight()%></td>
         <td><button type="button" onclick="Javascript:update(<%=pet.getNo()%>,<%=i%>)">수정</button></td>
         <td><button type="button" onclick="Javascript:pDelete(<%=pet.getNo()%>)">삭제</button></td></tr>
         
      
      
<%   }
%>
</table>
<button type="button" onclick="location.href='pet?cmd=addPet'">추가</button>
<div class="search"> 
    <form action="pet" method="post">
        <input type="hidden" name="cmd" value="search">
        <div>
            <label>검색 카테고리</label>
            <select name="cat" id="searchCategory">
                <option value="나이">나이</option>
                <option value="이름">이름</option>
                <option value="가격">가격</option>
            </select>
            <label id="keywordLabel">검색 키워드 </label>
            <input type="text" name="keyword" id="keywordInput">
            <input type="text" name="minPrice" id="minPrice" placeholder="최소 값" style="display:none;">
            <input type="text" name="maxPrice" id="maxPrice" placeholder="최대 값" style="display:none;">
            <button type="submit">검색</button>
        </div>
    </form>
</div>
</main>
</body>
</html>