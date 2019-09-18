<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!String msg;%>
<%
	msg = (String) request.getAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginError</title>
</head>
<body>
	<h1>도서 정보 관리 ERROR</h1>
	<p><%=msg%></p>
</body>
</html>