<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addProduct</title>
</head>
<body>
	<form action="product.do" method="post">
		<input type="hidden" name="action" value="addProduct"> 상품명: <input
			type="text" name="name" maxlength="20"><br> 상품가격: <input
			type="text" name="price" maxlength="9"><br> 상품설명: <input
			type="text" name="description" maxlength="100"><br> <br>
		<input type="submit" value="상품 등록">
	</form>
	<input type="button" value="리스트 화면으로 이동"
		onclick="location.href='product.do?action=listProduct'">
</body>
</html>