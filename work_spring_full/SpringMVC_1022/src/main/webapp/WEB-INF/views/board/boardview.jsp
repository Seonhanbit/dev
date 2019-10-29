<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function boardupdate(){
	rform.action = "boardupdate";
	rform.submit();
}	
function boarddelete(){
	rform.action = "boarddelete";
	rform.submit();
}
</script>
</head>
<body>
	<form action="#" id="rform" method="post">
		<label for="no">번호</label>
		<input type="text" name="no" id="no" value="${board.no }">
		<br>
		
		<label for="title">title</label>
		<input type="text" name="title" id="title" value="${board.title }">
		<br>
		
		<label for="content">content</label>
		<input type="text" name="content" id="content" value="${board.content }">
		<br>
		<input type="button" value="수정" onclick="boardupdate()">
		<input type="button" value="삭제" onclick="boarddelete()">
	</form>
</body>
</html>