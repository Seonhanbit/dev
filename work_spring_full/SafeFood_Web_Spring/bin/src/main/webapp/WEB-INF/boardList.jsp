<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>Insert title here</title>

<link href="jumbotron.css" rel="stylesheet">
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>
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

.popover {
	width: 300px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {

		var msg = "${msg}";
		if (msg == "success") {
			alert("등록 성공입니다.");
		} else if (msg == "fail") {
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
						<li><a data-toggle="modal" href="#myModal"><img
								width="20px" src="resources/img/사람.png">Sign Up</a></li>
						<li id=login><a href="#"><img width="20px"
								src="resources/img/사람.png">Login</a></li>
					</ul>
				</div>
			</c:if>
			<c:if test="${islogin eq 'isLogin'}">
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="main.do?action=memInfo"><img width="20px"
								src="resources/img/사람.png">회원정보수정</a></li>
						<li id=logout><a href="main.do?action=Logout"><img
								width="20px" src="resources/img/사람.png">Logout</a></li>
					</ul>
				</div>
			</c:if>
		</div>
	</nav>


	<a href="./main.jsp"> <img src="resources/img/ssafy.png"></a>
	<ul class="nav navbar-nav navbar-right">
		<li class="active"><a href="#" style="margin-right: 30px">공지
				사항 </a></li>
		<li><a href="main.do?action=productInfo"
			style="margin-right: 30px">상품 정보</a></li>
		<li><a href="#" style="margin-right: 30px">베스트 섭취 정보</a></li>
		<li><a href="#" style="margin-right: 30px">예상 섭취 정보</a></li>
		<li><a href="#" class="glyphicon glyphicon-search"
			style="margin-right: 100px"></a></li>
	</ul>

	<!-- Main jumbotron for a primary marketing message or call to action -->


	<div class="jumbotron"
		style="background-color: #A9A9A9; margin-bottom: 0px">
		<div class="container" style="text-align: center">
			<h1 style="color: white">WHAT WE PROVIDE</h1>
			<hr>
			<p style="color: white">건강한 삶을 위한 먹거리 프로젝트</p>
		</div>
	</div>


	


<div class="container">
		<div class="page-header">
			<h1>공 지 사 항</h1>
		</div>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th style="width: 200px">번호</th>
					<th style="width: 200px">글쓴이</th>
					<th style="width: 1000px">제목</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ list}" var="tmp">
					<tr>
						<th>${tmp.code }</th>
						<th>${tmp.id }</th>
						<th><a href="boardview?code=${tmp.code }"> ${tmp.title }
						</a></th>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3"><a href="boardwrite">작성하기</a></td>
				</tr>
			</tfoot>
		</table>
	</div>







	<div id="myForm" class="hide">
		<form action="main.do?action=Login" id="popForm" method="post">
			<div>
				<label for="email" style="color: white;">ID</label> <br /> <input
					type="text" name="pid" id="email" class="form-control input-md"
					style="background-color: #677475;">
			</div>
			<div>
				<label for="password" style="color: white;">비밀번호</label> <br /> <input
					type="password" name="ppw" id="name" class="form-control input-md"
					style="background-color: #677475;">
				<div style="margin-top: 20px">
					<button type="submit" class="btn btn-gray btn-sm">로 그 인</button>
					<button type="button" class="btn btn-gray btn-sm">비밀번호 찾기</button>
				</div>
			</div>
		</form>
	</div>


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
								<li style="opacity: 0.6"><img src="resources/img/위치.png"
									width="20px"> (SSAFY) 서울시 강남구 테헤란로 멀티스퀘어</li>
								<li style="opacity: 0.6"><img src="resources/img/전화.png"
									width="20px"> 1544-9001</li>
								<li style="opacity: 0.6"><a href="#"><img
										src="resources/img/이메일.png" width="20px">
										admin@ssafy.com</a></li>
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