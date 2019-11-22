<template>
  <div>


    <div class="jumbotron"
		style="background-color: #A9A9A9; margin-bottom: 0px">
		<div class="container" style="text-align: center">
			<h1 style="color: white">WHAT WE PROVIDE</h1>
			<hr>
			<p style="color: white">건강한 삶을 위한 먹거리 프로젝트</p>
		</div>
	</div>


    <div>
      <table class="list_table">
        <col width="20%" />
        <col width="20%" />
        <col width="20%" />
        <col width="20%" />
        <tr v-for="food in foodlist" class="nicecolor" :key="food.code">
          <td><img :src="food.image" width="150px"></td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
//리스트 받기
import http from "../http-common";

export default {
  name: "qnalist",
  data() {
    return {
      upHere: false,
      foodlist: [],
      loading: true,
      errored: false
    };
  },
  methods: {
    productinfo() {
      http
        .get("/productInfo")
        .then(response => (this.foodlist = response.data))
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
