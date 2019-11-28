<template>

<div v-if="!submitted">
<form action="" method="post" id="_frmForm" name="frmForm" @submit.prevent="addQna">
	<center>
<table class="table_width">
<tr>
<th>제목</th>
<td><input data-msg="제목" type="text" name="title" id="title"  v-model="title" style="width:100%"/></td>
</tr>
<tr>
<th>내용</th>
<td><textarea data-msg="내용" type="text" name="content"  id="content" size="20" v-model="content" style="width:100%"/></td>
</tr>
<tr>
<td colspan="2" style="height:50px; text-align:center;">
<button type="submit" name="button">Board 추가</button></td>
</tr>
</table>
</center>
</form>
</div>

</template>

<script>
import http from "../http-common";

export default {
	name: "add-board",
	data() {
		return {
			info: null,
			loading: true,
			errored: false,
			title:'',
			content:'',
			id:'',
			submitted: false
		};
	},
	mounted () {
	},
	methods: {
	addQna() {
		if(this.title==''){ alert('제목을 입력하세요.'); return ;}
		if(this.content==''){ alert('내용을 입력하세요.'); return ;}

		http.post('/insertBoard', {
			title: this.title,
			id : localStorage.getItem("saveid"),
			content : this.content
		}
		).then(() => {
			alert("등록 처리를 하였습니다.");
			this.$router.push("/boardList");
		});
		this.submitted = true;
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
