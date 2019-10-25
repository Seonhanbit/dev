<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>File upLoad Page</h1>
	<form action="${ request.contextPath }fileupload" id="fileUpload" name="fileUpload" method="post" enctype="multipart/form-data">
		이름 : <input type="text" name="name" id="cmd" value="test"/><br/>
		파일 : <input type="file" name="file"/><br/>
		<input type="submit" name="업로드" value="제출"/>
	</form>
</body>
</html>