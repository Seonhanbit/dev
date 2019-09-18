<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!String result;%>
<%
	result = (String) request.getAttribute("result");
	if (result == null) {
		result = request.getParameter("result");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 화면</title>
</head>
<body>
	<h1>결과 내용</h1>
	<h2><%=result%></h2>
	<a href="login.html">로그인</a>
</body>
</html>