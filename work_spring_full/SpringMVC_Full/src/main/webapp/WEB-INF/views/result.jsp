<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> ${ msg }</h1>
	<c:if test="${ empty isLogin }">
	<a href="loginpage">로그인화면으로 돌아가기</a>
	</c:if>
	<c:if test="${ not empty isLogin }">
	<a href="list">멤버리스트로 돌아가기</a>
	</c:if>
</body>
</html>