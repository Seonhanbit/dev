<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="member.do" method="post">
		<input type="hidden" name="action" value="addMember">
		이름 : <input type="text" name="name"><br>
		아이디 : <input type="text" name="userid"><br>
		비밀번호 : <input type="password" name="pwd"><br>
		이메일 : <input type="text" name="email"><br>
		전화번호 : <input type="text" name="phone"><br>
		관리자 유무 : 
		<select name="admin">
			<option value="1">관리자</option>
			<option value="0">일반사용자</option>
		</select>
		<br>
		<input type="submit" value="제출">
		<input type="reset" value="취소">
	</form>
</body>
</html>