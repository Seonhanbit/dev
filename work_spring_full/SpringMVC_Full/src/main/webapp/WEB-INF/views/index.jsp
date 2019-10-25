<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<h1><a href="member/loginpage">로그인 화면으로</a></h1><br/>
<h1><a href="board/list">게시판 화면으로</a></h1>
<h1><a href="uploadForm">파일업로드 화면으로</a></h1>
</body>
</html>
