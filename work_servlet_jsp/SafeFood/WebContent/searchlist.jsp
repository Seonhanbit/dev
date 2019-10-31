<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SafeFood</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="./bootstrap-3.3.2-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="./bootstrap-3.3.2-dist/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="./css/main.css">
	
	<script type="text/javascript" src="./js/custom.js"></script>
	<script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="./bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
</head>

<nav class="navbar navbar-fixed-top" style="background-color: #2e3537;">
	<section class="header-top-section">
		<div class="row">
			<div class="col-md-6">
				<div class="header-top-content">
					<ul class="nav nav-pills navbar-left">
					</ul>
				</div>
			</div>
			<div class="col-md-6">
				<ul class="nav nav-pills navbar-right" id="nara">
				<c:choose>
						<c:when test = "${id eq null }">
					<li>
						<div class="dropdown">
							<button class="btn btn-sm dropdown-toggle glyphicon glyphicon-user" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="background-color: #2c2c2c; color: #ffffff; margin: 7px">Log in</button>
							<div class="dropdown-menu" aria-labelledby="dropdownMenuButton"
								style="background-color: #2e3537;">											
								<form class="loginform" action="member.do?action=login" method="post" id ="loginform"
									style="width: 300px; height: 310px; border: 0;">
									<br />
									<div style="margin-top: 10px; margin-left: 30px; color:#fff">아 이 디</div>
									<br /> <input type="text" name="pid" id="pid" maxlength="30"
										style="border: none; border-right: 0px; border-top: 0px; boder-left: 0px; boder-bottom: 0px; margin-left: 30px; padding: .3em .5em; cursor: text; width: 200px; background-position: center right; background-repeat: no-repeat; background-color: #777777;">
									<br /> <br />
									<div style="margin-top: 10px; margin-left: 30px; color:#fff">비 밀 번
										호</div>
									<br /> <input type="password" name="ppw" id="ppw" maxlength="30"
										style="border: none; border-right: 0px; border-top: 0px; boder-left: 0px; boder-bottom: 0px; margin-left: 30px; padding: .3em .5em; cursor: text; width: 200px; background-position: center right; background-repeat: no-repeat; background-color: #777777;">
									<br />
									<br /> <input type="button" value="로그인" onclick="login()"
										style="color: white; margin-left: 30px; margin-top: 10px; background: #e1e1e1; border: solid 2px grey; border-radius: 5px; height: 30px; width: 60px;" />
									<br /> <a href="searchpw.jsp"><input type="button" value="비밀번호 찾기"
										style="color: white; margin-left: 30px; margin-top: 10px; background: #697980ad; border: solid 2px grey; boder-bottom: 0px; border-radius: 5px; height: 30px; width: 100px;" /></a>	
								</form>			
							</div>
						</div>
					</li>
					<li><a href="registerMem.html" class="btn btn-sm glyphicon glyphicon-user" style = "background-color: #2c2c2c; color: #ffffff; margin: 7px">회원가입</a></li>
					
					</c:when>
						<c:otherwise>		
							<input class="btn btn-secondary dropdown-toggle" style="background-color: #2c2c2c; color: #ffffff; margin: 7px" type="button" value="로그아웃" onclick="logout()">							
							<input class="btn btn-secondary dropdown-toggle" style="background-color: #2c2c2c; color: #ffffff; margin: 7px" type="button" value="회원 조회" onclick="meminfo()">
						</c:otherwise>										
					</c:choose>
				</ul>
			</div>
		</div>
	</section>
</nav>

<body style="padding-top: 40px;">
	<!-- Navigation Bar -->
	<div class="row"
		style="background-color: #ffffff; height: 100px; margin-top: 10px;">
		<div class="col-md-1"></div>
		<div class="col-md-3">
			<a href="food.do"><img src="./img/ssafy.png" width="120px"></a>
		</div>
		<div class="col-md-7">
			<ul class="nav navbar-nav" style="float: right;">
				<li><a href="./searchlist.jsp">상품 정보</a></li>
				<li><a href="./food.do?action=myallergy">칼로리 관리</a></li>
				<li><a href="#">내 섭취 정보</a></li>
				<li><a href="#">예상 섭취 정보</a></li>
				<li><a href="#" class="glyphicon glyphicon-search"></a></li>
			</ul>
		</div>
		<div class="col-md-1"></div>
	</div>

	<!-- 점보트론? -->
	<div class="row" style="background-color: #6C6C6C; height: 200px;">
		<div class="col-md-1"></div>
		<div class="col-md-10"
			style="color: white; margin: 30px; text-align: center;">
			<h2>WHAT WE PROVIDE</h2>
			<div class="divide-line-center"></div>
			<p style="padding: 15px;">건강한 삶을 위한 먹거리 프로젝트</p>
		</div>
		<div class="col-md-1"></div>
	</div>

	<!-- 검색 -->
	<div class="row" style="height: 100px; background-color: #373737;">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="row" style="color: white; margin: 10px;">
				<div class="col-md-4"">검색 조건</div>
				<div class="col-md-7">검색 단어</div>
				<div class="col-md-1"></div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<select class="form-control" name="key" id="key">
						<option value="name" selected="selected">상품명</option>
						<option value="maker">제조사</option>
						<option value="material">재료명</option>
					</select>
				</div>
				<div class="col-md-7">
					<input type="text" class="form-control" name="search-input">
				</div>
				<div class="col-md-1">
					<button type="button" name="search" class="btn btn-info">검색</button>
				</div>
			</div>
			<div class="row"></div>
		</div>
		<div class="col-md-4"></div>
	</div>

	<!-- 상품정보 리스트 -->
	<section style="padding: 50px 0;">
		<div class="container-fluid" style="margin-left: 120px;">
			<div class="row">
				<c:forEach items="${foodlist }" var="food">
					<div class="main col-md-6">
						<div class="col-md-12" style="margin-bottom: 50px;"></div>
						<div class="card mb-3">
							<div class="row no-gutters">
								<div class="col-md-4">
									<a href="#"><img src="${food.img }" width="200" class="card-img">
										<span class="desc"> <strong>${food.name }<br />${food.maker }
										</strong></span></a>
								</div>
								<div class="col-md-8">
									<div class="card-body">
										<h3 class="title"><a href="./nutrition.html">${food.name }</a></h3>
										<p class="card-description">
											<i style="margin-left: 10px;"
												class="glyphicon glyphicon-calendar"></i>&nbspFeb,2017&nbsp&nbsp
											<i class="glyphicon glyphicon-tag"></i>&nbspWeb,Design&nbsp
										</p>
										<p style="width: 400px; height: 150px; margin-left: 10px; overflow: auto;">${food.material }</p>
										<div class="btn-group">
											<a class="btn btn-info btn-sm"><img src="img/add.png"
												width="15px">추가</a> <a class="btn btn-info btn-sm"><img
												src="img/heart.png" width="15px">찜</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>

	<div class="footer-main bg-dark py-5 small">
		<div class="container-fluid" style="margin: 20px;">
			<h3>Find Us</h3>
			<hr>
			<i class="glyphicon glyphicon-map-marker">&nbsp</i><span>(SSAFY)
				서울시 강남구 테헤란로 멀티스퀘어</span><br> <i class="glyphicon glyphicon-earphone">&nbsp</i><span>1544-9001</span><br>
			<i class="glyphicon glyphicon-envelope">&nbsp</i><span>admin@ssafy.com</span><br>
		</div>
	</div>

</body>
</html>