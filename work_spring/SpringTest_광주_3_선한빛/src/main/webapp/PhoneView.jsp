<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>핸드폰 관리 - 핸드폰 조회</h1>
	<form method = "post" name = "phonereg" action="phonereg">
	<table>
		<tr>
			<td>모델번호</td>
			<td>${p.num }</td>
		</tr>
		<tr>
			<td>모델명</td>
			<td>${p.model }</td>
		</tr>
		<tr>
			<td>가   격</td>
			<td>${p.price }</td>
		</tr>
		<tr>
			<td>제조사</td>
			<td>${p.vcode }</td>
		</tr>
		<br>
		<tr>
			<td><A HREF="selectlist">메인페이지로</A></td>
			<td><A HREF="delete?num=${p.num }">해당 항목 삭제</A></td>
		</tr>
	</table>
	</form>
</body>
</html>