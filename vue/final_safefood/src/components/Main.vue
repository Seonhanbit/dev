<template>
  <div class='box1'>
    <div v-for="food in foodlist" :key="food.code" style="float:left">
     <div class='col-md-5 card-p'    style="min-width:600px">
		<div class='card mb-3'>
			<div class='row no-gutters'>
				<div class='col-md-4' style='width: 210px; min-height: 180px'>
					<img :src="food.image" width='200' class='card-img' alt='...'>
					<div class='overlay'></div>
				</div>
				<div class='col-md-8'>
					<div class='card-body' style='height: 220px;'>
						<h3 style="font-family:italic" class='card-title' v-html="food.name"></h3>
						<p class='card-text' v-html="food.maker"></p>
						<p class='card-text ' v-html="food.material" style='width: 300px; font-size:10px'  >
							<small class='text-muted'></small>
						</p>
            <p></p>
					</div>
				</div>

			</div>
		</div>
    <a href='#' class=btn1>추가</a><a href='#' class=btn1> 찜</a>
	</div>
    </div>
     <br>
    </div>
</template>

<script>
import http from "../http-common";

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
    searchfood(search,searchType){
      http
        .get("/searchProduct/"+ searchType+"/"+search)
        .then(response => (this.foodlist = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    productinfo() {
      http
        .get("/productInfo")
        .then(response => (this.foodlist = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    refreshList() {
      this.productinfo();
    },
    show_detail: function(code) {
      this.$router.push("/pdetail/" + code);
    }
  },
  mounted() {
    this.productinfo();
  }
};
</script>

<style>
</style>
