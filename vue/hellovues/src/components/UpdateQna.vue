<template>
<div v-if="!submitted">
<form action="" method="post" id="_frmForm" name="frmForm" @submit.prevent="updateQna">
<table class="content_table">
<colgroup>
		<col style="width:30%;" />
		<col style="width:70%;" />
</colgroup>
<tr>
<th>제목</th>
<td><input data-msg="제목" type="text" name="title" id="title"  v-model="qna.title" style="width:30%"/></td>
</tr>
<tr>
<th>내용</th>
<td><input data-msg="내용" type="text" name="content"  id="content" size="20" v-model="qna.content" style="width:30%"/></td>
</tr>
<tr>
<th>작성자 닉네임</th>
<td><input data-msg="작성자 닉네임" type="text" name="id"  id="id" size="30" v-model="qna.id" style="width:30%"/></td>
</tr>

<tr>
<td colspan="2" style="height:50px; text-align:center;">
<button type="submit" name="button">QnA 수정</button></td>
</tr>
</table>
</form>
</div>

</template>

<script>
import http from "../http-common";

export default {
  name: "detailqna",
  props: ["num"],
  data() {
    return {
      info: [],
      loading: true,
      errored: false,
      title:'',
			content:'',
      id:'',
      qna: {}
    };
  },
  filters: {
    salarydecimal(value) {
      var a = parseInt(value);
      return a.toFixed(2);
    }
  },
  methods: {
    updateQna: function() {
        alert("수정합니다.");
         http
        .post('/updateQna',{
          num: this.qna.num,
			title: this.qna.title,
			content: this.qna.content,
			id: this.qna.id

        })
        .then(() =>this.$router.push("/"))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    show_init: function() {
      http
        .get("/qnadetail/" + this.num)
        .then(response => (this.qna = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    }
  },
  mounted() {
    this.show_init();
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
