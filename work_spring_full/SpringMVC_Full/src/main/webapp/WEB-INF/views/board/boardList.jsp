<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>

	<h1>글 리스트</h1>
	<table border = "1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		
		<c:forEach items="${ list }" var="board"  >
		<tr>
			<td>${board.seq }</td>
			<td><a href="info?seq=${ board.seq }">${board.title }</a></td>
			<td>${board.writer }</td>
			<td>${board.regDate }</td>
			<td>${board.count }</td>
		</tr>
		</c:forEach>
		
	</table>
	
	<h2><a href="createPage">글 작성</a></h2>
</body>
</html>