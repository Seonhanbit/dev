<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.js"
    integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
    crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<link href="jumbotron.css" rel="stylesheet">
<style type="text/css">
fieldset.scheduler-border {
	width: 40%;
	border: 1px groove #ddd !important;
	padding: 0 1.4em 1.4em 1.4em !important;
	margin: 0 0 1.5em 0 !important;
	-webkit-box-shadow: 0px 0px 0px 0px #000;
	box-shadow: 0px 0px 0px 0px #000;
}

legend.scheduler-border {
	font-size: 1.2em !important;
	font-weight: bold !important;
	text-align: left !important;
	width: auto;
	padding: 0 10px;
	border-bottom: none;
}

.container {
	width: 750px;
	
}

.form-control {
	display: inline-block;
	width: 50%;
}
.popover{
	width: 300px;
}
</style>

<title>Insert title here</title>
<script type="text/javascript">
    $(document).ready(function() {
        var msg = "${msg}";
        if (msg == "success") {
            alert("탈퇴 성공.");
        } else if (msg == "fail") {
            alert("탈퇴 실패.");
        }
    });
	function updatemem() {
		rform.submit();
	}
    function deletemem() {
        location.href = "main.do?action=Delete&pid=${id}";
    }
    function goMain() {
        location.href = "main.jsp";
    }
</script>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"></a>
			</div>
			
		</div>
	</nav>


	<a href="./main.jsp"> <img src="./img/ssafy.png"></a>
	<ul class="nav navbar-nav navbar-right">
		<li class="active"><a href="#" style="margin-right: 30px">공지
				사항 </a></li>
		<li><a href="main.do?action=productInfo" style="margin-right: 30px">상품
				정보</a></li>
		<li><a href="#" style="margin-right: 30px">베스트 섭취 정보</a></li>
		<li><a href="#" style="margin-right: 30px">예상 섭취 정보</a></li>
		<li><a href="#" class="glyphicon glyphicon-search"
			style="margin-right: 100px"></a></li>
	</ul>

	<div align="center">
		<h1>회 원 정 보</h1>
		<form action="main.do?action=Update" method="post" id="rform">
			<table>
			
<!-- //(String id, String pw, String name, String addr, String email, String tel, String alinfo) -->
			<tr>
				<td>아이디: </td>
				<td>${id }<input type="hidden" name="pid" value="${id }"></td>
				
			</tr>
			<tr>	
				<td>비밀번호: </td>
				<td><input type="text" name="ppw" id="ppw" value="${info.pw }"> </td>
			</tr>
			<tr>
				<td>이름: </td>
				<td><input type="text" name="pname" id="pname"  value="${info.name}"> </td>
			</tr>
			<tr>
				<td>주소: </td>
				<td><input type="text" name="paddr" id="paddr"  value="${info.addr }"> </td>
			</tr>
			<tr>
				<td>이메일: </td>
				<td><input type="text" name="pemail" id="pemail" value="${info.email }"> </td>
			</tr>
			<tr>
				<td>전화번호: </td>
				<td><input type="text" name="ptel" id="ptel" value="${info.tel }"> </td>
			</tr>
			<tr>
                    <td>알러지</td>
                    <td>
                        <fieldset class="scheduler-border" id="option">
                            <legend class="scheduler-border">알레르기*</legend>
                            <div class="formfield">
                            <c:set var="info" value="${info.alinfo}"></c:set>
                            <c:choose>
                                <c:when test="${fn:contains(info, '대두')}">
                                    <input type="checkbox" name="hobby" checked="checked" value="대두" alt="취미"> 대두
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="hobby" value="대두" alt="취미">대두
                                </c:otherwise>
                            </c:choose>    
                            <c:choose>
                                <c:when test="${fn:contains(info, '땅콩')}">
                                    <input type="checkbox" name="hobby" checked="checked" value="땅콩" alt="취미"> 땅콩
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="hobby" value="땅콩" alt="취미">땅콩
                                </c:otherwise>
                            </c:choose>    
                            <c:choose>
                                <c:when test="${fn:contains(info, '우유')}">
                                    <input type="checkbox" name="hobby" checked="checked" value="우유" alt="취미"> 우유
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="hobby" value="우유" alt="취미">우유
                                </c:otherwise>
                            </c:choose>    
                            <c:choose>
                                <c:when test="${fn:contains(info, '게')}">
                                    <input type="checkbox" name="hobby" checked="checked" value="게" alt="취미"> 게
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="hobby" value="게" alt="취미">게
                                </c:otherwise>
                            </c:choose>    
                            <c:choose>
                                <c:when test="${fn:contains(info, '새우')}">
                                    <input type="checkbox" name="hobby" checked="checked" value="새우" alt="취미"> 새우
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="hobby" value="새우" alt="취미">새우
                                </c:otherwise>
                            </c:choose>    
                            <c:choose>
                                <c:when test="${fn:contains(info, '참치')}">
                                    <input type="checkbox" name="hobby" checked="checked" value="참치" alt="취미"> 참치
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="hobby" value="참치" alt="취미">참치
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${fn:contains(info, '연어')}">
                                    <input type="checkbox" name="hobby" checked="checked" value="연어" alt="취미"> 연어
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="hobby" value="연어" alt="취미">연어
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${fn:contains(info, '쑥')}">
                                    <input type="checkbox" name="hobby" checked="checked" value="쑥" alt="취미"> 쑥
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="hobby" value="쑥" alt="취미">쑥
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${fn:contains(info, '소고기')}">
                                    <input type="checkbox" name="hobby" checked="checked" value="소고기" alt="취미"> 소고기
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="hobby" value="소고기" alt="취미">소고기
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${fn:contains(info, '닭고기')}">
                                    <input type="checkbox" name="hobby" checked="checked" value="닭고기" alt="취미"> 닭고기
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="hobby" value="닭고기" alt="취미">닭고기
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${fn:contains(info, '돼지고기')}">
                                    <input type="checkbox" name="hobby" checked="checked" value="돼지고기" alt="취미"> 돼지고기
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="hobby" value="돼지고기" alt="취미">돼지고기
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${fn:contains(info, '복숭아')}">
                                    <input type="checkbox" name="hobby" checked="checked" value="복숭아" alt="취미"> 복숭아
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="hobby" value="복숭아" alt="취미">복숭아
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${fn:contains(info, '민들레')}">
                                    <input type="checkbox" name="hobby" checked="checked" value="민들레" alt="취미"> 민들레
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="hobby" value="민들레" alt="취미">민들레
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${fn:contains(info, '계란흰자')}">
                                    <input type="checkbox" name="hobby" checked="checked" value="계란흰자" alt="취미"> 계란흰자
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="hobby" value="계란흰자" alt="취미">계란흰자
                                </c:otherwise>
                            </c:choose>
                            </div>
                        </fieldset>
                    </td>
                </tr>
			

			</table>

		</form>
	</div>
    <tr>
        <td><input type="button" value="회원 수정" onclick="updatemem()">
            <br /> <input type="button" value="회원 탈퇴" onclick="deletemem()"></td>
        <br />
        <input type="button" value="메인 화면 돌아가기" onclick="goMain()">
        </td>
    </tr>
</body>
</html>