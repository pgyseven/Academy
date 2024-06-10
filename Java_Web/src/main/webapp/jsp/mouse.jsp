<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마우스 쇼핑하기</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
   function cartin(name,price) {
      var param = {};
      param.cmd = 'cartin';
      param.name = name;
      param.price = price;
      
      $.ajax({
         url:'ssc',
         method:'post',
         cache:false,
         data:param,
         dataType:'json',
         success:function(res){
            alert(res.added ? '장바구니에 담기 성공':'실패');
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
   <h3>마우스 구입하기</h3>
   <div>
      [<a href="javascript:cartin('mouse1', 20000);">마우스1 담기</a>]
      [<a href="javascript:cartin('mouse2', 27000);">마우스2 담기</a>]
      [<a href="javascript:cartin('mouse3', 19000);">마우스3 담기</a>]
   </div>
   <div>
      <a href="ssc?cmd=showcart"><button>장바구니보기</button></a>
   </div>
</main>
</body>
</html>