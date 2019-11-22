<template>
  <div>
    <table class="list_table">
      <col width="10%" />
      <col width="20%" />
      <col width="20%" />
      <col width="20%" />
      <col width="10%" />
      <tr>
        <th>번호</th> <td v-html="qna.num"></td>
      </tr>
      <tr>
        <th>제목</th><td v-html="qna.title"></td>
      </tr>
      <tr>
        <th>내용</th><td v-html="qna.content"></td>
      </tr>
      <tr>
        <th>작성자 닉네임</th><td v-html="qna.id"></td>
      </tr>
       <tr>
        <td >
        </td>
        <td class="button" @click="show_detail(num)">
           <input type="button" class="blue" value="수정하기" />
        </td>
      </tr>
        <tr>
        <th>댓글 내용</th><th>댓글 닉네임</th>
      </tr>
      <tr>
        <td>
          <input type="text" v-model="content">
        </td>
        <td>
          <input type="text" v-model="id">
        </td>
        <td class="button" @click="add_comment()">
           <input type="button" class="blue" value="댓글달기" />
        </td>
      </tr>
      <tr v-for="com in comment" class="nicecolor" :key="com.num">
        <th>댓글</th><td v-html="com.content"></td>
        <td><input type="button" @click="del_comment(com.num)" class="blue" value="삭제하기"/> &nbsp;</td>
      </tr>
    </table>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "detailqna",
  props: ["num"],
  data() {
    return {
      loading: true,
      errored: false,
      qna: {},
      comment:[],
      content:'',
      id:'',
      qnanum:''
    };
  },
  filters: {
    salarydecimal(value) {
      var a = parseInt(value);
      return a.toFixed(2);
    }
  },
  methods: {
    show_detail: function(num) {
      alert(num + "수정하기");
      //아래를 수정했다.
      this.$router.push("/updateQna/" + num);
    },
    show_init: function() {
      http
        .get("/qnadetail/" + this.num)
        .then(response => (this.qna = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    show_comment: function() {
      http
        .get("/commentList/" + this.num)
        .then(response => (this.comment = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    del_comment:function(num){
      alert(num + "삭제하기");
      http
        .delete("/deleteComment/" + num)
        .then(()=>{
          alert("삭제가 완료되었습니다.");
          this.show_comment();
        })
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    add_comment:function(){
      if(this.content==''){ alert('내용을 입력하세요.'); return ;}
      if(this.com_id==''){ alert('아이디를 입력하세요.'); return ;}

		http.post('/insertComment', {
			qnanum: this.num,
			id : this.id,
			content : this.content
		}
		).then(() => {
      alert("등록 처리를 하였습니다.");
      this.show_comment();
		});
    }
  },
  mounted() {
    this.show_init();
    this.show_comment();
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