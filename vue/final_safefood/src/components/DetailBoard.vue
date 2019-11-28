<template>
  <div>
    <center>
    <table class="table_width">
      <col width="10%" />
      <col width="80%" />
      <col width="10%" />
      <tr>
        <th>번호</th> <td v-html="board.num"></td>
      </tr>
      <tr>
        <th>제목</th><td v-html="board.title"></td>
      </tr>
      <tr>
        <th>내용</th><td class="content_size" v-html="board.content"></td>
      </tr>
      <tr>
        <th>작성자 닉네임</th><td v-html="board.id"></td>
      </tr>
       <tr style="background-color:white">
        <td style="background-color:white">
        </td>
        <td class="button" style="background-color:white">
           <input type="button" class="blue" value="수정하기" @click="update_board()"/> &nbsp; &nbsp; &nbsp;
          <input type="button" class="blue" value="삭제하기" @click="delete_board(board.num)" />
        </td>
      </tr>
    </table>
    </center>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "detailboard",
  props: ["num"],
  data() {
    return {
      loading: true,
      errored: false,
      board: {},
      content:'',
      id:''
    };
  },
  methods: {
    update_board: function() {
      alert("수정하기");
      //아래를 수정했다.
      this.$router.push("/updateBoard/"+this.num);
    },
    delete_board:function(num){
       http
        .delete("/deleteBoard/" + num)
        .then(()=>{
          alert("삭제가 완료되었습니다.");
            this.$router.push("/boardList");
        })
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