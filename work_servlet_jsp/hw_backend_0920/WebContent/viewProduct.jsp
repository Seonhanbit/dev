<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewProduct</title>
</head>
<body>
	<table border="1">
		<tr>
			<td width="100">등록번호</td>
			<td width="100">${product.num}</td>
		</tr>
		<tr>
			<td width="100">상품명</td>
			<td width="100">${product.name}</td>
		</tr>
		<tr>
			<td width="100">상품가격</td>
			<td width="100">${product.price}</td>
		</tr>
		<tr>
			<td width="100">상품설명</td>
			<td width="100">${product.description}</td>
		</tr>
	</table>
	<c:if test="${empty param.button}">
		<input type="button" value="삭제"
			onclick="location.href='product.do?action=delProduct&num=${product.num}'">
		<br>
		<input type="button" value="리스트 화면으로 이동"
			onclick="location.href='product.do?action=listProduct'">
	</c:if>
</body>
</html>