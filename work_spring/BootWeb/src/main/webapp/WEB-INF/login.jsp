<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<form action="login" method="post">
		<table border="1">
		<tr>
				<th>아이디</th>
				<th>비밀번호</th>
		</tr>
		<tr>
			<th><input type="text" id="id" name="id" ></th>
			<th><input type="password" id="pw" name="pw"></th>
		</tr>
		<tr>
				<td colspan="2"><input type="reset" value="초기화"><input
					type="submit" value="제출"></td>
		</tr>
		</table>
	</form>
</body>
</html>