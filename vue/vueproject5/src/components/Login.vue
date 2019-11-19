<template>
  <div id="main_wrap">
    <div id="middle_wrap" v-if="visablelogin">
      <div id="content_wrap">
        <div
          style="width:502px; height:166px; margin-left:auto; margin-right:auto; position:relative; top:100px;"
        >
          <div class="login_title_warp">
            <div style="margin-top:12px;">
              <h2>SSAFY HRM 로그인</h2>
            </div>
          </div>
          <div id="login_wrap">
            <form class="login" @submit.prevent="login">
              <table class="content_table" style="width:75%;">
                <colgroup>
                  <col style="width:30%;" />
                  <col style="width:70%;" />
                </colgroup>
                <tbody>
                  <tr>
                    <th style="background-color:#eeeeee; color:#3e5fba;">아이디</th>
                    <td>
                      &nbsp;
                      <input
                        type="text"
                        id="_userid"
                        name="id"
                        value
                        data-msg="ID를"
                        size="30"
                        title="아이디"
                        required
                        v-model="usernameOrEmail"
                        placeholder="아이디를 입력하세요."
                        style="border:1px solid #dddddd;"
                      />
                    </td>
                  </tr>
                  <tr>
                    <th style="background-color:#eeeeee; color:#3e5fba;">패스워드</th>
                    <td>
                      &nbsp;
                      <input
                        type="password"
                        id="_pwd"
                        name="pwd"
                        value
                        required
                        v-model="password"
                        placeholder="패스워드를 입력하세요."
                        size="30"
                        title="패스워드"
                        style="border:1px solid #dddddd;"
                      />
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2" style="height:50px; text-align:center;">
                      <button type="submit">로그인</button> &nbsp;&nbsp;
                      <button
                        type="button"
                        @click="visablelogin=!visablelogin"
                      >회원가입으로 이동</button>
                    </td>
                  </tr>
                </tbody>
              </table>
            </form>
          </div>
        </div>
      </div>
    </div>
    <div v-if="!visablelogin">
      <div class="search_box">
        <h3>
          <span style="color:blue;">회원가입</span>
        </h3>
      </div>
      <div v-if="!submitted">
        <form action method="post" id="_frmForm" name="frmForm" @submit.prevent="registryMyself">
          <table class="content_table">
            <colgroup>
              <col style="width:30%;" />
              <col style="width:70%;" />
            </colgroup>
            <tr>
              <th>아이디용이름</th>
              <td>
                <input
                  data-msg="이름"
                  type="text"
                  name="username"
                  id="_username"
                  v-model="customer.username"
                  style="width:30%"
                />
              </td>
            </tr>
            <tr>
              <th>이름</th>
              <td>
                <input
                  data-msg="이름"
                  type="text"
                  name="cname"
                  id="_cname"
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
                  type="email"
                  name="email"
                  id="_email"
                  size="20"
                  v-model="customer.email"
                  style="width:30%"
                />
              </td>
            </tr>
            <tr>
              <th>패스워드</th>
              <td>
                <input
                  data-msg="패스워드"
                  type="password"
                  name="password"
                  id="_password"
                  size="30"
                  v-model="customer.password"
                  style="width:30%"
                />
              </td>
            </tr>

            <tr>
              <td colspan="2" style="height:50px; text-align:center;">
                <button type="submit" name="button">회원가입</button>&nbsp;&nbsp;
                <button type="button" @click="visablelogin=!visablelogin">로그인으로 이동</button>
              </td>
            </tr>
          </table>
        </form>
      </div>

      <div class="search_box" v-else>
        <h3>
          <span style="color:blue;">성공적으로 입사처리를 완료하였습니다!</span>
        </h3>
      </div>
    </div>
  </div>
</template>
<style>
#login_wrap {
  margin: auto;
}
#login_wrap th {
  font-weight: bold;
}
#main_wrap {
  width: 800px;
  margin-left: auto;
  margin-right: auto;
  padding: 0px;
}

.login_title_warp {
  margin: auto;
  width: 500px;
  color: #ffffff;
  text-align: center;
  background-color: #3e5fba;
  border: solid 1px #efefef;
  font-weight: bold;
  height: 60px;
}
</style>

<script>
import { AUTH_REQUEST } from "../store/actions/auth";
import http2 from "../http-common2";
export default {
  name: "login",
  data() {
    return {
      visablelogin: true,
      usernameOrEmail: "",
      password: "",
      customer: {
        username: "",
        cname: "",
        email: "",
        password: ""
      },
      submitted: false
    };
  },
  methods: {
    login: function() {
      //model에 바인딩된 데이터 모두 ==> this
      const { usernameOrEmail, password } = this;
      this.$store
        .dispatch(AUTH_REQUEST, { usernameOrEmail, password })
        .then(() => {
          this.$router.push("/");
        });
    },
    registryMyself() {
      if (this.customer.username == "") {
        alert("아이디용이름 입력하세요.");
        return;
      }
      if (this.customer.cname == "") {
        alert("이름을 입력하세요.");
        return;
      }
      if (this.customer.email == "") {
        alert("이메일을 입력하세요.");
        return;
      }
      if (this.customer.password == "") {
        alert("패스워드를 입력하세요.");
        return;
      }

      http2
        .post("/signup", {
          username: this.customer.username,
          name: this.customer.cname,
          email: this.customer.email,
          password: this.customer.password
        })
        .then(response => {
          //console.log(response.data);
          if (
            response.data.success == true ||
            response.data.success == "true"
          ) {
            alert("성공적으로 가입 하였습니다. 로그인 하십시오.");
            this.visablelogin = true;
            this.submitted = true;
          } else {
            alert("가입을 하지 못했습니다.");
            this.visablelogin = false;
            this.submitted = false;
            this.newCustomer();
          }
        })
        .catch(() => {
          alert("가입을 하지 못했습니다.");
          this.visablelogin = false;
          this.submitted = false;
          this.newCustomer();
        });
    },
    newCustomer() {
      this.customer = {
        username: "",
        cname: "",
        email: "",
        password: ""
      };
    }
  }
};
</script>
