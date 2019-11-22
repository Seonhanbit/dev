<template>
<div id="app">
<div class='headtitle'><h2>SSAFY App.vue</h2></div>

<div class='search_box'>
 <nav>
        <router-link class="btn btn-primary" to="/"><img src="../public/img/ssafy.png"></router-link>
        <router-link class="btn btn-primary" to="/boardList">공지사항</router-link> |
        <router-link class="btn btn-primary" to="/productInfo">상품정보</router-link> |
        <router-link class="btn btn-primary" to="/">베스트 섭취 정보</router-link> |
        <router-link class="btn btn-primary" to="/">예상 섭취 정보</router-link> |
        <router-link class="btn btn-primary" to="/qnalist">모든 QnA 보기</router-link>
        <!--<router-link class="btn btn-primary" to="/search">이름으로 사원 찾기</router-link> |
        <router-link class="btn btn-primary" to="/searchbyid">아이디로 사원 찾기</router-link>
        -->
 </nav>
</div>
        <router-view/>

<!-- footer -->
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
								<li style="opacity: 0.6"><img src="../public/img/위치.png" width="20px"> (SSAFY) 서울시 강남구 테헤란로 멀티스퀘어</li>
								<li style="opacity: 0.6"><img src="../public/img/전화.png" width="20px"> 1544-9001</li>
								<li style="opacity: 0.6"><a href="#"><img src="../public/img/이메일.png" width="20px"> admin@ssafy.com</a></li>
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
						<p text="text-center" style="opacity: 0.6">Copyright by
							SSAFY. All rights reserved.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


</template>

<script>
export default {
  name: "app"
};
</script>

<style>
.footer{
  text-align: center;
}

.subfooter{
  text-align: center;
}
</style>
