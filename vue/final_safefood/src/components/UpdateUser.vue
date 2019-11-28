<template>

<div>
  <div class="modal-body">
						<div class="cntainer">
							<div class="well">
								<div class="container">
									<form action="" method="post" @submit.prevent="SignUp">
									<div class="form-group">
										<label for="email">ID*:</label> <br />
										<input type="text"
											class="form-control" id="email" name="pid" v-model="pid" readonly>
									</div>
									<div class="form-group">
										<label for="pwd">Password*:</label><br />
										<input
											type="password" class="form-control" id="pwd"
											placeholder="Enter password" name="ppw1" v-model="ppw1">
									</div>
									<div class="form-group">
										<label for="userPwCheck">비밀번호 확인*</label><br />
										<input
											type="password" id="userPwCheck" class="form-control"
											maxlength="20" autocomplete="off" name="ppw2" v-model="ppw2">
									</div>
									<div class="form-group">
										<label for="username">이름*</label><br />
										<input type="text"
											id="userId" class="form-control" maxlength="20" value=""
											name="pname" v-model="pname">
									</div>
									<div class="form-group">
										<label for="useradress">주소*</label><br />
										<input type="text"
											id="userId" class="form-control" maxlength="20" value=""
											name="paddr" v-model="paddr">
									</div>

									<div class="form-group">
										<label for="email01">이메일*</label>
									</div>
									<div class="form-group">
										<input type="text" id="email01" class="form-inline"
											name="pemail1" size="20" maxlength="20" value=""
											autocomplete="off" v-model="pemail1"><span>@</span>
										<input id="email02"
											name="pemail2" class="form-inline" list="domains"
											placeholder="도메인입력/선택" v-model="pemail2">
									</div>

									<div class="form-group">
										<label for="email01">번호*</label>
									</div>
									<div class="formfield">
										<select id="mPhone1" name="ptel1" v-model="ptel1">
											<option value="010" selected>010</option>
											<option value="011">011</option>
											<option value="016">017</option>
											<option value="018">018</option>
											<option value="019">019</option>
										</select>- <input id="mPhone2" name="ptel2" type="number" value=""
											size="4" maxlength="4" autocomplete="off" v-model="ptel2">- <input
											id="mPhone3" name="ptel3" type="number" value="" size="4"
											maxlength="4" autocomplete="off" v-model="ptel3">
									</div>
									<br />
									<fieldset class="scheduler-border" id="option">
										<legend class="scheduler-border">알레르기*</legend>
										<div class="formfield">
											<input type="checkbox" name="hobby" value="대두" alt="취미" v-model="hobby">
											대두 <input type="checkbox" name="hobby" value="땅콩" alt="취미" v-model="hobby">
											땅콩 <input type="checkbox" name="hobby" value="우유" alt="취미" v-model="hobby">
											우유 <input type="checkbox" name="hobby" value="게" alt="취미" v-model="hobby">
											게<br> <input type="checkbox" name="hobby" value="새우"
												alt="취미" v-model="hobby">
												새우 <input type="checkbox" name="hobby"
												value="참치" alt="취미" v-model="hobby">
												참치 <input type="checkbox"
												name="hobby" value="연어" alt="취미" v-model="hobby">
												연어 <input
												type="checkbox" name="hobby" value="쑥" alt="취미" v-model="hobby">
												쑥 <br>
											<input type="checkbox" name="hobby" value="소고기" alt="취미" v-model="hobby">
											소고기 <input type="checkbox" name="hobby" value="닭고기" alt="취미" v-model="hobby">
											닭고기 <input type="checkbox" name="hobby" value="돼지고기" alt="취미" v-model="hobby">
											돼지고기 <br> <input type="checkbox" name="hobby"
												value="복숭아" alt="취미" v-model="hobby">
												복숭아 <input type="checkbox"
												name="hobby" value="민들레" alt="취미" v-model="hobby">
												민들레 <input
												type="checkbox" name="hobby" value="계란흰자" alt="취미" v-model="hobby">
											계란흰자
										</div>
									</fieldset>
									<div class="modal-footer">
										<button style = "display:hidden" class="btn btn-primary btn-sm" @click="SignUp()" algin="right" type="button"
							data-dismiss="modal" ><router-link   style="color:white"  algin="right" type="button"
							data-dismiss="modal" to="/">수정확인</router-link ></button>

						<router-link   algin="right" type="button" class="btn btn-default"
							data-dismiss="modal" to="/">Close</router-link >
					</div>
									</form>
								</div>
							</div>
						</div>
					</div>
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
        show: true,
        pid: localStorage.getItem("saveid"),
        ppw1: '',
        ppw2: '',
        pname: '',
        paddr: '',
        pemail1: '',
        pemail2: '',
        ptel1: '',
        ptel2: '',
        ptel3: '',
        alinfo: '',
        hobby: [],
        date: '',
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
        .get("/memInfo/" + localStorage.getItem("saveid"))
        .then(response => (this.cemp = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
  },
  methods: {
    SignUp() {
        if (this.title == '') {
            alert('제목을 입력하세요.');
            return;
        }
        if (this.id == '') {
            alert('아이디를 입력하세요.');
            return;
        }
        if (this.content == '') {
            alert('내용을 입력하세요.');
            return;
        }
        for (let index = 0; index < this.hobby.length; index++) {
            if (index != 0) {
                this.alinfo = this.alinfo + ", ";
            }
            this.alinfo = this.alinfo + this.hobby[index];
        }
        alert(this.alinfo)
        http
            .put('/Update', {
                id: this.pid,
                pw: this.ppw1,
                name: this.pname,
                addr: this.paddr,
                email: this.pemail1 + "@" + this.pemail2,
                tel: this.ptel2 + "-" + this.ptel2 + "-" + this.ptel3,
                alinfo: this.alinfo
            })
            .then(() => {
                alert("수정 처리를 하였습니다.");
                this.login_show = true;
                this.Sign_Up_show = false;
            });
        this.submitted = true;
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