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
          <th>사원 아이디</th>
          <th>사원명</th>
          <th>부서</th>
          <th>직책</th>
          <th>연봉</th>
          <th>퇴사</th>
        </tr>
        <tr v-for="emp in info" class="nicecolor" :key="emp.id">
          <td v-html="emp.id" @click="show_detail(emp.id)"></td>
          <td v-html="emp.name" @click="show_detail(emp.id)"></td>
          <td v-html="emp.dept_name"></td>
          <td v-html="emp.title"></td>
          <td>{{ emp.salary | salarydecimal }}</td>
          <td class="button" @click="delete_emp(emp.id)">
            <input type="button" class="blue" value="퇴사" />
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import http from "../http-common";
export default {
  name: "customers-list",
  data() {
    return {
      upHere: false,
      info: [],
      loading: true,
      errored: false
    };
  },
  methods: {
    retrieveCustomers() {
      http
        .get("/findAllEmployees")
        .then(response => (this.info = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    refreshList() {
      this.retrieveCustomers();
    },
    show_detail: function(employeeid) {
      alert(employeeid + "상세보기");
      this.$router.push("/detailcustomer/" + employeeid);
    },
    delete_emp(employeeid) {
      if (employeeid == 1) {
        alert("사장님은 퇴사할 수 없습니다.");
        return;
      }
      alert(employeeid + "가 퇴사합니다.");
      http
        .post("/deleteEmployee/" + employeeid)
        .then(response => {
          if (response.data.state == "succ") {
            alert("퇴사처리를 하였습니다.");
            this.retrieveCustomers();
          } else {
            alert("퇴사처리를 하지 못했습니다.");
          }
        })
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    }
  },
  filters: {
    salarydecimal(value) {
      var a = parseInt(value);
      return a.toFixed(2);
    }
  },
  mounted() {
    this.retrieveCustomers();
  }
};
</script>

<style>
</style>
