<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#loginid{
	top:30px;
	right:30px;
	position:fixed;
	border:1px solid #000;
}
</style>
</head>
<body>
<div id="loginid">
	<h3>LoginID : ${id }</h3>
	<button onclick="logout()">로그아웃</button>
</div>
</body>
</html>