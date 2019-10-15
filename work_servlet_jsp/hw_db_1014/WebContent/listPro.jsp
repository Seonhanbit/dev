<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, edu.ssafy.model.Product"%>
<%
	List<Product> list = (ArrayList<Product>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
</head>
<body>
<div align="center">
	<h1>상품 목록</h1>
	<table border="1">
		<tr>
			<th>상품 번호  </th>
			<th>상품 이름  </th>
			<th>상품 가격  </th>
		</tr>
		<%
			for (int i = 0; i < list.size(); i++) {
		%>
		<tr>
			<td><%=list.get(i).getPno()%></td>
			<td><%=list.get(i).getPname()%></td>
			<td><%=list.get(i).getPprice()%></td>
		</tr>
		<%
			}
		%>		
	</table>
	<a href="index.html">초기화면</a>
	</div>
</body>
</html>