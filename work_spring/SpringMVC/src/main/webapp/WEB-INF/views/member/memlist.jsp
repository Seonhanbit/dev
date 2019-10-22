<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
    <form>
    <table border="1">
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>이메일</th>
        </tr>
        <c:forEach items ="${list}" var = "mem">
            <tr>
                <td><a href="memselectone?id=${mem.id }">${mem.id }</a></td>
                <td>${mem.name }</td>
                <td>${mem.email }</td>
            </tr>
        </c:forEach>
    </table>
    </form>
    <table>
        <tr>
            <a href="meminsert">등록</a>
        </tr>
        <br>
        <tr>
            <a href="memdelete">삭제</a>
        </tr>
        <br>
        <tr>
            <a href="memupdate">update</a>
        </tr>
        <br>
        <tr>
            <a href="memselectlist">리스트</a>
        </tr>
        <br>
        <tr>
            <form action="memselectone">
                <input name="id" placeholder="id"> <input type="submit"
                    value="찾기">
            </form>
        </tr>
    </table>
</body>
</html>