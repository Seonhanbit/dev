<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<meta charset="utf-8">
<!-- <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> -->
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
.ml-auto .dropdown-menu {
	left: auto !important;
	right: 0px;
}

#test_btn1 {
	margin-right: 0px;
}

#test_btn2 {
	margin-left: -2px;
}

#test_btn2, #test_btn1 {
	border: 0px black;
	background-color: rgba(0, 0, 0, 0);
	color: white;
	padding: 5px;
}

#test_btn3, #test_btn4 {
	background-color: rgba(0, 0, 0, 0);
	color: black;
	padding: 5px;
}

.the-legend {
	border-style: none;
	border-width: 0;
	font-size: 14px;
	line-height: 20px;
	margin-bottom: 0;
	width: auto;
	padding: 0 10px;
	border: 1px solid #e0e0e0;
}

.the-fieldset {
	border: 1px solid #e0e0e0;
	padding: 10px;
}

legend.scheduler-border {
	width: inherit; /* Or auto */
	padding: 0 10px; /* To give a bit of padding on the left and right */
	border-bottom: none;
}

body>div>div>div>ul ul { /*서브메뉴 선택시 서브메뉴화면  */
	display: none;
	background: white;
	box-shadow: 1px 1px 5px black;
}

#modal {
	position: relative;
	width: 100%;
	height: 100%;
	z-index: 1;
}

#modal h2 {
	margin: 0;
	 
	 
}

#modal button {
	display: inline-block;
	width: 100px;
	margin-left: calc(100% - 100px - 10px);
}

#modal .modal_content {
	width: 300px;
	margin: 100px auto;
	padding: 20px 10px;
	background: #fff;
	border: 2px solid #666;
}

#modal .modal_layer {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.5);
	z-index: -1;
}

#dropdown-box {
	dispaly: none;
}

body>nav>div>ul>div>ul {
	background-color: black;
}

.card-text {
	display: inline-block;
	width: 360px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: normal;
	line-height: 1.2;
	height: 150px;
	text-align: left;
	word-wrap: break-word;
	display: -webkit-box;
	-webkit-line-clamp: 3;
	-webkit-box-orient: vertical;
}

body>nav>div>ul>div>ul {
	background-color: black;
}
</style>

<script type="text/javascript">
$(document).ready(function(){
	
	var msg = "${msg}";
	if(msg=="success"){
		alert("등록 성공입니다.");
	}else if(msg=="fail"){
		alert("등록 실패입니다.");
	}
	
});

	$(function() {
		$('#login').popover({
			placement : 'bottom',
			html : true,
			content : $('#myForm').html()
		}).on('click', function() {
			$(function() {
				$('.popover-content').css('background-color', '#465355');
			});
			$(function() {
				$('.popover-title').css('background-color', '#465355');
			});
			// had to put it within the on click action so it grabs the correct info on submit
			$('.btn-primary').click(function() {
				$.post('/echo/html/', {
					email : $('#email').val(),
					name : $('#password').val()
				}, function(r) {
					$('#pops').popover('hide')
				})
			})
		})
	})
</script>


</head>





<body>
<%-- <jsp:include page= "login.jsp"></jsp:include> --%>

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
			<c:if test="${islogin ne 'isLogin'}">
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a data-toggle="modal" href="#myModal"><img width="20px" src="./img/사람.png">Sign
								Up</a></li>
						<li id=login><a href="#"><img width="20px" src="./img/사람.png">Login</a></li>
					</ul>
				</div>
			</c:if>
			<c:if test="${islogin eq 'isLogin'}">
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="main.do?action=memInfo"><img width="20px" src="./img/사람.png">회원정보수정</a></li>
						<li id=logout><a href="main.do?action=Logout"><img width="20px" src="./img/사람.png">Logout</a></li>
					</ul>
				</div>
			</c:if>
		</div>
	</nav>


	<a href="./main.jsp"> <img src="./img/ssafy.png"></a>
	<ul class="nav navbar-nav navbar-right">
		<li class="active"><a href="./announce.jsp" style="margin-right: 30px">공지
				사항 </a></li>
		<li><a href="main.do?action=productInfo" style="margin-right: 30px">상품
				정보</a></li>
		<li><a href="#" style="margin-right: 30px">베스트 섭취 정보</a></li>
		<li><a href="#" style="margin-right: 30px">예상 섭취 정보</a></li>
		<li><a href="#" class="glyphicon glyphicon-search"
			style="margin-right: 100px"></a></li>
	</ul>
	
	 <!-- menu nav bar -->
	<!-- <nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="./index.jsp"><img alt="ssafy"
			src="./img/ssafy.png"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="navbar collapse navbar-collapse"
			id="navbarSupportedContent">
			<ul class="nav navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="./announce.jsp">공지사항</a></li>
				<li class="nav-item"><a class="nav-link" href="./main.do?action=list">상품정보</a></li>
				<li class="nav-item"><a class="nav-link" href="./main.do?action=most">베스트 섭취 정보</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">내 섭취 정보</a></li>
				<li class="nav-item"><a class="nav-link" href="./expect.jsp">예상 섭취 정보</a>
				</li>
					<li>
					<form class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success my-2 my-sm-0">
					<span class="fa fa-search"></span></button>
					</form>
				</li>
			</ul>
		</div>
	</nav>-->
	
	<div class="jumbotron jumbotron-fluid"
		style='margin-bottom: 0%; background-color: #676767'>
		<div class="container text-center" style="color: white">
			<h1>WHAT WE PROVIDE</h1>
			<div class="seperator"></div>
			<p>건강한 삶을 위한 먹거리 프로젝트</p>
		</div>
	</div> 
    <table class="table">
        <thead class="bg-warning" style= 'background-color: #FFFF55'>
            <th scope="col">#</th>
            <th scope="col">제목</th>
            <th scope="col">조회수</th>
            <th scope="col">게시자</th>
        <thead>
        <tbody>
            <tr></tr>
            <tr style="cursor: pointer"
                onClick="location.href='./view_announce.jsp'">
                <th scope="row">1</th>
                <td>오늘의 공지(2019.09.10)</td>
                <td>10</td>
                <td>SSAFY</td>
            </tr>
            <tr style="cursor: pointer"
                onClick="location.href='./view_announce2.jsp'">
                <th scope="row">2</th>
                <td>오늘의 공지(2019.09.11)</td>
                <td>8</td>
                <td>SSAFY</td>
            </tr>
        </tbody>
    </table>
    <!-- footer contacts -->
    <div class="footer" style="background-color: #F8F8FF">
		<div class="container">
			<div class="footer-inner">
				<div class="row">
					<div class="col-lg-10">
						<div class="footer-content">
							<h2 class="title">Find Us</h2>
							<hr>
							<div class="separator-2"></div>
							<ul class="list-icons" style="list-style: none;">
								<li style="opacity: 0.6"><img src="./img/위치.png"
									width="20px"> (SSAFY) 서울시 강남구 테헤란로 멀티스퀘어</li>
								<li style="opacity: 0.6"><img src="./img/전화.png"
									width="20px"> 1544-9001</li>
								<li style="opacity: 0.6"><a href="#"><img
										src="./img/이메일.png" width="20px"> admin@ssafy.com</a></li>
							</ul>
							<br />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="subfooter" style="background-color: #F5F5F5">
		<div class="container">
			<div class="subfooter-inner">
				<div class="row">
					<div class="col-md-12">
						<br />
						<p class="text-center" style="opacity: 0.6">Copyright by
							SSAFY. All rights reserved.</p>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>