<template>
  <div>
    <table class="list_table">
      <col width="10%" />
      <col width="20%" />
      <col width="20%" />
      <col width="20%" />
      <col width="10%" />
      <tr>
        <th>사원 아이디</th>
        <th>사원명</th>
        <th>부서</th>
        <th>직책</th>
        <th>연봉</th>
      </tr>
      <tr @click="show_detail(cemp.id)">
        <td v-html="cemp.id"></td>
        <td v-html="cemp.name"></td>
        <td v-html="cemp.dept_id"></td>
        <td v-html="cemp.title"></td>
        <td>{{ cemp.salary | salarydecimal }}</td>
      </tr>
    </table>

    <div class="search_box">
      <h3>
        <span style="color:blue;" v-html="cemp.name"></span>의 부하 직원들
      </h3>
    </div>
    <table class="list_table">
      <col width="10%" />
      <col width="20%" />
      <col width="20%" />
      <col width="20%" />
      <col width="10%" />
      <tr>
        <th>사원 아이디</th>
        <th>사원명</th>
        <th>부서</th>
        <th>직책</th>
        <th>연봉</th>
      </tr>
      <tr v-for="emp in info" class="nicecolor" v-bind:key="emp.id">
        <td v-html="emp.id"></td>
        <td v-html="emp.name"></td>
        <td v-html="emp.dept_id"></td>
        <td v-html="emp.title"></td>
        <td>{{ emp.salary | salarydecimal }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "detailcustomer",
  props: ["id"],
  data() {
    return {
      info: [],
      loading: true,
      errored: false,
      cid: "",
      cemp: {}
    };
  },
  filters: {
    salarydecimal(value) {
      var a = parseInt(value);
      return a.toFixed(2);
    }
  },
  methods: {
    show_detail: function(employeeid) {
      alert(employeeid + "수정하기");
      //아래를 수정했다.
      this.$router.push("/updatecustomer/" + employeeid);
    },
    show_init: function() {
      http
        .get("/findEmployeeById/" + this.id)
        .then(response => (this.cemp = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));

      http
        .get("/findEmployeesByManagerId/" + this.id)
        .then(response => (this.info = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    }
  },
  mounted() {
    this.show_init();
  }
};
</script>

<style>
.searchform {
  max-width: 300px;
  margin: auto;
}
.search-result {
  margin-top: 20px;
  text-align: left;
}
</style>