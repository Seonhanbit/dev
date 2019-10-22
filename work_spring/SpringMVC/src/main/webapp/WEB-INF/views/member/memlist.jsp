<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	<form>
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
			</tr>
			<c:forEach items="${list}" var="mem">
				<tr>
					<td><a href="memselectone?id=${mem.id }">${mem.id }</a></td>
					<td>${mem.name }</td>
					<td>${mem.email }</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<table>
		<tr>
			<form action="memselectone">
				<input name="id" placeholder="id"> <input type="submit"
					value="찾기">
			</form>
			<form action="memdelete">
				<input name="id" placeholder="id"> <input type="submit"
					value="삭제">
			</form>
		</tr>
		<form action="memupdate" method="post" id="memform">
			<table>
				<tr>
					<td>ID :</td>
					<td><input type="text" id="id" name="id" required="required"></td>
				</tr>
				<tr>
					<td>PW :</td>
					<td><input type="password" id="pw" name="pw"
						required="required"></td>
				</tr>
				<tr>
					<td>이름 :</td>
					<td><input type="text" id="name" name="name"
						required="required"></td>
				</tr>
				<tr>
					<td>e-mail :</td>
					<td><input type="email" id="email" name="email"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정"></td>
				</tr>
			</table>
		</form>
	</table>
</body>
</html>