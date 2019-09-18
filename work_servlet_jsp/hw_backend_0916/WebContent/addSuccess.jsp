<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addSuccess</title>
<style>
td:nth-child(odd) {
	width: 120px;
	text-align: center;
	font-weight: bold;
}
</style>
</head>
<body>
	<%
		String num = (String) request.getAttribute("num");
		String name = (String) request.getAttribute("name");
		String price = (String) request.getAttribute("price");
		String sub = (String) request.getAttribute("sub");
	%>
	<h1>상품이 저장 되었습니다.</h1>
	<table>
		<tr>
			<td>상품 번호</td>
			<td><%=num%></td>
		</tr>
		<tr>
			<td>상 품 명</td>
			<td><%=name%></td>
		</tr>
		<tr>
			<td>상품 가격</td>
			<td><%=price%></td>
		</tr>
		<tr>
			<td>상품 설명</td>
			<td><%=sub%></td>
		</tr>
	</table>
	<a href="product.do">상품 목록</a>
</body>
</html>