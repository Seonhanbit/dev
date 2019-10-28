<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	<form>
		<table border="1">
			<tr>
				<th>num</th>
				<th>title</th>
				<th>content</th>
			</tr>
			<c:forEach items="${list}" var="board">
				<tr>
					<td><a href="memselectone?id=${board.num }">${board.num }</a></td>
					<td>${board.title }</td>
					<td>${board.content }</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>