<template>
<div>
<div class="jumbotron junjun"
		style=" background-image: url('./img/음식.jpg'); margin-bottom: 0px; height:500px">
		<div class="container" style="text-align: center">
			<h1 style="font-size:6em; color: white">WHAT WE PROVIDE</h1>
			<hr style="border:solid 5px; color:black" >
			<p style="font-size:1.5em; color: white">건강한 삶을 위한 먹거리 프로젝트</p>
		</div>

	</div>
	<div>
	<section class="food_menu gray_bg" style="background-color:white">
        <div class="container">
            <div class="row justify-content-between">
                <div class="col-lg-5">

                </div>

                <div class="col-lg-12">
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active single-member" id="Special" role="tabpanel" aria-labelledby="Special-tab">
                            <div class="row">
                                <div class="col-sm-6 col-lg-6">
                                    <div class="isotope-container row grid-space-10"
			style="height: 476.74px; display: block; position: relative;">

			<div class="col-lg-4 col-md-6 isotope-item app-development"
				style="left: 0px; top: 0px; position: absolute;">
				<div class="image-box hc-shadow-2 text-center mb-20">
					<div class="overlay-container">
						<a href="pdetail?code=20"><img width="200"
							class="center" alt="아카페라아메리카노" src="img/아카페라아메리카노.jpg"></a>
					</div>
				</div>
			</div>

			<div class="col-lg-4 col-md-6 isotope-item app-development"
				style="left: 373px; top: 0px; position: absolute;">
				<div class="image-box hc-shadow-2 text-center mb-20">
					<div class="overlay-container">
						<a href="pdetail?code=7"><img width="200"
							class="center" alt="누크바" src="img/N45누크바.jpg"></a>
					</div>
				</div>
			</div>

			<div class="col-lg-4 col-md-6 isotope-item app-development"
				style="left: 747px; top: 0px; position: absolute;">
				<div class="image-box hc-shadow-2 text-center mb-20">
					<div class="overlay-container">
						<a href="pdetail?code=8"><img width="200"
							class="center" alt="비비빅" src="img/비비빅.jpg"></a>
					</div>
				</div>
			</div>

			<div class="col-lg-4 col-md-6 isotope-item app-development"
				style="left: 0px; top: 238px; position: absolute;">
				<div class="image-box hc-shadow-2 text-center mb-20">
					<div class="overlay-container">
						<a href="pdetail&code=11"><img width="200"
							class="center" alt="서울우유바나나" src="img/서울우유바나나.jpg"></a>
					</div>
				</div>
			</div>

			<div class="col-lg-4 col-md-6 isotope-item app-development"
				style="left: 373px; top: 238px; position: absolute;">
				<div class="image-box hc-shadow-2 text-center mb-20">
					<div class="overlay-container">
						<a href="pdetail?code=6"><img width="200"
							class="center" alt="메로나" src="img/메로나.jpg"></a>
					</div>
				</div>
			</div>

			<div class="col-lg-4 col-md-6 isotope-item app-development"
				style="left: 747px; top: 238px; position: absolute;">
				<div class="image-box hc-shadow-2 text-center mb-20">
					<div class="overlay-container">
						<a href="pdetail?code=2"><img width="200"
							class="center" alt="진라면컵매운맛" src="img/진라면컵매운맛.jpg"></a>
					</div>
				</div>
			</div>

		</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</div>

<div class="footer" style="background-color: #EEEEEE">
		<div class="container">
			<div class="footer-inner">
				<div class="row">
					<div class="col-lg-10">
						<div class="footer-content">
                            <img src="img/ssafy.png" width="100px">

							<hr>
							<div class="separator-2"></div>
							<ul class="list-icons" style="list-style: none;">
								<li ><img src="img/위치.png" width="20px"> ssafy2기 선한빛</li>
								<li ><img src="img/전화.png" width="20px"> ssafy2기 임준형</li>
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
  name: "foodlist",
  data() {
    return {
      upHere: false,
      foodlist: [],
      loading: true,
      errored: false,
      search:'',
      searchType:''
    };
  },
  filters:{
    imgfilter:function(path){
      // var ss="../assets/"+path;
      return "../assets/"+path;
    }
  },
  methods: {


    show_detail: function(code) {
      this.$router.push("/pdetail/" + code);
    }
  },
};
</script>

<style>
</style>
