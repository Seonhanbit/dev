<template>
  <div>
    <div style="background-color: #696969; padding: 20px; text-align: center">
		<table style="margin-left: auto; margin-right: auto;">
			<tr>
				<th style="color: white">검색 조건</th>
				<th style="color: white">검색 단어</th>
			</tr>
			<tr>
					<input type="hidden" name="action" value="searchProduct">
					<th>
            <select v-model="searchType" name="searchType">
							<option value="상품명" name="pname">상품명</option>
							<option value="제조사" name="pcom">제조사</option>
					</select>
          </th>
					<th><input type="text" class="selectbox" name=search v-model="search" @keyup="searchfood(search,searchType)">
          </th>

			</tr>
		</table>
    </div>
  <br>

    <div>
      <table class="list_table">
        <col width="10%" />
        <col width="20%" />
        <col width="20%" />
        <col width="20%" />
        <col width="10%" />
        <col width="10%" />
        <tr>
          <th>이미지</th>
          <th>상품명</th>
          <th>제조사</th>
          <th>원재료</th>
        </tr>
        <tr v-for="food in foodlist" class="nicecolor" :key="food.code">
          <td @click="show_detail(food.code)">
            <img :src="food.image" width="150px">
          </td>
          <td v-html="food.name" @click="show_detail(food.code)" ></td>
          <td v-html="food.maker"></td>
          <td v-html="food.material"></td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
//리스트 받기
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
      alert(code + "상세보기");
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
