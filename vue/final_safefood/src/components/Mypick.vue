<template>
<center>
  <div class="table_width">
<br>
    <div>
     <h4 style="font-family:italic"> 회원님의 예상 섭취 칼로리는 {{calo}} 입니다.</h4>
      <h5 v-if="upHere">(경고) 회원님은 일일섭취 칼로리를 초과하였습니다!</h5>
    </div>

    <div>
       회원님의 예상 배송일은 ?
      <input type="text" v-model="posx" placeholder="사는곳의 X좌표">
      <input type="text" v-model="posy" placeholder="사는곳의 Y좌표">
      <input type="button" class="blue btn1" style="width:50px" @click="search_date()" value="조회"/>
      <h5 v-if="delivery">지금 즉시 주문하면 {{date }} 일 후 배송완료 예정!</h5>
    </div>

  <br>

    <div>
      <table class="list_table">
        <col width="10%" />
        <col width="20%" />
        <col width="10%" />
        <col width="20%" />
        <col width="10%" />
        <tr>
          <th>상품 이미지</th>
          <th>상품명</th>
          <th>수량</th>
          <th>알러지 포함 여부</th>
          <th>삭제</th>
        </tr>
        <tr v-for=" pick  in mypicklist" class="nicecolor" :key="pick.image">


          <td class="table_tt" @click="show_detail(pick.code)" style="background-color:white">
            <img :src="pick.image" width="150px">
          </td>
          <td v-if="pick.include" class="table_tt" v-html="pick.name"></td>
          <td v-if="pick.include" class="table_tt" v-html="pick.amount"></td>
          <td v-if="!pick.include"  v-html="pick.name"></td>
          <td v-if="!pick.include"  v-html="pick.amount"></td>

            <td v-if="pick.include" class="table_tt">
                알러지가 포함되었습니다.
            <td v-if="!pick.include">
                알러지 위험 없음

        </td>
        <td v-if="pick.include" class="table_tt button" @click="delete_cart(pick.code)">
            <input type="button" class="blue btn1" style="width:50px" value="삭제"/>
        </td>
        <td v-if="!pick.include" class="button" @click="delete_cart(pick.code)">
            <input type="button" class="blue btn1" style="width:50px" value="삭제"/>
        </td>


    </tr>
      </table>
    </div>
  </div>
  </center>
</template>

<script>
//리스트 받기
import http from "../http-common";

export default {
  name: "mypick",
  data() {
    return {
      upHere: false,
      delivery: false,
      mypicklist: [],
      loading: true,
      errored: false,
      calo:'',
      date:'',
      posx:'',
      posy:''
    };
  },
  methods: {
    cartinfo() {
      http
        .get("/cartList/"+localStorage.getItem("saveid"))
        .then(response => (this.mypicklist = response.data))
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    refreshList() {
      this.cartinfo();
    },
    show_detail: function(code) {
      alert(code + "상세보기");
      this.$router.push("/pdetail/" + code);
    },
    delete_cart(code) {
      alert(code + " 삭제합니다.");
      http
        .delete("/deleteCart/" + code+"/"+localStorage.getItem("saveid"))
        .then(()=>{
          alert("삭제가 완료되었습니다.");
          this.cartinfo();
        })
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    max_calo(){
       http
        .get("/maxCalo/"+localStorage.getItem("saveid"))
        .then(response => {(this.calo = response.data);
          if(this.calo>2500){
              this.upHere=true;
          }
        })
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    },
    search_date(){
        http
        .get("/date/"+this.posx+"/"+this.posy)
        .then(response => {(this.date = response.data);
          this.delivery=true;
        })
        .catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
    }
  },
  mounted() {
    this.cartinfo();
    this.max_calo();
  }
};
</script>

<style>
</style>