<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
​
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="./bootstrap-3.3.2-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./bootstrap-3.3.2-dist/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/main.css">
​
<script type="text/javascript" src="./js/custom.js"></script>
<script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="./bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
fieldset {
	padding: 10px 25px;
	margin: 15px 0px;
	border: 1px solid silver;
	backgroound-color: #fafafa;
}
​
fieldset legend {
	display: block;
	width: auto;
	padding: 3px 10px;
	margin-bottom: 0;
	font-size: 15px;
	line-height: inherit;
	color: #333333;
	border: 1px solid #ddd;
	background-color: #ffffff;
	font-weight: bold;
}
</style>
<script type="text/javascript">
function searchpw(){
	pwform.submit();
}
</script>
</head>
​
<nav class="navbar navbar-fixed-top" style="background-color: #2e3537;">
	<div class="col-md-1"></div>
	<div class="col-md-10" style="text-align: right;">
		<button class="btn btn-sm dropdown-toggle glyphicon glyphicon-user"
			data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"
			style="background-color: #2c2c2c; color: #ffffff; margin: 7px">&nbspLogin</button>
		<ul class="dropdown-menu dropdown-menu-right"
			style="border: 1px solid #252a2c; background: #2e3537;">
			<li>
				<form class="login-form margin-clear"
					style="background: #2e3537; margin: 20px 20px;">
					<div class="form-group has-feedback">
						<label class="control-label" style="color: #ffffff;">아 이 디</label>
						<input type="text" class="form-control"> <span
							class="glyphicon glyphicon-user form-control-feedback"
							aria-hidden="true"></span>
					</div>
					<div class="form-group has-feedback">
						<label class="control-label" style="color: #ffffff;">비밀번호</label>
						<input type="password" class="form-control"> <span
							class="glyphicon glyphicon-user form-control-feedback"
							aria-hidden="true"></span>
					</div>
					<button type="submit" class="btn btn-sm"
						style="margin-bottom: 20px">로 그 인</button>
					<br>
					<button type="submit" class="btn btn-sm"
						style="background-color: #2c2c2c; color: #ffffff;">비밀번호
						찾기</button>
				</form>
			</li>
		</ul>
		<a href="registerMem.html"><button class="btn btn-sm glyphicon glyphicon-user"
			style="background-color: #2c2c2c; color: #ffffff; margin: 7px">&nbsp회원가입</button></a>
	</div>
	<div class="col-md-1"></div>
</nav>
​
<body style="padding-top: 40px;">
	<!-- Navigation Bar -->
	<div class="container-fluid">
​
		<!-- 메뉴바 -->
		<div class="row"
			style="background-color: #ffffff; height: 100px; margin-top: 10px;">
			<div class="col-md-1"></div>
			<div class="col-md-3">
				<a href="./main.html"><img src="./img/ssafy.png" width="120px"></a>
			</div>
			<div class="col-md-7">
				<ul class="nav navbar-nav" style="float: right;">
					<li><a href="#">공지 사항</a></li>
					<li><a href="./list_product.html">상품 정보</a></li>
					<li><a href="#">베스트 섭취 정보</a></li>
					<li><a href="#">내 섭취 정보</a></li>
					<li><a href="#">예상 섭취 정보</a></li>
					<li><a href="#" class="glyphicon glyphicon-search"></a></li>
				</ul>
			</div>
			<div class="col-md-1"></div>
		</div>
​
		<div class="row">
			<ul class="nav navbar-nav" style="float: left">
				<li class="glyphicon glyphicon-home">Home</li>
				<li>> 비밀번호 찾기</li>
			</ul>
		</div>
​
​
		<div class="row" style="background-color: grey;">
			<div class="row" style="margin: 20px;">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-3" style="text-align: center;">
									<h3>비밀번호 찾기</h3>
								</div>
								<div class="col-md-7"></div>
								<div class="col-md-2"></div>
							</div>
							<div class="col-sm-10">
								<form class="form-horizontal" action="member.do?action=searchpw" method="post" id="pwform">
​
									<div class="form-group has-default has-feedback">
										<label class="control-label col-sm-3">이름 *</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="pname" name="pname"
												aria-describedby="inputSuccess3Status"> <span
												class="glyphicon glyphicon-user form-control-feedback"
												aria-hidden="true"></span>
										</div>
									</div>
									<div class="form-group has-default has-feedback">
										<label class="control-label col-sm-3">아이디 *</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="pid" name="pid"
												aria-describedby="inputSuccess3Status"> <span
												class="glyphicon glyphicon-pencil form-control-feedback"
												aria-hidden="true"></span>
										</div>
									</div>
									<div class="form-group has-default has-feedback">
										<label class="control-label col-sm-3">전화번호 *</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="ptel" name="ptel"
												aria-describedby="inputSuccess3Status"> <span
												class="glyphicon glyphicon-lock form-control-feedback"
												aria-hidden="true"></span>
										</div>
									</div>
​
									<div class="form-group text-center">
										<input type="button" class="btn btn-info" value="비밀번호 찾기 " onclick="searchpw()">
									</div>
									
									<div>
									<p>${id }님의 비밀번호는 ${pw }입니다.</p>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
		
		<div class="footer-main bg-dark py-5 small">
			<div class="container-fluid" style="margin: 20px;">
				<h3>Find Us</h3>
				<hr>
				<i class="glyphicon glyphicon-map-marker">&nbsp</i><span>(SSAFY) 서울시 강남구 테헤란로 멀티스퀘어</span><br>
				<i class="glyphicon glyphicon-earphone">&nbsp</i><span>1544-9001</span><br>
				<i class="glyphicon glyphicon-envelope">&nbsp</i><span>admin@ssafy.com</span><br>
			</div>
		</div>
	</div>
</body>
</html>