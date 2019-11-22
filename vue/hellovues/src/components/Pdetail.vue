<template>
  <div>
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
         <td><img :src="'/'+food.image" width="150px"></td>
      </tr>
      <tr>
        <th>제품명</th><td v-html="food.name"></td>
      </tr>
      <tr>
        <th>제조사</th><td v-html="food.maker"></td>
      </tr>
      <tr>
        <th>원재료</th><td v-html="food.material"></td>
      </tr>
      </table>
    </div>
  </div>
</template>

<script>
//리스트 받기
import http from "../http-common";

export default {
  name: "fooddetail",
  props: ["code"],
  data() {
    return {
      upHere: false,
      food: {},
      loading: true,
      errored: false
    };
  },
  filters:{
    imgfilter:function(path){
      // var ss="../assets/"+path;
      return "../assets/"+path;
    }
  },
  methods: {
    AddQna(){
      this.$router.push("/add");
    },
    productinfo() {
      http
        .get("/pdetail/"+this.code)
        .then(response => (this.food = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    refreshList() {
      this.productinfo();
    },
    show_detail: function(id) {
      alert(id + "상세보기");
      this.$router.push("/pdetail/" + id);
    }
  },
  mounted() {
    this.productinfo();
  }
};
</script>

<style>
</style>
