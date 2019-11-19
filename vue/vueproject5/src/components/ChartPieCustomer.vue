
<template>
<div>
<div>
    <tree :tree-data="tree"></tree>
    <pie :data="names" /> 
</div>
</div>
</template>
<script>
import http from "../http-common";
import Tree from "./Tree";
import Pie from "./Pie";
export default {
  name: "chartpiecustomer",
  data () {
        return {
          deptid2:0,
          depcounts: [],
          loading: true,
          errored: false ,
          info:[]
         ,
          tree: {
            deptname: "SSAFY HRM 부서",
            children: []
          },
          names:[]
        }//return
  },
  components: {
       Tree, 
       Pie
  },
  computed: {
  },
  methods: {
  },
  mounted () {
    http
      .get('/findAllDeptEmps2')
      .then(response => (this.tree.children= response.data))
      .catch(() => {
        this.errored = true
      })
      .finally(() => this.loading = false);
    http
      .get('/findAllDepCounts')
      .then(response => {this.names = response.data   
      })
      .catch(() => {
        this.errored = true
      })
      .finally(() => this.loading = false);
  }
};
</script>

<style>
.arc text {
  font: 15px sans-serif;
  text-anchor: middle;
 color: crimson;
}

.arc path {
  stroke: #fff;
}

.arc2 text {
  font: 15px sans-serif;
  text-anchor: middle;
  color: crimson;
}

.arc2 path {
  stroke: #fff;
}
.range-input {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 10px;
}
input {
  margin-left: 10px;
}
</style>