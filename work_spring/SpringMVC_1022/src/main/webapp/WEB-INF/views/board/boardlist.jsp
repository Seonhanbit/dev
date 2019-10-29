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
	<h1>보드 리스트</h1>
	<table border="1">
		<tr><th>no</th><th>title</th><th>content</th></tr>
		<c:forEach items="${list }" var="board">
			<tr>
				<td><a href="boardselectOne?no=${board.no }">${board.no }</a></td>
				<td>${board.title }</td>
				<td>${board.content }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>