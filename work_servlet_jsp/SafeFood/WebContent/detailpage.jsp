<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./bootstrap-3.3.2-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./bootstrap-3.3.2-dist/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/graph.css">
    
    <title>제품 정보</title>
    <script type="text/javascript" src="./js/custom.js"></script>
    <script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="./bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
    <script src="./js/Chart.js"></script>
    
    <script type="text/javascript">
      $(document).ready(function () {
          // this fucntion parsing the foodinfo.xml file
                          var nutr1 = ${nutrition.calory};
                          var nutr2 = ${nutrition.carbo};
                          var nutr3 = ${nutrition.protein};
                          var nutr4 = ${nutrition.fat};
                          var nutr5 = ${nutrition.sugar};
                          var nutr6 = ${nutrition.natrium};
                          var nutr7 = ${nutrition.chole};
                          var nutr8 = ${nutrition.fattyacid};
                          var nutr9 = ${nutrition.transfat};
                          $('#calorie').text(nutr1);
                          $('#carbohydrate').text(nutr2);
                          $('#protein').text(nutr3);
                          $('#fat').text(nutr4);
                          $('#sugars').text(nutr5);
                          $('#natrium').text(nutr6);
                          $('#cholesterol').text(nutr7);
                          $('#saturatedFattyAcids').text(nutr8);
                          $('#transFats').text(nutr9);
                          var chart_data = [nutr1, nutr2, nutr3, nutr4, nutr5, nutr6, nutr7, nutr8, nutr9];
                      var ctx = document.getElementById("doughnutChart").getContext("2d");
                      var myChart = new Chart(ctx, {
                          type: 'doughnut',
                          data: {
                              labels: ["칼로리", "탄수화물", "단백질", "지방", "당류", "나트륨", "콜레스테롤",
                                  "포화 지방산", "트렌스지방"],
                              datasets: [{
                                  label: '# of Votes',
                                  data: chart_data,
                                  backgroundColor: ['rgba(255, 99, 132, 0.2)',
                                      'rgba(54, 162, 235, 0.2)',
                                      'rgba(255, 206, 86, 0.2)',
                                      'rgba(75, 192, 192, 0.2)',
                                      'rgba(153, 102, 255, 0.2)',
                                      'rgba(255, 159, 64, 0.2)',
                                      'rgba(255, 153, 255, 0.2)',
                                      'rgba(102, 0, 153, 0.2)', 'rgba(51, 0, 0, 0.2)'],
                                  borderColor: ['rgba(255, 99, 132, 1)',
                                      'rgba(54, 162, 235, 1)', 'rgba(255, 206, 86, 1)',
                                      'rgba(75, 192, 192, 1)', 'rgba(153, 102, 255, 1)',
                                      'rgba(255, 159, 64, 1)', 'rgba(255, 153, 255, 1)',
                                      'rgba(102, 0, 153, 1)', 'rgba(51, 0, 0, 1)'],
                                  borderWidth: 1
                              }]
                          },
                          options: {
                              responsive: true
                          }
                      })
      });
</script>

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
<body>
    <!-- 메뉴바 -->
    <div class="row"
        style="background-color: #ffffff; height: 100px; margin-top: 50px;">
        <div class="col-md-1"></div>
        <div class="col-md-3">
            <a href="./food.do?action=mainpage"><img src="./img/ssafy.png"
                width="120px"></a>
        </div>
        <div class="col-md-7">
            <ul class="nav navbar-nav" style="float: right;">
                <li><a href="./food.do?action=searchlist">상품 정보</a></li>
                <li><a href="./food.do?action=myallergy">칼로리 관리</a></li>
                <li><a href="#">내 섭취 정보</a></li>
                <li><a href="./notice/notice.jsp">공지 사항</a></li>
                <li><a href="#" class="glyphicon glyphicon-search"></a></li>
            </ul>
        </div>
        <div class="col-md-1"></div>
    </div>
    
    <!-- 점보트론? -->
    <div class="row" style="background-color: #6C6C6C; height: 200px;">
        <div class="col-md-1"></div>
        <div class="col-md-10" style="color: white; margin: 30px; text-align: center;">
            <h2>WHAT WE PROVIDE</h2>
            <div class="divide-line-center"></div>
            <p style="padding:15px;">건강한 삶을 위한 먹거리 프로젝트</p>
        </div>
        <div class="col-md-1"></div>
    </div>
    
    
    <h1 class="page-title text-center">제품 정보</h1>
    <div width="100" align="center">
        <img src="./img/shopping-bag.png" width="50" />
    </div>
    <div class="container">
        <div class="table-responsive">
            <table class="table">
                <tbody>
                    <tr>
                        <td rowspan="4" width=100><img id=product_img src="${nutrition.img }" > </td>
                        <td width=100>제품명</td>
                        <td id="product_name">${nutrition.name }</td>
                    </tr>
                    <tr>
                        <td width=100>제조사</td>
                        <td id="manufacturer">${nutrition.maker }</td>
                    </tr>
                    <tr>
                        <td width=100>원재료</td>
                        <td id="Material">${nutrition.material}</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <form class="clearfix row grid-space-10">
            <div class="form-group">
                <label>Quantity</label> <input type="text" class="form-control"
                    id="qnt" name="qnt" value="1">
            </div>
        </form>
        <div class="product elements-list">
            <label> </label>
            <div class="btn-group">
                <a href="#" class="btn btn-default btn-sm"><i class="fa fa-user pr-2"></i>추가</a>
                <a href="#" class="btn btn-default btn-sm"><i class="fa fa-user pr-2"></i>찜</a>
            </div>
        </div>
    </div>
    
    <div class="container">
        <h4 class="space-top">영양 정보</h4>
        <div class="row">
            <div class="col-sm-6">
                <canvas id="doughnutChart" height="230"></canvas>
            </div>
            <div class="col-sm-6">
                <table class="table">
                    <tbody>
                        <tr>
                            <td width='200'>일일 제공량</td>
                            <td id="daily_serving">${nutrition.supportpereat}</td>
                        </tr>
                        <tr>
                            <td width='200'>칼로리</td>
                            <td id="calorie">${nutrition.calory }</td>
                        </tr>
                        <tr>
                            <td width='200'>탄수화물</td>
                            <td id="carbohydrate">${nutrition.carbo}</td>
                        </tr>
                        <tr>
                            <td width='200'>단백질</td>
                            <td id="protein">${nutrition.protein }</td>
                        </tr>
                        <tr>
                            <td width='200'>지방</td>
                            <td id="fat">${nutrition.fat }</td>
                        </tr>
                        <tr>
                            <td width='200'>당류</td>
                            <td id="sugars">${nutrtion.sugar }</td>
                        </tr>
                        <tr>
                            <td width='200'>나트륨</td>
                            <td id="natrium">${nutrition.natrium }</td>
                        </tr>
                        <tr>
                            <td width='200'>콜레스테롤</td>
                            <td id="cholesterol">${nutrition.chole }</td>
                        </tr>
                        <tr>
                            <td width='200'>포화 지방산</td>
                            <td id="saturatedFattyAcids">${nutrition.fattyacid }</td>
                        </tr>
                        <tr>
                            <td width='200'>트렌스지방</td>
                            <td id="transFats">${nutrition.transfat }</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    
    <footer style='clear: both'>
        <div class="container-fluid bg-03">
            <h5 class="font-weight-bold text-uppercase mt-3 mb-4">Find Us</h5>
            <div class="separator-2"></div>
            <ul class="list-unstyled">
                <li><img src="./img/maps-and-flags.png" alt="place">
                    (SSAFY) 서울시 강남구테헤란로 멀티스퀘어</li>
                <li><img src="./img/telephone.png" alt="phone number">
                    1544-9001</li>
                <li><img src="./img/opened.png" alt="e-mail address">admin@ssafy.com</li>
            </ul>
            
            <div class="footer-copyright text-center py-3">Copyright by
                SSAFY All rights reserved</div>
        </div>
    </footer>
</body>
</html>
