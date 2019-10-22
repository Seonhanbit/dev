<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보</title>
</head>
<body>
	<h1>상품 정보</h1>

	<form action="proinsert" method="post" id="memform">
		<table>
			<tr>
				<td>상품번호 :</td>
				<td><input type="text" id="num" name="num" required="required" value="${list.num }"></td>
			</tr>
			<tr>
				<td>상품이름 :</td>
				<td><input type="text" id="name" name="name"
					required="required" value="${list.name }"></td>
			</tr>
			<tr>
				<td>상품가격 :</td>
				<td><input type="text" id="price" name="price" value="${list.price }"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" value="초기화"><input
					type="submit" value="상품 등록"></td>
			</tr>
		</table>
	</form>
</body>
</html>