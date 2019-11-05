<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script type="text/javascript" src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- <script -->
<!-- 	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> -->
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> -->


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

.form-group{
width: 40%;
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

<div id="myForm" class="hide">
		<form action="/echo/html/" id="popForm" method="get">
			<div>
				<label for="email" style="color:white;" >ID</label> <br/><input type="text" name="email"
					id="email" class="form-control input-md"
					style="background-color: #677475;"> 
			</div>
			<div>		
				<label for="password" style="color:white;" >비밀번호</label> <br/>
				<input type="password" name="name" id="name"
					class="form-control input-md" style="background-color: #677475;">
				<div style="margin-top:20px">
				<button type="submit" class="btn btn-gray btn-sm">로 그 인</button>
				<button type="button" class="btn btn-gray btn-sm">비밀번호 찾기</button>
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




	<!-- Sign up,  Login 부분 -->
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
	<!-- Sign up,  Login 부분 -->

	<!-- SSAFY IMG -->
	<a href="main.do?action=main"> <img src="./img/ssafy.png"></a>
	<!-- SSAFY IMG -->

	<!-- navigation bar 부분 -->
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
	<!-- navigation bar 부분 -->

	<section class="main-container">
		<div class="container">
			<div class="row">
				<div class="main col-12">
					<!-- page-title start -->
					<h1 class="page-title text-center">제품 정보</h1>
					<div class="separator with-icon">
						<i class="fa fa-shopping-bag bordered"></i>
						<!-- ::after -->
					</div>
				</div>
				<!-- page-title end -->

				<div class="image-box style-3-b">
					<div class="row">
						<!-- 아메리카노 Image start-->
						<div class="col-md-6 col-lg-4 col-xl-3">
							<div class="overlay-container">
								<img src="${food.image}" style = "max-width : 300px"> <a
									class="overlay-link popup-img-single" href="img/아카페라아메리카노.jpg">
									<i class="fa fa-search-plus"> </i>
								</a>
							</div>
						</div>
						<!-- 아메리카노 Image end-->

						<div class="col-lg-8 col-xl-7 pv-30">
							<table class="table">
								<tbody>
									
									<tr>
										<td width="100">제품명</td>
										<td>${food.name }</td>
									</tr>
									<tr>
										<td width="100">제조사</td>
										<td>${food.maker }</td>
									</tr>
									<tr>
										<td width="100">원재료</td>
										<td>${food.material }</td>
									</tr>
									<tr>
										<td width="100px">알레르기 성분</td>
										<td></td>
									</tr>
									
								</tbody>
							</table>
							<form class="clearfix row grid-space-10">
								<div class="form-group">
									<label>Quantity</label> <input type="text" class="form-control"
										id="qnt" name="qnt" value="1">
								</div>
							</form>
							<div class="product elements-list">
								<label> </label>
								<div class="btn-group">
									<a href="#" onclick="addIntakeFood(20)"
										class="btn btn-default btn-sm"> <i class="fa fa-user pr-2">
									</i> " 추가"
									</a> <a href="#" onclick="addIntakeFood(20)"
										class="btn btn-default btn-sm"> <i class="fa fa-user pr-2">
									</i> " 찜"
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>

				<h4 class="space-top">영양 정보</h4>
				<div class="row">
					<div class="col-sm-6">
						<!-- <div class="chartjs-size-monitor" style="position:absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
     						<div class="chartjs-size-moniter-expand" style="position:absolute;left;0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
     							<div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0">
     						</div>
     					</div>
     					<div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;">
     						<div style="position:absolutewidth:200%;height:200%;left:0; top:0">
     						</div>
     					</div> -->
						<canvas id="doughnut-graph" height="230"></canvas>
						<!-- <canvas id="doughnut-graph" height="184" style="display: block; width: 240px; height: 184px;" width="240" class="chartjs-render-monitor"> -->
						<!-- </canvas> -->
					</div>
					<div class="col-sm-6">
						<table class="table">

							<tbody>
								<tr>
									<td width="200">일일 제공량</td>
									<td>${food.supportpereat }</td>
								</tr>
								<tr>
									<td width="200">칼로리</td>
									<td>${food.calory}</td>
								</tr>
								<tr>
									<td width="200">탄수화물</td>
									<td>${food.carbo}</td>
								</tr>
								<tr>
									<td width="200">단백질</td>
									<td>${food.protein}</td>
								</tr>
								<tr>
									<td width="200">지방</td>
									<td>${food.fat}</td>
								</tr>
								<tr>
									<td width="200">당류</td>
									<td>${food.sugar}</td>
								</tr>
								<tr>
									<td width="200">나트륨</td>
									<td>${food.natrium}</td>
								</tr>
								<tr>
									<td width="200">콜레스테롤</td>
									<td>${food.chole}</td>
								</tr>
								<tr>
									<td width="200">포화 지방산</td>
									<td>${food.fattyacid}</td>
								</tr>
								<tr>
									<td width="200">트랜스지방</td>
									<td>${food.transfat}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!--  main end -->
				<br /> <br />
			</div>
		</div>
		</div>
	</section>


	<!-- footer start (Add "dark" class to #footer in order to enable dark footer) -->
	<!-- ================ -->
		<!-- .footer start -->
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
		<!-- footer end -->

		</div>
		<!-- page-wrapper end -->

		
		
</body>


		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

		<!-- Magnific Popup javascript -->
		<script src="plugins/magnific-popup/jquery.magnific-popup.min.js"></script>
		<!-- Appear javascript -->
		<script src="plugins/waypoints/jquery.waypoints.min.js"></script>
		<script src="plugins/waypoints/sticky.min.js"></script>
		<!-- Count To javascript -->
		<script src="plugins/countTo/jquery.countTo.js"></script>
		<!-- Slick carousel javascript -->
		<script src="plugins/slick/slick.min.js"></script>
		<!-- Initialization of Plugins -->
		<script src="js/template.js"></script>
		<!-- Custom Scripts -->
		<script src="js/custom.js"></script>
		<!-- Charts -->
		<script src="plugins/charts/Chart.js"></script>
		<script src="js/Chart.js"></script>

		<script>
            var ctx = document.getElementById("doughnut-graph")
                    .getContext("2d");
            console.log(ctx)
            var transfat = "${food.transfat }";
            if(transfat  == "N/A") transfat = 0;
            var sugar = "${food.sugar }";
            if(sugar  == "N/A") sugar = 0;
            var chole = "${food.chole }";
            if(chole  == "N/A") chole = 0;
            var fattyacid = "${food.fattyacid }";
            if(fattyacid  == "N/A") fattyacid = 0;
            var myChart = new Chart(ctx,
                    {
                        //var supportpereat = ${food.supportpereat} == "N/A" ? 0 : ${food.supportpereat};
                        //var transfat =  ${food.transfat }  == "N/A" ? 0 : ${food.transfat};
                        type : 'doughnut',
                        data : {
                            labels : [ "칼로리", "탄수화물", "단백질", "지방", "당류", "나트륨",
                                    "콜레스테롤", "포화 지방산", "트렌스지방" ],
                            datasets : [ {
                                label : '# of Votes',
                                data : [ ${food.calory },${food.carbo}, ${food.protein }, ${food.fat }, sugar, ${food.natrium},
                                    chole, fattyacid, transfat],
                                backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
                                        'rgba(54, 162, 235, 0.2)',
                                        'rgba(255, 206, 86, 0.2)',
                                        'rgba(75, 192, 192, 0.2)',
                                        'rgba(153, 102, 255, 0.2)',
                                        'rgba(255, 159, 64, 0.2)',
                                        'rgba(255, 153, 255, 0.2)',
                                        'rgba(102, 0, 153, 0.2)',
                                        'rgba(51, 0, 0, 0.2)' ],
                                borderColor : [ 'rgba(255, 99, 132, 1)',
                                        'rgba(54, 162, 235, 1)',
                                        'rgba(255, 206, 86, 1)',
                                        'rgba(75, 192, 192, 1)',
                                        'rgba(153, 102, 255, 1)',
                                        'rgba(255, 159, 64, 1)',
                                        'rgba(255, 153, 255, 1)',
                                        'rgba(102, 0, 153, 1)',
                                        'rgba(51, 0, 0, 1)' ],
                                borderWidth : 1
                            } ]
                        },
                        options : {
                            scales : {
                                yAxes : [ {
                                    ticks : {
                                        beginAtZero : true
                                    }
                                } ]
                            }
                        }
                    });
        </script>
</html>