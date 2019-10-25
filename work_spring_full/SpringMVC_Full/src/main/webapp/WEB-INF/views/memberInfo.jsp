<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원 가입</title>
<script type="text/javascript">
	function update() {
		memberform.action= "update";
		memberform.submit();
	}
	function del() {
		memberform.action= "delete";
		memberform.submit();
	}
</script>
</head>
<body>
	<!-- topmenu -->
	<jsp:include page="topmenu.jsp"></jsp:include>

	<h1>회원수정</h1>
	<form action="" method="post" id="memberform">
		<table border="1">
			<tr>
				<td>ID</td><td><input type="text" id="id" name="id" value="${ member.id }"  readonly="readonly"></td>
			</tr>
			<tr>
				<td>PW</td><td><input type="password" id="pw" name="pw" required="required"></td>
			</tr>
			<tr>
				<td>이름</td><td><input type="text" id="name" name="name" value="${ member.name }" required="required"></td>
			</tr>
			<tr>
				<td>주소</td><td><input type="text" id="addr" name="addr" value="${ member.addr }" ></td>
			</tr>
			<tr>
				<td><input type="button" value="회원수정" onclick="update()"></td>
				<td><input type="button" value="회원삭제" onclick="del()"></td>
			</tr>
		</table>
	</form>
</body>
</html>