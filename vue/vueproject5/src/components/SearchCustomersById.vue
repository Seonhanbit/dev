<template>
  <div>
    <div class="search_box">
      <select name="id" v-model="cid" @change="findbyid" v-cloak>
        <option v-for="emp in info" v-bind:value="emp.id" :key="emp.id">{{ emp.name }}</option>
      </select>
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
      <tr>
        <td v-html="cemp.id"></td>
        <td v-html="cemp.name"></td>
        <td v-html="cemp.dept_name"></td>
        <td v-html="cemp.title"></td>
        <td>{{ cemp.salary | salarydecimal }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "search-customer-id",
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
  mounted() {
    http
      .get("/findAllEmployees")
      .then(response => (this.info = response.data))
      .catch(() => {
        this.errored = true;
      })
      .finally(() => (this.loading = false));
  },
  methods: {
    findbyid() {
      http
        .get("/findEmployeeById/" + this.cid)
        .then(response => (this.cemp = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    }
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