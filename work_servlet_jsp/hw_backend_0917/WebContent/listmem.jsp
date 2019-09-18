<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.ssafy.model.MemVO"%>
<%!ArrayList<MemVO> list;
	String searchName;%>
<%
	list = (ArrayList<MemVO>) request.getAttribute("list");
	searchName = ((String) request.getParameter("name") == null ? "" : (String) request.getParameter("name"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
<script type="text/javascript">
	function search() {
		location.href = "main.do?action=listmem&name="
				+ document.getElementById("searchName").value;
	}
</script>
</head>
<body>
	<h1>회원 목록</h1>
	<table border="1">
		<tr>
			<th><span style="width: 30px">이름:</span> <input type="text"
				id="searchName" value="<%=searchName%>" style="width: 70px"></th>
			<th><input type="button" value="검색" onclick="search()"></th>
		</tr>
		<tr>
			<th>아이디</th>
			<th>이름</th>
		</tr>
		<%
			for (int i = 0; i < list.size(); i++) {
				if (!searchName.equals("") && !searchName.equals(list.get(i).getName()))
					continue;
		%>
		<tr>
			<td><%=list.get(i).getId()%></td>
			<td><a
				href="main.do?action=meminfo&uid=<%=list.get(i).getId()%>"><%=list.get(i).getName()%></a></td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="main.do?action=listmem">전체보기</a>
	<br>
	<a href="login.html">로그아웃</a>
</body>
</html>