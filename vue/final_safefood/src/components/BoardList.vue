<template>
  <div>

    <br>

    <div>
      <center>

      <div class="table_width" @click="add_board()" >
        <button class = "btn1" style="width:100px">
       공지등록
       </button>
       </div>
     <br>

      <table class="table_width">
        <colgroup>
		<col style="width:20%;" />
		<col style="width:80%;" />
</colgroup>
        <tr>
          <th>번호</th>
          <th>제목</th>
        </tr>
        <tr v-for="board in boardlist" class="nicecolor" :key="board.num">
          <td v-html="board.num" ></td>
          <td v-html="board.title" @click="show_detail(board.num)"></td>
        </tr>
      </table>
      </center>
    </div>
  </div>
</template>

<script>
//리스트 받기
import http from "../http-common";

export default {
  name: "foodlist",
  data() {
    return {
      upHere: false,
      boardlist: [],
      loading: true,
      errored: false
    };
  },
  filters:{
    imgfilter:function(path){
      // var ss="../assets/"+path;
      return "../assets/"+path;
    }
  },
  methods: {
    add_board(){
      this.$router.push("/addBoard");
    },
    boardList() {
      http
        .get("/boardList")
        .then(response => (this.boardlist = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    refreshList() {
      this.boardList();
    },
    show_detail: function(num) {
      alert(num + "상세보기");
      this.$router.push("/boarddetail/" + num);
    }
  },
  mounted() {
    this.boardList();
  }
};
</script>

<style>
</style>
