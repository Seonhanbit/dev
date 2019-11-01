<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WEB-INF - index.jsp >> Hello Boot :) </h1>
	
	<c:choose>
		<c:when test="${memid eq null }">
			<jsp:include page="login.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<h3>${memid }님 안녕하세요.</h3>
			<a href="memregpage">회원등록</a>
			<a href="memselectlist">회원리스트</a>
			<a href="logout">로그아웃</a>
		</c:otherwise>	
	</c:choose>
</body>
</html>