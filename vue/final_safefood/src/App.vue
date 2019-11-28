<template>
<div id="app">
<div id="app" >
<!-- <div class='headtitle'><h2>SSAFY App.vue</h2></div> -->
    <!-- #1 : Button trigger modal -->


<p style="display:none;">{{save_id}}</p>
<!-- <p>{{savestate}}</p> -->
<!-- <p>{{save_state}}</p>
 -->
<!--  <h1 class = 'aa'>sdfsdf</h1> -->
<header class="header-area">
    <div class="container">
        <div class="header-wrap">
            <div
                class="header-top d-flex justify-content-between align-items-center navbar-expand-md">
                <div class="col navbar navbar-expand-md justify-content-end">
                    <p v-if="savestate" style="font-family:italic">
						{{save_id}}님
                    </p>
                </div>
                <div class="col-3 logo">
                    <!-- <p v-if="savestate">{{save_id}}</p> -->
                </div>
                <nav class="col navbar navbar-expand-md justify-content-end">

                    <!-- Toggler/collapsibe Button -->
                    <button
                        class="navbar-toggler"
                        type="button"
                        data-toggle="collapse"
                        data-target="#collapsibleNavbar">
                        <span class="lnr lnr-menu"></span>
                    </button>
                    <!-- Navbar links -->
                    <div class="collapse navbar-collapse menu-right" id="collapsibleNavbar">
                        <ul class="navbar-nav justify-content-center w-100">
                            <li class="nav-item hide-lg">
                                <a class="nav-link" href="index.html">공지사항</a>
                            </li>
                            <li class="nav-item hide-lg">
                                <a class="nav-link" href="menu.html">menu</a>
                            </li>
                            <li class="nav-item hide-lg">
                                <a class="nav-link" href="about.html">about</a>
                            </li>
                            <!-- Dropdown -->
                            <li class="nav-item dropdown" style="visibility:hidden">
                                <a
                                    class="nav-link dropdown-toggle"
                                    href="#"
                                    id="navbardrop"
                                    data-toggle="dropdown">
                                    Pages
                                </a>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="contact.html">Contact</a>
                                    <a class="dropdown-item" href="elements.html">Elements</a>
                                </div>
                            </li>
                            <li v-if="savestate" class="nav-item">
                                <a class="nav-link" href="#" @click="logout()">Logout</a>
                            </li>
                            <li v-if="savestate" class="nav-item">
                                <a class="nav-link" href="#">
                                    <router-link to="/DetailUser">detail</router-link>
                                </a>
                            </li>

                            <li v-if="!savestate" class="nav-item">
                                <a class="nav-link" data-toggle="modal" href="#mylog">
                                    <img width="20px">login</a>

                                    <div class="modal fade" id="mylog" role="dialog">
                                        <div class="modal-dialog">
                                            <div class="modal-content">

                                                <form action="Login" id="popForm" method="post">
                                                    <div>
                                                        <label for="email" style="color: white;">ID</label>
                                                        <br/>
                                                        <input
                                                            type="text"
                                                            name="mid"
                                                            id="mid"
                                                            class="form-control input-md"
                                                            style="background-color: #677475;"
                                                            v-model="usernameOrEmail"></div>
                                                        <div>
                                                            <label for="password" style="color: white;">비밀번호</label>
                                                            <br/>
                                                            <input
                                                                type="password"
                                                                name="mpw"
                                                                id="mpw"
                                                                class="form-control input-md"
                                                                style="background-color: #677475;"
                                                                v-model="password">
                                                                <div style="margin-top: 20px">
                                                                    <button
                                                                        data-dismiss="modal"
                                                                        @click="login()"
                                                                        type="button"
                                                                        class="btn btn-gray btn-sm"
                                                                        id="check">로 그 인</button>

                                                                    <button type="button" class="btn btn-gray btn-sm" id="findpw">비밀번호 찾기</button>
                                                                </div>
                                                            </div>
                                                        </form>
                                                        <button data-dismiss="modal" type="button">
                                                            확인
                                                        </button>

                                                    </div>
                                                </div>
                                            </div>

								<li v-if="!savestate" class="nav-item"><a class="nav-link"  data-toggle="modal" href="#myModal"><img width="20px">SignUp</a>

<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h3 class="modal-title">Sign Up</h3>
				</div>
					<div class="modal-body">
						<div class="cntainer">
							<div class="well">
								<div class="container">
									<form action="" method="post" @submit.prevent="SignUp">
									<div class="form-group">
										<label for="email">ID*:</label> <br />
										<input type="text"
											class="form-control" id="email" name="pid" v-model="pid">
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
										</select> - <input id="mPhone2" name="ptel2" type="number" value=""
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

						<button @click="SignUp()" class="btn btn-primary btn-sm" value="등록" data-dismiss="modal">등록</button>

						<button  algin="right" type="button" class="btn btn-default"
							data-dismiss="modal">Close</button>
					</div>
									</form>
								</div>
							</div>
						</div>
					</div>
			</div>

		</div>
	</div>

</li>
							</ul>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</header>

	<div class="container">
			<div class="header-wrap">
				<div class="header-top d-flex justify-content-between align-items-center navbar-expand-md">
					<div class="col menu-left">
						<a class="active" href="#"><router-link to="/boardList">info</router-link></a>
						<a href="#"><router-link  to="/productInfo">product</router-link></a>
						<a href="#"><router-link  to="/main">Gallery</router-link>

						</a>
					</div>
					<div class="col-3 logo">
						<a href="index.html"><router-link  to="/"><img style="width:100px" class="mx-auto" src="img/ps2.png" alt="">
							</router-link>
						</a>
					</div>
					<nav class="col navbar navbar-expand-md justify-content-end">

						<!-- Toggler/collapsibe Button -->
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
							<span class="lnr lnr-menu"></span>
						</button>

						<!-- Navbar links -->
						<div class="collapse navbar-collapse menu-right" id="collapsibleNavbar">
							<ul class="navbar-nav justify-content-center w-100">
								<li class="nav-item hide-lg">
									<a class="nav-link" href="index.html">공지사항</a>
								</li>
								<li class="nav-item hide-lg">
									<a class="nav-link" href="menu.html">menu</a>
								</li>
								<li class="nav-item hide-lg">
									<a class="nav-link" href="about.html">about</a>
								</li>
								<!-- Dropdown -->
								<li class="nav-item dropdown">
									<a class="nav-link" href="gallery.html">
										<router-link  to="/Mypick">cart</router-link>
									</a>
								</li>
								<li class="nav-item dropdown">
									<!-- <a class="nav-link" href="gallery.html">
										gallery
									</a> -->
								</li>
								<li class="nav-item">
									<a class="nav-link" href="gallery.html">
										<router-link  to="/qnalist">QnA</router-link>
									</a>
								</li>
							</ul>
						</div>
					</nav>
				</div>
			</div>
		</div>

    <!-- #2 : Modal Window -->
    <div v-if="login_show">
		<form action="Login" id="popForm" method="post">
			<div>
				<label for="email" style="color: white;">ID</label> <br /> <input
					type="text" name="mid" id="mid" class="form-control input-md"
					style="background-color: #677475;" v-model="usernameOrEmail">
			</div>
			<div>
				<label for="password" style="color: white;">비밀번호</label> <br />
				<input
					type="password" name="mpw" id="mpw" class="form-control input-md"
					style="background-color: #677475;"
					v-model="password">
				<div style="margin-top: 20px">
					<button @click="login()" type="button" class="btn btn-gray btn-sm" id="check">로
						그 인</button>
					<button type="button" class="btn btn-gray btn-sm" id="findpw">비밀번호
						찾기</button>
				</div>
			</div>
		</form>
        <button @click="login_toggle" type="button">
            확인
        </button>
    </div>
  </div>
  <!-- #3 : Modal Window -->
  <div v-if="Sign_Up_show">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h3 class="modal-title">Sign Up</h3>
				</div>
					<div class="modal-body">
						<div class="cntainer">
							<div class="well">
								<div class="container">
									<form action="" method="post" @submit.prevent="SignUp">
									<div class="form-group">
										<label for="email">ID*:</label> <br />
										<input type="text"
											class="form-control" id="email" name="pid" v-model="pid">
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
										</select> - <input id="mPhone2" name="ptel2" type="number" value=""
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
						<input type="submit" class="btn btn-primary btn-sm" value="등록">
						<button @click="SignUp()" algin="right" type="button" class="btn btn-default"
							data-dismiss="modal">Close</button>
					</div>
									</form>
								</div>
							</div>
						</div>
					</div>

			</div>
	<hr style="border:solid 5px">

		<div  style="min-height:100%;">
        <router-view/>
		</div>
		<br/>
		<p>
		<footer>


		</footer>
</div>

</template>
<script>

import http from "./http-common";

import Vue from 'vue'
import Vuex from "vuex";

Vue.use(Vuex)


const logstore = new Vuex.Store({
	state:{now_id:''},

	mutations:{
		addlogin:function(state,payload){
			state.now_id = payload;
			localStorage.setItem('currentId',payload);
		}
	},
	actions:{
		chelogin:function(logstore,payload){
			logstore.commit('addlogin',payload);
		}
	}
})

export default {
    name: "app",
    data() {
        return {
            usernameOrEmail: "",
            password: "",
            pid: '',
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
            login_show: false,
			Sign_Up_show: false,
			loginche:false,
			loginreal:false,
			booleanche:false,
			saveid:'',
			savestate:false
        };
	},
	computed:{
			save_id(){
				if(this.loginche){
					localStorage.setItem("savestate",this.loginche)
					localStorage.setItem("saveid",this.usernameOrEmail)
					this.save_state_method() //지금 상태 저장
					this.save_id_method() //지금 id 저장
					this.login_show_down() //로그인되는 순간 -> 아이디 비번 창 닫기
				}
				if(!this.loginche&&localStorage.getItem("savestate")){
					this.save_state_method()
					this.save_id_method()
				}
				//alert(this.loginche+"    "+localStorage.getItem("savestate"))
				if(!this.loginche&&!localStorage.getItem("savestate")){
					//alert("잘못입력했습니다")
				}
				else{
					//alert("다시입력")
				}
				//alert(this.savestate + "   " + this.saveid + "    " + this.loginche + "     " + localStorage.getItem("savestate"))
				return this.saveid
			},
		},

methods : {
cheche() {
    logstore.dispatch('chelogin',this.usernameOrEmail);
},
save_state_method:function(){
	this.savestate = localStorage.getItem("savestate")
},
save_id_method:function(){
	this.saveid = localStorage.getItem("saveid")
},

login_show_down(){
	this.login_show = false
},

logout:function(){
	/* alert(this.savestate + "   " + this.saveid + "    " + this.loginche + "     " + localStorage.getItem("savestate")) */
	this.savestate = false
	this.booleanche = true
	this.loginche = false
	//alert("??")
	localStorage.clear("savestate")
	localStorage.clear("saveid")

	/* alert(this.savestate + "   " + this.saveid + "    " + this.loginche + "     " + localStorage.getItem("savestate")) */


	this.save_state_method()
		//location.reload
	/*
	this.save_id_method()
	alert(this.savestate+" "+this.saveid)
	*/location.reload()
},

login_toggle: function () {
    if (this.Sign_Up_show) {
        this.Sign_Up_show = false;
    }
    this.login_show = !this.login_show; // #2, #3
},
Sign_Up_toggle: function () {
    if (this.login_show) {
        this.login_show = false;
    }
    this.Sign_Up_show = !this.Sign_Up_show; // #2, #3
},
	login(){
		http
            .post('/Login', {
                id: this.usernameOrEmail,
                pw: this.password,
            })
            .then(
				response => (this.loginche = response.data),
			);
	},
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
            .post('/SignUp', {
                id: this.pid,
                pw: this.ppw1,
                name: this.pname,
                addr: this.paddr,
                email: this.pemail + "@" + this.pemail2,
                tel: this.ptel2 + "-" + this.ptel2 + "-" + this.ptel3,
                alinfo: this.alinfo
            })
            .then(() => {
                alert("등록 처리를 하였습니다.");
                this.login_show = true;
                this.Sign_Up_show = false;
            });
        this.submitted = true;
    }
}
};

</script>
<style>

</style>