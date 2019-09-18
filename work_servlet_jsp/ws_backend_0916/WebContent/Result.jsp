<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!String isbn, title, catalogue, nation, publisheDate, publisher, author, price, currency, description;%>
<%
	isbn = request.getParameter("isbn1") + "-" + request.getParameter("isbn2") + "-"
			+ request.getParameter("isbn3");
	title = request.getParameter("title");
	catalogue = request.getParameter("catalogue");
	nation = request.getParameter("nation");
	publisheDate = request.getParameter("publisheDate");
	publisher = request.getParameter("publisher");
	author = request.getParameter("author");
	price = request.getParameter("price");
	currency = request.getParameter("currency");
	description = request.getParameter("description");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/design.css">
</head>

<body>
	<table class="title_table">
		<tr>
			<td class="title_table"><h2>등록된 정보는 다음과 같습니다.</h2></td>
		</tr>
	</table>
	<table>
		<tr>
			<td id="td_cat" colspan='2'>도서 정보</td>
		</tr>
		<tr>
			<td id="td_cat">도서명</td>
			<td><%=title%></td>
		</tr>
		<tr>
			<td id="td_cat">도서번호</td>
			<td><%=isbn%></td>
		</tr>
		<tr>
			<td id="td_cat">도서분류</td>
			<td><%=catalogue%></td>
		</tr>
		<tr>
			<td id="td_cat">도서국가</td>
			<td><%=nation%></td>
		</tr>
		<tr>
			<td id="td_cat">출판일</td>
			<td><%=publisheDate%></td>
		</tr>
		<tr>
			<td id="td_cat">출판사</td>
			<td><%=publisher%></td>
		</tr>
		<tr>
			<td id="td_cat">저 자</td>
			<td><%=author%></td>
		</tr>
		<tr>
			<td id="td_cat">도서가격</td>
			<td><%=price%><%=currency%></td>
		</tr>
		<tr>
			<td id="td_cat">요약내용</td>
			<td><%=description%></td>
		</tr>
	</table>
	<table class="title_table">
		<tr>
			<td class="title_table"><a href="./book.html">추가 등록</a></td>
		</tr>
	</table>
</body>
</html>