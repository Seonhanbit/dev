<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
<!-- varStatus는 인덱스 몇번째껀디  -->
<c:forEach items="${sums }" var="sum" varStatus="cnt">
<c:if test="${sum.sum > 4 }">
<label># ${cnt.count }</label>
<jsp:include page="header.jsp"/>
	<label for="op1">op1</label>
	<input id="op1" type ="number" value="${sum.op1 }" readonly="readonly">
		+
	<label for="op1">op1</label>
	<input id="op2" type ="number" value="${sum.op2 }" readonly="readonly">
	=<input id="sum" type ="number" value="${sum.sum }" readonly="readonly">
	<br>
	</c:if>
</c:forEach>
</body>
</html>