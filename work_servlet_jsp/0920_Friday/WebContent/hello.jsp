<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!String greeting;%>
    <% greeting = (String)request.getAttribute("greeting"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서버가 준 인사는 <%=greeting %>
<!--${greeting}
EL 문법. attribute의 키 값을 적어주면 값을 꺼내서 줍니다.  -->
</body>
</html>