<template>

<div v-if="!submitted">
<form action="" method="post" id="_frmForm" name="frmForm" @submit.prevent="addQna">
<table class="content_table">
<colgroup>
		<col style="width:30%;" />
		<col style="width:70%;" />
</colgroup>
<tr>
<th>제목</th>
<td><input data-msg="제목" type="text" name="title" id="title"  v-model="title" style="width:30%"/></td>
</tr>
<tr>
<th>내용</th>
<td><input data-msg="내용" type="text" name="content"  id="content" size="20" v-model="content" style="width:30%"/></td>
</tr>
<tr>
<th>작성자 닉네임</th>
<td><input data-msg="작성자 닉네임" type="text" name="id"  id="id" size="30" v-model="id" style="width:30%"/></td>
</tr>

<tr>
<td colspan="2" style="height:50px; text-align:center;">
<button type="submit" name="button">QnA 추가</button></td>
</tr>
</table>
</form>
</div>

</template>

<script>
import http from "../http-common";

export default {
	name: "add-qna",
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
	filters: {
		salarydecimal (value) {
			var a=parseInt(value);
			return a.toFixed(2);
		}
	},
	mounted () {
	},
	methods: {
	addQna() {
		if(this.title==''){ alert('제목을 입력하세요.'); return ;}
		if(this.id==''){ alert('아이디를 입력하세요.'); return ;}
		if(this.content==''){ alert('내용을 입력하세요.'); return ;}

		http.post('/insertQna', {
			title: this.title,
			id : this.id,
			content : this.content
		}
		).then(() => {
			alert("등록 처리를 하였습니다.");
			this.$router.push("/");
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
