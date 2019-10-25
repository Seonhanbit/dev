<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원 가입</title>
<script type="text/javascript">
	function login() {
		location.href = "loginpage";
	}
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="regist" method="post" id="loginform">
		<table border="1">
			<tr>
				<td>ID</td><td><input type="text" id="id" name="id" required="required"></td>
			</tr>
			<tr>
				<td>PW</td><td><input type="password" id="pw" name="pw" required="required"></td>
			</tr>
			<tr>
				<td>이름</td><td><input type="text" id="name" name="name" required="required"></td>
			</tr>
			<tr>
				<td>주소</td><td><input type="text" id="addr" name="addr" ></td>
			</tr>
			<tr>
				<td><input type="submit" value="회원가입"></td>
				<td><input type="button" value="로그인페이지로 돌아가기" onclick="login()"></td>
			</tr>
		</table>
	</form>
</body>
</html>