<template>
  <div>
    <div>
      <table class="list_table">
        <col width="10%" />
        <col width="20%" />
        <col width="20%" />
        <col width="20%" />
        <col width="10%" />
        <col width="10%" />
        <div @click="AddQna()">
          <input type="button" class="blue" value="QnA 등록하기" />
        </div>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>삭제하기</th>
        </tr>
        <tr v-for="qna in info" class="nicecolor" :key="qna.num">
          <td v-html="qna.num" @click="show_detail(qna.num)"></td>
          <td v-html="qna.title" @click="show_detail(qna.num)"></td>
          <td v-html="qna.id"></td>
          <td class="button" @click="delete_emp(qna.num)">
           <input type="button" class="blue" value="삭제" />
         </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
//리스트 받기
import http from "../http-common";

export default {
  name: "qnalist",
  data() {
    return {
      upHere: false,
      info: [],
      loading: true,
      errored: false
    };
  },
  methods: {
    AddQna(){
      this.$router.push("/add");
    },
    retrieveCustomers() {
      http
        .get("/qnaList")
        .then(response => (this.info = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    refreshList() {
      this.retrieveCustomers();
    },
    show_detail: function(num) {
      alert(num + "상세보기");
      this.$router.push("/qnadetail/" + num);
    },
    delete_emp(num) {
      alert(num + " 삭제합니다.");
      http
        .delete("/deleteQna/" + num)
        .then(()=>{
          alert("삭제가 완료되었습니다.");
          this.retrieveCustomers();
        })
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    }
  },
  mounted() {
    this.retrieveCustomers();
  }
};
</script>

<style>
</style>
