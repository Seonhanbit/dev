<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<Script Language="JavaScript">
	function submit() {
		document.deleteform.submit();
	}
</Script>
<title>Insert title here</title>
</head>
<body>
	<h1>핸드폰 목록 조회</h1>
	<form method="post" name="phonereg" action="phonereg">
		<table>
			<c:forEach items="${list }" var="phone">
				<tr>
					<td>모델번호</td>
					<td><a href="selectOne?num=${phone.num }">${phone.num }</a></td>
				</tr>
				<tr>
					<td>모델명</td>
					<td>${phone.model }</td>
				</tr>
				<tr>
					<td>가 격</td>
					<td>${phone.price }</td>
				</tr>
				<tr>
					<td>제조사</td>
					<td>${phone.vcode }</td>
				</tr>
			</c:forEach>
			<br>
			<tr>
				<td><A HREF="regPhone.do">추가등록</A></td>
			</tr>
		</table>
	</form>
	<form method="post" name="deleteform" action="delete">
		<td><input type="text" id="num" name="num"></td>
		<td><input type="button" value="선택항목 삭제" onclick="submit()"></td>
	</form>
</body>
</html>