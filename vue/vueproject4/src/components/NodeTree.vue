<template>
  <li class="node-tree">
    <span class="label" @mouseover="showLog(node.deptname)">{{ node.deptname }}</span>
    <ul v-if="node.children && node.children.length">
      <!--  node.children.length ==0이면 false-->
      <node v-for="child in node.children" :node="child" v-bind:key="child.deptname"></node>
    </ul>
  </li>
</template>
<script>
import Vue from "vue";
Vue.prototype.$EventBus = new Vue();
export default {
  name: "node",
  props: {
    node: {} //여기서 Tree.vue에서 받은 값
  },
  methods: {
    showLog: function(aaa) {
      this.$EventBus.$emit("showCustomer", aaa); //aaa는 현재 마우스가 올라가있는 글자 -> node.deptname
    }
  }
};
</script>
<style>
.node-tree ul {
  list-style-type: disc;
}
.node-tree ul li {
  list-style-type: circle;
}
.node-tree ul ul {
  list-style-type: square;
}
</style>