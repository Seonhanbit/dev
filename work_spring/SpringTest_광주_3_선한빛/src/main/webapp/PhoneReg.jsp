<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<Script Language ="JavaScript">
			function submit(){
				document.phonereg.submit() ;
			}

</Script>
<title>Insert title here</title>
</head>
<body>
	<h1>핸드폰 관리 - 핸드폰 등록</h1>
	<form method = "post" name = "phonereg" action="phonereg">
	<table>
		<tr>
			<td>모델번호</td>
			<td><input type="text" id="num" name="num"></td>
		</tr>
		<tr>
			<td>모델명</td>
			<td><input type="text" id="model" name="model"></td>
		</tr>
		<tr>
			<td>가   격</td>
			<td><input type="text" id="price" name="price"></td>
		</tr>
		<tr>
			<td>제조사</td>
			<td><input type="text" id="vcode" name="vcode"></td>
		</tr>
		<br>
		<tr>
			<td><input type="button" value="핸드폰등록" onclick="submit()"></td>
			<td><input type="button"value="취소"></td>
		</tr>
	</table>
	</form>
</body>
</html>