<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<h1>회원 정보</h1>

	<form action="meminsert" method="post" id="memform">
		<table>
			<tr>
				<td>ID :</td>
				<td><input type="text" id="id" name="id" required="required" value="${mem.id }"></td>
			</tr>
			<tr>
				<td>PW :</td>
				<td><input type="password" id="pw" name="pw"
					required="required" value="${mem.pw }"></td>
			</tr>
			<tr>
				<td>이름 :</td>
				<td><input type="text" id="name" name="name"
					required="required" value="${mem.name }"></td>
			</tr>
			<tr>
				<td>e-mail :</td>
				<td><input type="email" id="email" name="email" value="${mem.email }"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" value="초기화"><input
					type="submit" value="제출"></td>
			</tr>
		</table>
	</form>
</body>
</html>