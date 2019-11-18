<template>
<div>
<div class='search_box'>
이름으로  찾기 : <input type="text" name='name' v-model="cname" @keyup='searchname' v-cloak/>
</div>
<table class='list_table'>
<col width="10%"><col width="20%">
<col width="20%"><col width="20%"><col width="10%">
<tr>
  <th>사원 아이디</th>
  <th>사원명</th>
  <th>부서</th>
  <th>직책</th>
  <th>연봉</th>
</tr>
 <tr>
<tr v-for="emp in cemps" class = "nicecolor" :key="emp.id">
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
  name: "search-customer",
  data () {
        return {
         // info: [],
          loading: true,
          errored: false ,
          cname:'',
          cemps:[]
        }
      },
  filters: {
      salarydecimal (value) {
      var a=parseInt(value);
      return a.toFixed(2);
    }
  }, 
  methods: {
    searchname(e) {
      if(e.which == 13){ //enter
        http
        .get('/findLikeEmployees/'+this.cname)
        .then(response => (this.cemps = response.data))
        .catch(() => {
          this.errored = true
        })
        .finally(() => this.loading = false);   
      }
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