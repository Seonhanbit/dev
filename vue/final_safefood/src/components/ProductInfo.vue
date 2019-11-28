
<template>
  <div style="margin:50px">
    <div style="background-color: #000000; padding: 20px; text-align: center">
		<table style="margin-left: auto; margin-right: auto; border: 4px solid #000000;">
			<tr>
				<th style="color: white">검색 조건</th>
				<th style="color: white">검색 단어</th>
			</tr>
			<tr>
					<input type="hidden" name="action" value="searchProduct">
          <th>
            <center>
            <select v-model="searchType" name="searchType">
							<option value="상품명" name="pname">상품명</option>
							<option value="제조사" name="pcom">제조사</option>
					</select>
            </center>
          </th>
					<th><input type="text" class="selectbox" name=search v-model="search" @keyup="searchfood(search,searchType)">
          </th>

			</tr>
		</table>
    </div>

<!-- 키워드 보여주기 -->
      <div align="center">
        <span>오늘 당신이 가장 많이 검색한 키워드는 "{{key }}"입니다.</span>
      </div>
      <div align="center">
            검색한 단어가 포함된 제품수 : {{cnt}}
      </div>

  <br>

    <div>
      <table class="list_table">
        <col width="10%" />
        <col width="10%" />
        <col width="10%" />
        <col width="50%" />
        <tr>
          <th>이미지</th>
          <th>상품명</th>
          <th>제조사</th>
          <th>원재료</th>
        </tr>

        <tr  v-for="food in foodlist" class="nicecolor" :key="food.code">
          <td style="background-color:white" @click="show_detail(food.code)">
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
      searchType:'',
      key:'',
      cnt:''
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
        .then(response => {(this.foodlist = response.data);
        this.searchKey();
          this.searchCnt();})
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
    },
    searchKey() {
      http
        .get("/searchKey")
        .then(response => (this.key = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    searchCnt() {
      http
        .get("/searchCnt/"+this.searchType+"/"+this.search)
        .then(response => (this.cnt = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
  },
  mounted() {
    this.productinfo();
  }
};
</script>

<style>
</style>
