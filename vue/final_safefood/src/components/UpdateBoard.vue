<template>
<div v-if="!submitted">

<form action="" method="post" id="_frmForm" name="frmForm" @submit.prevent="updateBoard">
    <center>
<table class="table_width">
<!-- <colgroup>
		<col style="width:30%;" />
		<col style="width:70%;" />
</colgroup> -->
<tr>
<th>제목</th>
<td><input data-msg="제목" type="text" name="title" id="title"  v-model="board.title" style="width:100%"/></td>
</tr>
<tr>
<th>내용</th>
<td><input class ="content_size" data-msg="내용" type="text" name="content"  id="content" size="20" v-model="board.content" style="width:100%"/></td>
</tr>
<tr>
<td colspan="2" style="height:50px; text-align:center;">
<button type="submit" name="button">Board 수정</button></td>
</tr>
</table>
</center>
</form>
</div>

</template>

<script>
import http from "../http-common";

export default {
  name: "update_board",
  props: ["num"],
  data() {
    return {
      info: [],
      loading: true,
      errored: false,
      title:'',
			content:'',
      id:'',
      board: {}
    };
  },
  filters: {
    salarydecimal(value) {
      var a = parseInt(value);
      return a.toFixed(2);
    }
  },
  methods: {
    updateBoard: function() {
        alert("수정합니다.");
         http
        .post('/updateBoard',{
          num: this.board.num,
			title: this.board.title,
			content: this.board.content,
			id: localStorage.getItem("saveid")

        })
        .then(() =>this.$router.push("/boardList"))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    show_init: function() {
      http
        .get("/boarddetail/" + this.num)
        .then(response => (this.board = response.data))
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
