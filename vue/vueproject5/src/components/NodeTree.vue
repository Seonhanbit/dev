<template>
  <li class="node-tree">
    <span class="label" @mouseover="showLog(node.deptname)">{{ node.deptname }}</span>
    <ul v-if="node.children && node.children.length">
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
    node: {}
  },
  methods: {
    showLog: function(aaa) {
      this.$EventBus.$emit("showCustomer", aaa);
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