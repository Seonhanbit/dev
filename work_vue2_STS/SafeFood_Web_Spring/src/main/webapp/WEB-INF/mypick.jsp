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
#datespan{
	color:red;	
}
#span{
	color:blue;	
}
</style>
<script type="text/javascript">
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
			});
			$('#check').click(function() {

				var id = $("#mid").val();
				var pw = $("#mpw").val();
				if (id == "") {
					alert("ID를 입력하세요")
					$("#mid").focus();
				} else if (pw == "") {
					alert("비밀번호를 입력하세요")
					$("#mpw").focus();
				} else {
					$("#popForm").submit();
				}
			});
			$('#findpw').on('click', function() {
				location.href = "/findpw";
			});
		})
	})

	$(function() {
		$("#span").text("오늘 당신이 가장 많이 검색한 키워드는 ${key } 입니다.");
	})
	$(function() {
		$("#datespan").text("지금 즉시 주문하면 ${date } 일 후 배송완료 예정!");
	})
</script>
<title>Insert title here</title>

<!-- Bootstrap core CSS -->
<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">
​
<!-- Custom styles for this template -->
<link href="jumbotron.css" rel="stylesheet">
​
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>
​
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
						<li><a data-toggle="modal" href="#myModal"><img width="20px" src="./img/사람.png">Sign
								Up</a></li>
						<li id=login><a href="#"><img width="20px" src="./img/사람.png">Login</a></li>
					</ul>
				</div>
			</c:if>
			<c:if test="${islogin eq 'isLogin'}">
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="memInfo"><img width="20px" src="./img/사람.png">회원정보수정</a></li>
						<li id=logout><a href="Logout"><img width="20px" src="./img/사람.png">Logout</a></li>
					</ul>
				</div>
			</c:if>
		</div>
	</nav>


	<a href="./main"> <img src="./img/ssafy.png"></a>
	<ul class="nav navbar-nav navbar-right">
		<li class="active"><a href="#" style="margin-right: 30px">공지
				사항 </a></li>
		<li><a href="productInfo" style="margin-right: 30px">상품
				정보</a></li>
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

	<div
		style="background-color: #696969; padding: 20px; text-align: center">
		<table style="margin-left: auto; margin-right: auto;">
			<tr>
				<th style="color: white">검색 조건</th>
				<th style="color: white">검색 단어</th>
			</tr>
			<tr>
				<form action="searchProduct" method="post">
					<input type="hidden" name="action" value="searchProduct">
					<th><select name="searchType"
						style="width: 70px; height: 25px; margin-right: 5px;">
							<option value="상품명" name="pname">상품명</option>
							<option value="제조사" name="pcom">제조사</option>
					</select></th>

					<th><input type="text" class="selectbox" name=search>
						<button type="submit" class="btn btn-sm btn-info") >검색</button></th>
				</form>
			</tr>
		</table>
	</div>
	<div align="center">
		<c:if test="${key != null}"> 
				<span id="span"></span>
		</c:if>
	</div>
	<br />
	<div align="center">
	<form action="date" method="post">
		오늘 시킨다면 언제 제품이 오는지 알고싶으신가요?
		<input type="text" name="posx" placeholder="사는곳의 X좌표">
		<input type="text" name="posy" placeholder="사는곳의 Y좌표">
		<input type="submit" value = "결과">
	</form>
	</div>
	<br>
	<div align="center">
	<c:if test="${date != null}"> 
			<span id="datespan"></span>
	</c:if>
	</div>
	<div align="center">
		검색한 단어가 포함된 제품수<input type="text" readonly="readonly" value="${cnt }">
	</div>
	<div style="margin-left: 200px">
		<table id="content" style="width: 90%; margin: 0 auto">

			<c:forEach var="product" items="${foodlist }">
				<tr style='margin-left: 200px'>
					<td><a href='pdetail?code=${product.code}'><img width='180px' src="${product.image}" class='btn btn-gray-transparent btn-animated btn-sm'></a>
							<a href='pdetail?code=${product.code}'> 상품 정보로 이동 </a><i class='pl-10 fa fa-arrow-right'></i>
						<p style='font-size: 18px; opacity: 0.7'>${product.name }</p>
						<span class='glyphicon glyphicon-calendar'> Feb, 2017 </span>&emsp; 
						<span class='glyphicon glyphicon-tag'>Web Design</span><br />
						<hr>
						<p style='opacity: 0.6'>${product.material }</p>
						<%-- 
						<c:if test="${islogin eq 'isLogin'}">
							<button class='btn btn-sm btn-info' type='button'> <img width='20px' src='./img/사람.png'>추가	</button>
							<button class='btn btn-sm btn-info' type='button' id="pick${product.code}" value="${product.code}"> <img width='20px' src='./img/사람.png'>찜</button>
						</c:if>
						 --%>
					</td>
				</tr>

			</c:forEach>

		</table>
	</div>


	<div id="myForm" class="hide">
		<form action="Login" id="popForm" method="post">
			<div>
				<label for="email" style="color: white;">ID</label> <br />
				<input type="text" name="mid" id="mid" class="form-control input-md" style="background-color: #677475;">
			</div>
			<div>
				<label for="password" style="color: white;">비밀번호</label> <br />
				<input type="password" name="mpw" id="mpw" class="form-control input-md" style="background-color: #677475;">
				<div style="margin-top: 20px">
					<button type="button" class="btn btn-gray btn-sm" id="check">로 그 인</button>
					<button type="button" class="btn btn-gray btn-sm" id="findpw">비밀번호 찾기</button>
				</div>
			</div>
		</form>
	</div>
	<div id="result"></div>
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">


			<div class="modal-content">
				<form name="registerform" method="post"
					enctype="multipart/form-data" action="./register">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">×</button>
						<h3 class="modal-title">Sign Up</h3>
					</div>
					<div class="modal-body">
						<div class="cntainer">
							<div class="well">
								<div class="container">
									<div class="form-group">
										<label for="email">ID*:</label> <br /> <input type="email"
											class="form-control" id="email" placeholder="Enter email"
											name="email">
									</div>
									<div class="form-group">
										<label for="pwd">Password*:</label><br /> <input
											type="password" class="form-control" id="pwd"
											placeholder="Enter password" name="pwd">
									</div>
									<div class="form-group">
										<label for="userPwCheck">비밀번호 확인*</label><br /> <input
											type="password" id="userPwCheck" class="form-control"
											maxlength="20" autocomplete="off">
									</div>
									<div class="form-group">
										<label for="username">이름*</label><br /> <input type="text"
											id="userId" class="form-control" maxlength="20" value="">
									</div>
									<div class="form-group">
										<label for="useradress">주소*</label><br /> <input type="text"
											id="userId" class="form-control" maxlength="20" value="">
									</div>
									<div class="form-group">
										<label for="email01">이메일*</label>
									</div>
									<div class="form-group">
										<input type="text" id="email01" class="form-inline"
											name="email01" size="20" maxlength="20" value=""
											autocomplete="off"><span>@</span> <input id="email02"
											name="email02" class="form-inline" list="domains"
											placeholder="도메인입력/선택">
										<datalist id="domains">
											<option value="naver.com">
											<option value="daum.net">
											<option value="gmail.com">
											<option value="yahoo.co.kr">
										</datalist>
									</div>
									<div class="fieldlabel">
										<label for="mPhone1">전화번호</label>
									</div>
									<div class="formfield">
										<select id="mPhone1" name="mPhone1">
											<option value="010" selected>010</option>
											<option value="011">011</option>
											<option value="016">017</option>
											<option value="018">018</option>
											<option value="019">019</option>
										</select>- <input id="mPhone2" name="mPhone2" type="number" value=""
											size="4" maxlength="4" autocomplete="off">- <input
											id="mPhone3" name="mPhone3" type="number" value="" size="4"
											maxlength="4" autocomplete="off">
									</div>
									<br />
									<fieldset class="scheduler-border" id="option">
										<legend class="scheduler-border">알레르기*</legend>
										<div class="formfield">
											<input type="checkbox" name="hobby" value="대두" alt="취미">
											대두 <input type="checkbox" name="hobby" value="땅콩" alt="취미">
											땅콩 <input type="checkbox" name="hobby" value="우유" alt="취미">
											우유 <input type="checkbox" name="hobby" value="우유" alt="취미">
											게 <br> <input type="checkbox" name="hobby" value="새우"
												alt="취미"> 새우 <input type="checkbox" name="hobby"
												value="참치" alt="취미"> 참치 <input type="checkbox"
												name="hobby" value="연어" alt="취미"> 연어 <input
												type="checkbox" name="hobby" value="쑥" alt="취미"> 쑥 <br>
											<input type="checkbox" name="hobby" value="소고기" alt="취미">
											소고기 <input type="checkbox" name="hobby" value="닭고기" alt="취미">
											닭고기 <input type="checkbox" name="hobby" value="돼지고기" alt="취미">
											돼지고기 <br> <input type="checkbox" name="hobby"
												value="복숭아" alt="취미"> 복숭아 <input type="checkbox"
												name="hobby" value="민들레" alt="취미"> 민들레 <input
												type="checkbox" name="hobby" value="계란흰자" alt="취미">
											계란흰자
										</div>
									</fieldset>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<a href="./main.jsp" style="align: left; margin-right: 450px"><input
							type="button" class="btn btn-primary btn-sm" value="등록"></a>
						<button algin="right" type="button" class="btn btn-default"
							data-dismiss="modal">Close</button>
					</div>
				</form>
			</div>

		</div>
	</div>
	​

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