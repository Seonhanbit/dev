<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<c:if test="${ empty isLogin }">
	<h3><a href="loginpage"> 로그인화면으로 가기</a></h3>
</c:if>
<c:if test="${ not empty isLogin }">
	<h3> ${ isLogin } 님이 로그인 되었습니다.</h3><br/>
	<h4><a href="logout"> 로그아웃</a></h4>
</c:if>