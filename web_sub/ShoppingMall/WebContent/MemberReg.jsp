<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#submit').on('click',function(){
		var id = $('#pid').val();
		if(id.length < 3){
			alert("id 길이가 너무 짧습니다");
			pid.focus();
			return;
		}
		rform.submit();
	})
	
})
</script>
<style type="text/css">
body{
	width: 270px;
	margin: 0 auto;
}
</style>
</head>
<body>
<h1 align="center">회원 가입</h1>
<form action="mem.do?action=memreg" method="post" id='rform'>
	<table border="1" >
		<tr><td>아이디</td><td><input type="text" name="pid" id="pid" required="required"></td></tr>
		<tr><td>비밀번호</td><td><input type="password" name="ppw" id="ppw" required="required"></td></tr>
		<tr><td>이름</td><td><input type="text" name="pname" required="required"></td></tr>
		<tr><td>주소</td><td><input type="text" name="paddr" required="required"></td></tr>
		<tr><td colspan="2"><input type="button" value="가입" id='submit'><input type="reset" value="초기화"></td></tr>
	</table>
</form>
</body>
</html>