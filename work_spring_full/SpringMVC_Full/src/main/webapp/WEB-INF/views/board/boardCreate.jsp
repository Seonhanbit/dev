<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<script type="text/javascript">
	function goList() {
		location.href = "list";
	}
</script>
</head>
<body>
	<h1>글 작성</h1>
	<form action="create" method="post" id="boardform">
		<table border="1">
			<tr>
				<td>제목</td><td><input type="text" id="title" name="title"required="required" ></td>
			</tr>
			<tr>
				<td>작성자</td><td><input type="text" id="writer" name="writer" required="required"></td>
			</tr>
			<tr>
				<td>내용</td><td><textarea cols="40" rows="8" id="context" name="context" required="required"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="글 등록"></td>
				<td><input type="button" value="게시판으로 돌아가기" onclick="goList()"></td>
			</tr>
		</table>
	</form>
</body>
</html>