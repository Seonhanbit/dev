<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% request.getSession().removeAttribute("isLogin"); %>
<!DOCTYPE html>
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<title>로그인 페이지</title>
<script type="text/javascript">
	function reg() {
		location.href= "registpage";
	}
	
	
</script>
<style type="text/css">
.container{
	margin : auto;
	text-align : center;
}
table{
	margin: auto;
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<h1>로그인</h1>
		<form class="" action="login" method="post" id="loginform">
			<table border="1">
				<tr>
					<td>ID</td>
					<td><input type="text" id="id" name="id" required="required"></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="password" id="pw" name="pw"
						required="required"></td>
				</tr>
				
			</table>
			<br/>
			<div class="btn-group">
				<input class="btn-primary" type="button" value="가입" onclick="reg()">
				<input class="btn-success" type="submit" value="로그인">
			</div>
		</form>
	</div>
</body>
</html>