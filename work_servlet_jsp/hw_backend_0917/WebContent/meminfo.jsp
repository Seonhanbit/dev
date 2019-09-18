<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="edu.ssafy.model.MemVO"%>
<%!MemVO mem;%>
<%
	mem = (MemVO) request.getAttribute("mem");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 조회</title>
<script type="text/javascript">
	function updatemem() {
		rform.submit();
	}
	function deletemem() {
		var id = pid.value;
		location.href = "main.do?action=deletemem&pid=" + id;
	}
</script>
</head>
<body>
	<div align="center">
		<h1>회원정보</h1>
		<form action="main.do?action=updatemem" method="post" id="rform">
			<table>
				<tr>
					<td>아이디 :</td>
					<td><input type="text" name="pid" id="pid"
						value=<%=mem.getId()%> readonly="readonly"></td>
				</tr>
				<tr>
					<td>이름 :</td>
					<td><input type="text" name="pname" id="pname"
						value=<%=mem.getName()%>></td>
				</tr>
				<tr>
					<td>비번 :</td>
					<td><input type="password" name="ppw" id="ppw"
						value=<%=mem.getPw()%>></td>
				</tr>
				<tr>
					<td>주소 :</td>
					<td><input type="text" name="paddr" id="paddr"
						value=<%=mem.getAddr()%>></td>
				</tr>
				<tr>
					<td>나이 :</td>
					<td><input type="number" name="page" id="page"
						value=<%=mem.getAge()%>></td>
				</tr>
				<tr>
					<td>전화번호 :</td>
					<td><input type="tel" name="ptel" id="ptel"
						value=<%=mem.getTel()%>></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="수정"
						onclick="updatemem()"> <input type="button" value="삭제"
						onclick="deletemem()"></td>
				</tr>
			</table>
		</form>
		<a href="main.do?action=listmem">리스트화면</a>
	</div>
</body>
</html>