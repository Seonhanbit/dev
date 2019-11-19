<template>

<div>
<div v-if="!submitted">
<form action="" method="post" id="_frmForm" name="frmForm" @submit.prevent="addEmployee">
<table class="content_table">
<colgroup>
		<col style="width:30%;" />
		<col style="width:70%;" />
</colgroup>
<tr>
<th>이름</th>
<td><input data-msg="이름" type="text" name="name" id="_name"  v-model="cname" style="width:30%"/></td>
</tr>
<tr>
<th>이메일</th>
<td><input data-msg="이메일" type="text" name="mailid"  id="_mailid" size="20" v-model="cmailid" style="width:30%"/></td>
</tr>
<tr>
<th>고용일</th>
<td><input data-msg="고용일" type="date" name="start_date"  id="_start_date" size="30" v-model="cstart_date" style="width:30%"/></td>
</tr>
<tr>
<tr>
<th>관리자</th>
<td>
 <select name='manager_id' v-model="cmanager_id" style="width:30%">
  <option v-for="emp in info" v-bind:value="emp.id"  :key="emp.id">
   {{ emp.id }}:{{ emp.name }}
  </option>
</select>
</td>
</tr>
<tr>
<th>직책</th>
<td>
 <select name='title' v-model="ctitle" style="width:30%">
  <option v-for="emp in titls" v-bind:value="emp.title" :key="emp.title">
   {{ emp.title }}
  </option>
</select>
</td>
</tr>
<tr>
<th>부서</th>
<td>
 <select name='dept_id' v-model="cdept_id" style="width:30%">
  <option v-for="dept in deps" v-bind:value="dept.dept_id" :key="dept.dept_id">
  {{ dept.dept_id  }}: {{ dept.name }}
  </option>
</select>
</td>
</tr>
<tr>
<th>월급</th>
<td><input data-msg="월급" type="number" name="salary"  id="_salary" size="30" min="0" v-model="csalary" style="width:30%"/></td>
</tr>
<tr>
<th>커미션</th>
<td><input data-msg="커미션" type="number" name="commission_pct"  id="_commission_pct" size="30" min="0" v-model="ccommission_pct" style="width:30%"/></td>
</tr>
<tr>
<td colspan="2" style="height:50px; text-align:center;">
<button type="submit" name="button">사원추가</button></td>
</tr>
</table>
</form>
</div>

<div v-else>
      <h4>성공적으로 입사처리를 완료하였습니다!</h4>
      <button class="btn btn-success" v-on:click="newCustomer">새로 사원 추가하기</button>
    </div>
</div>

</template>

<script>
import http from "../http-common";

export default { //무조건 뷰 객체
	name: "add-customer",
	data() {
		return {
			info: null,
			loading: true,
			errored: false,
			deps:null,
			titls:null,
			ccommission_pct:0,
			cdept_id:0,
			cmailid:'',
			cmanager_id:0,
			cname:'',
			csalary:0,
			cstart_date:'',
			ctitle:'',
			submitted: false
		};
	},
	filters: {
		salarydecimal (value) {
			var a=parseInt(value);
			return a.toFixed(2);
		}
	},
	mounted () {
	http
		.get('/findAllEmployees')
		.then(response => (this.info = response.data)) //성공 시 데이터를 인포에 넣어줌 function(response)
		.catch(() => {
			this.errored = true
		})
		.finally(() => this.loading = false);
	http
		.get('/findAllDepartments')
		.then(response => (this.deps = response.data))
		.catch(() => {
			this.errored = true
		})
		.finally(() => this.loading = false);
	http
		.get('/findAllTitles')
		.then(response => (this.titls = response.data))
		.catch(() => {
			this.errored = true
		})
		.finally(() => this.loading = false);
	},
	methods: {
	addEmployee() {
		if(this.cname==''){ alert('아이디를 입력하세요.'); return ;}
		if(this.cdept_id==''){ alert('부서를 선택하세요.'); return ;}
		if(this.cmailid==''){ alert('이메일을 선택하세요.'); return ;}
		if(this.cmanager_id==''){ alert('관리자를 선택하세요.'); return ;}
		if(this.csalary==''){ alert('월급을 입력하세요.'); return ;}
		if(this.cstart_date==''){ alert('입사일을 선택하세요.'); return ;}
		if(this.ctitle==''){ alert('직책을 선택하세요.'); return ;}

		http.post('/addEmployee', {
			commission_pct: this.ccommission_pct,
			dept_id: this.cdept_id,
			mailid: this.cmailid,
			manager_id: this.cmanager_id,
			name: this.cname,
			salary: this.csalary,
			start_date:this.cstart_date,
			title: this.ctitle
		}
		).then(response => {
				if (response.data.state=='succ') {
					alert("입사처리를 하였습니다.");
				}else{
					alert("입사처리를 하지 못했습니다.");
				}
		});
		this.submitted = true;
	},
	newCustomer() {
		this.submitted=false,
		this.info=null,
		this.loading=true,
		this.errored=false,
		this.deps=null,
		this.titls=null,
		this.ccommission_pct=0,
		this.cdept_id=0,
		this.cmailid='',
		this.cmanager_id=0,
		this.cname='',
		this.csalary=0,
		this.cstart_date='',
		this.ctitle=''
	}
  }
}
</script>

<style>
.submitform {
  max-width: 300px;
  margin: auto;
}
</style>
