<template>
  <div>
    <table class="list_table">
      <col style="width:80%;" />
      <tr>
        <td>
          <svg :width="totalmember()*50" :height="depcountheight()">
            <template v-for="(depcount, index) in depcounts">
              <g
                :transform="transform(0, index)"
                @mouseover="showdept(depcount.dept_id)"
                :key="depcount.dept_id"
              >
                <rect :width="100*depcount.count" height="29" />
                <text
                  :x="100*depcount.count"
                  y="15"
                  dy=".35em"
                >{{depcount.dept_id}}:{{depcount.name}}:{{depcount.count}}명</text>
              </g>
            </template>
          </svg>
        </td>
      </tr>
    </table>
    <div v-if="showme()">
      <div class="search_box">부서별 직원</div>
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
        <tr v-for="emp in info" class="nicecolor" :key="emp.id">
          <td v-html="emp.id"></td>
          <td v-html="emp.name"></td>
          <td v-html="emp.dept_id"></td>
          <td v-html="emp.title"></td>
          <td>{{ emp.salary | salarydecimal }}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "chart-customer",
  data() {
    return {
      deptid2: 0,
      depcounts: [],
      loading: true,
      errored: false,
      info: []
    };
  },
  methods: {
    totalmember() {
      var a = 0;
      for (var i = 0; i < this.depcounts.length; i++) {
        a += this.depcounts[i].count;
      }
      return a;
    },
    transform(val1, val2) {
      return `translate(${val1}, ${val2 * 30})`;
    },
    depcountheight() {
      return this.depcounts.length * 30;
    },
    showme() {
      return this.deptid2 != 0;
    },
    showdept(deptid) {
      this.deptid2 = deptid;
      http
        .get("/findDepartmentsBydeptid/" + deptid)
        .then(response => (this.info = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    }
  },
  mounted() {
    http
      .get("/findAllDepCounts")
      .then(response => (this.depcounts = response.data))
      .catch(() => {
        this.errored = true;
      })
      .finally(() => (this.loading = false));
  },
  filters: {
    salarydecimal(value) {
      var a = parseInt(value);
      return a.toFixed(2);
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