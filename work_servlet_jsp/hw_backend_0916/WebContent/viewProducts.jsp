<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="product.Manager"%>
<%@ page import="product.Product"%>

<%!Manager mg = Manager.getInstance();
	String re;
	ArrayList<Product> list;
	String num, name, price, sub;%>

<%
	re = "";
	list = mg.getList();
	for (int i = 0; i < list.size(); i++) {
		re += "<table>";
		re += "<tr>";
		re += "<td>상품 번호</td>";
		re += "<td>" + list.get(i).getNum() + "</td>";
		re += "</tr>";
		re += "<tr>";
		re += "<td>상 품 명</td>";
		re += "<td>" + list.get(i).getName() + "</td>";
		re += "</tr>";
		re += "<tr>";
		re += "<td>상품 가격</td>";
		re += "<td>" + list.get(i).getPrice() + "</td>";
		re += "</tr>";
		re += "<tr>";
		re += "<td>상품 설명</td>";
		re += "<td>" + list.get(i).getSub() + "</td>";
		re += "</tr>";
		re += "</table>";
		re += "<br>";
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<style>
td:nth-child(odd) {
	width: 120px;
	text-align: center;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>상품 목록</h1>
	<%=re%>
	<a href="index.html">추가 등록</a>
</body>
</html>