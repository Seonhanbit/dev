
<template>
  <div>
    <div>
      <!-- tree-data라는 이름으로 tree라는 데이터 값 넘겨줌-->
      <tree :tree-data="tree"></tree>
      <Pie :data="names"></Pie>
    </div>
  </div>
</template>

<script>
import http from "../http-common";
import Tree from "./Tree"; //component 이름으로 태그 달기
import Pie from "./Pie.vue";

export default {
  name: "chartpiecustomer",
  data() {
    return {
      deptid2: 0,
      depcounts: [],
      loading: true,
      errored: false,
      info: [],
      tree: {
        deptname: "SSAFY HRM 부서",
        children: [] //mounted()  될때 데이터가 담김
      },
      names: [] //부서별 사람 수(나한테 데이터 없으니깐 서버 요청하기)
    }; //return
  },
  components: {
    Tree, //등록하기 -> 이 컴포넌트의 이름으로 태그를 지정해서 사용
    Pie
  },
  computed: {},
  methods: {},
  mounted() {
    http
      .get("/findAllDeptEmps2") //부서별 직원 정보 서버에 요청해서 받아옴
      .then(response => (this.tree.children = response.data)) //그 정보를 this.tree.children에 넣어놓음
      .catch(() => {
        this.errored = true;
      })
      .finally(() => (this.loading = false));
    http
      .get("/findAllDepCounts")
      .then(response =>(this.names = response.data))
       .catch(() => {
        this.errored = true;
      })
      .finally(() => (this.loading = false));
  }
};
</script>
<style>
.arc text {
  font: 15px sans-serif;
  text-anchor: middle;
  color: crimson;
}
.arc path {
  stroke: #fff;
}
.arc2 text {
  font: 15px sans-serif;
  text-anchor: middle;
  color: crimson;
}

.arc2 path {
  stroke: #fff;
}
.range-input {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 10px;
}
input {
  margin-left: 10px;
}
</style>