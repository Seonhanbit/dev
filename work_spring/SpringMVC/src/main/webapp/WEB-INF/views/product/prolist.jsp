<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
    <form>
    <table border="1">
        <tr>
            <th>상품번호</th>
            <th>상품이름</th>
            <th>상품가격</th>
        </tr>
        <c:forEach items ="${list }" var = "pro">
            <tr>
                <td>${pro.num }</td>
                <td>${pro.name }</td>
                <td>${pro.price }</td>
            </tr>
        </c:forEach>
    </table>
    </form>
    <table>
        <tr>
            <form action="proselectone">
                <input name="num" placeholder="상품번호"> <input type="submit"
                    value="찾기">
            </form>
            <form action="prodelete">
				<input name="num" placeholder="상품번호"> <input type="submit"
					value="삭제">
			</form>
		</tr>
		<form action="proupdate" method="post" id="memform">
			<table>
				<tr>
					<td>상품번호 :</td>
					<td><input type="text" id="num" name="num" required="required"></td>
				</tr>
				<tr>
					<td>상품이름 :</td>
					<td><input type="text" id="name" name="name"
						required="required"></td>
				</tr>
				<tr>
					<td>상품가격 :</td>
					<td><input type="text" id="price" name="price"
						required="required"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정"></td>
				</tr>
			</table>
		</form>
	</table>
</body>
</html>