<template>
  <div>
    <div class="search_box">
      <h3>
        <span style="color:blue;">사원정보수정</span>
      </h3>
      <button class="btn btn-success" @click="show_detail()">사원 정보 보기</button>
    </div>

    <div v-if="!submitted">
      <form action method="post" id="_frmForm" name="frmForm" @submit.prevent="updateEmployee">
        <table class="content_table">
          <colgroup>
            <col style="width:30%;" />
            <col style="width:70%;" />
          </colgroup>
          <tr>
            <th>이름</th>
            <td>
              <input
                data-msg="이름"
                type="text"
                name="name"
                id="_name"
                v-model="customer.cname"
                style="width:30%"
              />
            </td>
          </tr>
          <tr>
            <th>이메일</th>
            <td>
              <input
                data-msg="이메일"
                type="text"
                name="mailid"
                id="_mailid"
                size="20"
                v-model="customer.mailid"
                style="width:30%"
              />
            </td>
          </tr>
          <tr>
            <th>고용일</th>
            <td>
              <input
                data-msg="고용일"
                type="date"
                name="start_date"
                id="_start_date"
                size="30"
                v-model="customer.start_date"
                style="width:30%"
              />
            </td>
          </tr>
          <tr></tr>
          <tr>
            <th>관리자</th>
            <td>
              <select name="manager_id" v-model="customer.manager_id" style="width:30%">
                <option
                  v-for="emp in info"
                  v-bind:value="emp.id"
                  :key="emp.id"
                >{{ emp.id }}:{{ emp.name }}</option>
              </select>
            </td>
          </tr>
          <tr>
            <th>직책</th>
            <td>
              <select name="title" v-model="customer.title" style="width:30%">
                <option
                  v-for="emp in titls"
                  v-bind:value="emp.title"
                  :key="emp.title"
                >{{ emp.title }}</option>
              </select>
            </td>
          </tr>
          <tr>
            <th>부서</th>
            <td>
              <select name="dept_id" v-model="customer.dept_id" style="width:30%">
                <option
                  v-for="dept in deps"
                  v-bind:value="dept.dept_id"
                  :key="dept.dept_id "
                >{{ dept.dept_id }}: {{ dept.name }}</option>
              </select>
            </td>
          </tr>
          <tr>
            <th>월급</th>
            <td>
              <input
                data-msg="월급"
                type="number"
                name="salary"
                id="_salary"
                size="30"
                min="0"
                v-model="customer.salary"
                style="width:30%"
              />
            </td>
          </tr>
          <tr>
            <th>커미션</th>
            <td>
              <input
                data-msg="커미션"
                type="number"
                name="commission_pct"
                id="_commission_pct"
                size="30"
                min="0"
                v-model="customer.commission_pct"
                style="width:30%"
              />
            </td>
          </tr>
          <tr>
            <td colspan="2" style="height:50px; text-align:center;">
              <button type="submit" name="button" class="btn btn-success">정보수정하기</button>
            </td>
          </tr>
        </table>
      </form>
    </div>

    <div class="search_box" v-else>
      <h3>
        <span style="color:blue;">성공적으로 수정하였습니다!</span>
      </h3>
    </div>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "updatecustomer",
  props: ["id"], //받은 인자값
  data() {
    return {
      info: null,
      loading: true,
      errored: false,
      deps: null,
      titls: null,
      customer: {
        commission_pct: 0,
        dept_id: 0,
        mailid: "",
        manager_id: 0,
        cname: "",
        salary: 0,
        start_date: "",
        title: ""
      },
      submitted: false
    };
  },
  mounted() {
    http
      .get("/findEmployeeById/" + this.id)
      .then(response => {
        this.customer = response.data;
      })
      .catch(() => {
        this.errored = true;
      })
      .finally(() => (this.loading = false));
    http
      .get("/findAllEmployees")
      .then(response => (this.info = response.data))
      .catch(() => {
        this.errored = true;
      })
      .finally(() => (this.loading = false));
    http
      .get("/findAllDepartments")
      .then(response => (this.deps = response.data))
      .catch(() => {
        this.errored = true;
      })
      .finally(() => (this.loading = false));
    http
      .get("/findAllTitles")
      .then(response => (this.titls = response.data))
      .catch(() => {
        this.errored = true;
      })
      .finally(() => (this.loading = false));
  },
  methods: {
    show_detail: function() {
      alert(this.id + "상세보기");
      //아래를 수정했다.
      this.$router.push("/detailcustomer/" + this.id);
    },
    updateEmployee() {
      if (this.customer.cname == "") {
        alert("아이디를 입력하세요.");
        return;
      }
      if (this.customer.dept_id == "") {
        alert("부서를 선택하세요.");
        return;
      }
      if (this.customer.mailid == "") {
        alert("이메일을 선택하세요.");
        return;
      }
      if (this.customer.manager_id == "") {
        alert("관리자를 선택하세요.");
        return;
      }
      if (this.customer.salary == "") {
        alert("월급을 입력하세요.");
        return;
      }
      if (this.customer.start_date == "") {
        alert("입사일을 선택하세요.");
        return;
      }
      if (this.customer.title == "") {
        alert("직책을 선택하세요.");
        return;
      }

      http
        .post("/updateEmployee", {
          //Stringboot 서버를 보면 DTO로 받으니까 받을 인자 id까지 같이 넘겨주기
          commission_pct: this.customer.commission_pct,
          dept_id: this.customer.dept_id,
          mailid: this.customer.mailid,
          manager_id: this.customer.manager_id,
          name: this.customer.cname,
          salary: this.customer.salary,
          start_date: this.customer.start_date,
          title: this.customer.title,
          id: this.id
        })
        .then(response => {
          if (response.data.state == "succ") {
            alert("정보를 수정 하였습니다.");
          } else {
            alert("정보를 수정 하지 못했습니다.");
          }
        });
      this.submitted = true;
    },
    newCustomer() {
      (this.submitted = false),
        (this.info = null),
        (this.loading = true),
        (this.errored = false),
        (this.deps = null),
        (this.titls = null),
        (this.customer = {
          commission_pct: 0,
          dept_id: 0,
          mailid: "",
          manager_id: 0,
          cname: "",
          salary: 0,
          start_date: "",
          title: ""
        });
    }
  }
};
</script>

<style>
.submitform {
  max-width: 300px;
  margin: auto;
}
</style>
