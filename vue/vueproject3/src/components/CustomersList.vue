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
//axios로 데이터를 불러오는 코드
import http from "../http-common";

//@click은 v-on:click과 같은 의미(값이 바뀌어도 리 랜더링 안함)
//v-if는 true일때 나오고, false일때는 주석처리 -> 없는 것과 같음
//v-show는 true일때 나오고, false일때는 display:none -> DOM트리 안에 있고 값 넣을 수 있음

//v-bind : 단방향, 가져오기만 가능
//v-model : 양방향, 한쪽 값이 바뀌면 자동으로 바뀜

export default {
  name: "customers-list",
  data() {
    //데이터를 함수로 리턴하는 이유
    //vue데이터 바꿀 때 DOM까지 반영시키기 위해 사용 : 리랜더링
    return {
      upHere: false,
      info: [], //배열값은 초기화 필요
      loading: true,
      errored: false
    };
  },
  methods: {
    retrieveCustomers() {
      http
        .get("/findAllEmployees") //URI값
        .then(response => (this.info = response.data)) //성공 시
        .catch(() => { //실패 시
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
  filters: { // 적용 방식 {{ emp.salary | salarydecimal }}
    salarydecimal(value) {
      var a = parseInt(value);
      return a.toFixed(2);
    }
  },
  mounted() {
    //뷰 사이클 중 마운트 할때 하겠다
    //DOM  삽입 단계
    this.retrieveCustomers();
  }
};
</script>

<style>
</style>
