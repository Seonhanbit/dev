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
	<a href="<%=request.getContextPath().split("/")[0]+"/" %>">메인화면으로 돌아가기</a>
	<a href="list">게시판으로 돌아가기</a>
</body>
</html>