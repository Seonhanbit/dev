<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!String id;%>
<%
	id = (String) request.getAttribute("id");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginSuccess</title>
</head>
<body>
	<h1><%=id%>님 로그인 되었습니다.!!!
	</h1>
	<a href="book.html">도서 등록</a>
	<br>
	<a href="Login.html">로그아웃 </a>
</body>
</html>