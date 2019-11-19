<template>
  <div>
    <div>
      <table class="list_table">
        <col width="10%" />
        <col width="20%" />
        <col width="20%" />
        <col width="20%" />
        <col width="10%" />
        <tr>
          <th>사원 아이디</th>
          <th>사원명</th>
          <th>부서</th>
          <th>직책</th>
          <th>연봉</th>
        </tr>
        <tr>
          <td v-html="cempt.id"></td>
          <td v-html="cempt.name"></td>
          <td v-html="cempt.dept_id"></td>
          <td v-html="cempt.title"></td>
          <td>{{ cempt.salary | salarydecimal }}</td>
        </tr>
      </table>
    </div>
    <div class="tree">
      <ul class="tree-list">
        <node-tree :node="treeData"></node-tree>
      </ul>
    </div>
  </div>
</template>

<script>
import Vue from "vue";
import NodeTree from "./NodeTree";
import http from "../http-common";
Vue.prototype.$EventBus = new Vue();
export default {
  data() {
    return {
      cempt: { salary: 0 }
    };
  },
  props: {
    treeData: {}
  },
  components: {
    NodeTree
  },
  filters: {
    salarydecimal(value) {
      var a = parseInt(value);
      return a.toFixed(2);
    }
  },
  /*
  watch:{
    cempt (cempt){
      console.log(cempt.id+"changed -------!!");
      //alert(cempt.id+"를 선택하였습니다.");
    }
  },*/
  watch: {
    //cempt(value, oldValue) {
      //console.log(oldValue.id) // Hello World
      //console.log(value.id) // ByeBye World
    //}
  },
  mounted() {
    this.$EventBus.$on("showCustomer", val => {
      var index = val.indexOf("|");
      if (index != -1) {
        var ids = val.substr(0, index).trim();
        http
          .get("/findEmployeeById/" + ids)
          .then(response => {
            this.cempt = response.data;
            //alert(ids+"상세보기");
          })
          .catch(() => {
            this.errored = true;
          })
          .finally(() => (this.loading = false));
      } else {
        //var idx=val.indexOf("(");
        //console.log('received event, value is 3-------- ', val);
        //console.log('received event, value is 4-------- ', val.substr(0,idx).trim());
      }
    });
  }
};
</script>

<style>
.tree-list ul {
  padding-left: 15px;
  margin: 5px 0px;
}
</style>