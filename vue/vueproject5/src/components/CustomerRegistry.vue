<template>
<div>
<div class='search_box'>
<h3><span style='color:blue;'>회원가입</span></h3>
</div>
<div v-if="!submitted">
<form action="" method="post" id="_frmForm" name="frmForm" @submit.prevent="registryMyself">
<table class="content_table">
<colgroup>
		<col style="width:30%;" />
		<col style="width:70%;" />							
</colgroup>	
<tr>
<th>아이디용이름</th>
<td><input data-msg="이름" type="text" name="username" id="_username"  v-model="customer.username" style="width:30%"/></td>
</tr>
<tr>
<th>이름</th>
<td><input data-msg="이름" type="text" name="cname" id="_cname"  v-model="customer.cname" style="width:30%"/></td>
</tr>
<tr>
<th>이메일</th>
<td><input data-msg="이메일" type="email" name="email"  id="_email" size="20" 
v-model="customer.email" style="width:30%"/></td>
</tr>
<tr>
<th>패스워드</th>
<td><input data-msg="패스워드" type="password" name="password"  id="_password"
 size="30" v-model="customer.password" style="width:30%"/></td>
</tr>

<tr>
<td colspan="2" style="height:50px; text-align:center;">
<button type="submit" name="button">회원가입</button></td>
</tr>
</table>
</form>
</div>

<div class='search_box' v-else>
<h3><span style='color:blue;'>성공적으로 입사처리를 완료하였습니다!</span></h3>
<button type="button" @click="newCustomer()">회원가입</button> 
</div>
</div>
</template>

<script>
import http2 from "../http-common2";

export default {
    name: 'customerregistry' ,
	data() {
		return {
			customer: {
				username:'',
				cname:'',
				email:'',
				password:''
			},
			submitted: false
		};
	},
	methods: {
		registryMyself() {
			if(this.customer.username==''){ alert('아이디용이름 입력하세요.'); return ;}
			if(this.customer.cname==''){ alert('이름을 입력하세요.'); return ;}
			if(this.customer.email==''){ alert('이메일을 입력하세요.'); return ;}
			if(this.customer.password==''){ alert('패스워드를 입력하세요.'); return ;}
			http2.post('/signup', {  
				username: this.customer.username,
				name: this.customer.cname,
				email: this.customer.email,
				password: this.customer.password
			}).then(response => {
				//console.log(response.data);
				if (response.data.success==true ||response.data.success=='true') {
					alert("성공적으로 가입 하였습니다. 로그인 하십시오.");
					this.visablelogin=true;
					this.submitted = true;
				}else{
					alert("가입을 하지 못했습니다.");
					this.visablelogin=false;
					this.submitted = false;
					this.newCustomer();
				}
			}).catch(() => {
					alert("가입을 하지 못했습니다.");
					this.visablelogin=false;
					this.submitted = false;
					this.newCustomer();
			});
		},
		newCustomer() {
			this.customer={
					username:'',
					cname:'',
					email:'',
					password:''
			};
			this.submitted = false;
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
