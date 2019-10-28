<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardinsert</title>
</head>
<body>
<h1>board insert</h1>

	<form action="boardinsert" method="post" id="boardform">
		<table border="1">
			<tr>
				<td>NUM</td>
				<td><input type="text" id="num" name="num" required="required"></td>
			</tr>
			<tr>
				<td>TITLE</td>
				<td><input type="text" id="title" name="title"
					required="required"></td>
			</tr>
			<tr>
				<td>CONTENT</td>
				<td><input type="text" id="content" name="content"
					required="required"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" value="초기화">
							<input type="submit" value="제출">
							</td>
			</tr>
		</table>
	</form>
</body>
</html>