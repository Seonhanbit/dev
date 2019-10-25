<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시글 상세</title>
<script type="text/javascript">
	function update() {
		boardform.action="update";
		boardform.submit();
	}
	function del() {
		boardform.action="delete";
		boardform.submit();
	}
	
	function goList() {
		location.href = "list";
	}
</script>
</head>
<body>

	<h1>게시글 상세</h1>
	<form action="" method="post" id="boardform">
		<table border="1">
			<tr>
				<td>번호</td><td><input type="number" id="seq" name="seq" value="${ board.seq }"  readonly="readonly"></td>
			</tr>
			<tr>
				<td>제목</td><td><input type="text" id="title" name="title" value="${ board.title }" required="required"></td>
			</tr>
			<tr>
				<td>작성자</td><td><input type="text" id="writer" name="writer" value="${ board.writer }" disabled="disabled"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
				<textarea cols="40" rows="8" id="context" name="context" required="required">${ board.content }</textarea>
				</td>
			</tr>
			<tr>
				<td>작성일</td><td><input type="date" id="regDate" name="regDate" value="${ board.regDate }" disabled="disabled"></td>
			</tr>
			<tr>
				<td>조회수</td><td><input type="number" id="count" name="count" value="${ board.count }" disabled="disabled"></td>
			</tr>
			<tr>
				<td><input type="button" value="글 수정" onclick="update()"></td>
				<td><input type="button" value="글 삭제" onclick="del()">
				<input type="button" value="목록으로" onclick="goList()"></td>
			</tr>
		</table>
	</form>
</body>
</html>