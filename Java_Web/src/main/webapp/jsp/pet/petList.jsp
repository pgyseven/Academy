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
   </script>
</head>
<body>
<main>
<h3>목록보기</h3>
<%
   for(int i=0;i<list.size();i++) {
      PetVO pet = list.get(i); %>
      <div><%=pet.getNo()%>
        <%=pet.getName()%>
         <%=pet.getYear()%>
         <input type="text" name="price<%=i%>" id="price<%=i%>" value="<%=pet.getPrice()%>"> 
         <%=pet.getWeight()%>
         <button type="button" onclick="Javascript:update(<%=pet.getNo()%>,<%=i%>)">수정</button>
         <button type="button" onclick="Javascript:pDelete(<%=pet.getNo()%>)">삭제</button>
      </div>
      
<%   }
%>

</main>
</body>
</html>