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
</head>
<body>
<main>
   <h3>장바구니 구매목록 보기</h3>
   <table>
      <tr><th>상품명</th><th>단가</th><th>수량</th><th>계</th></tr>
   <%
      for(int i=0;i<list.size();i++){
         Item item = list.get(i); 
         int price = item.getPrice();
         int qty = item.getQty();
   %>
         <tr>
            <td><%=item.getGname()%></td>
            <td><%=price%></td>
            <td><%=qty%></td>
            <td><%=price*qty%></td>
         </tr>
   <%   }
   %>
      <tr><td colspan="3">구매 총금액</td><td><%=total%></td></tr>
   </table>
</main>
</body>
</html>