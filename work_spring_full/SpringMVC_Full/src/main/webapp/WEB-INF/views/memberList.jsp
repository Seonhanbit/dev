<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
</head>
<body>
	<!-- topmenu -->
	<jsp:include page="topmenu.jsp"></jsp:include>

	<h1>회원 리스트</h1>
	<table border = "1">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>주소</th>
		</tr>
		
		<c:forEach items="${ list }" var="user"  >
		<tr>
			<td>${user.name }</td>
			<td><a href="info?id=${ user.id }">${user.id }</a></td>
			<td>${user.addr }</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>