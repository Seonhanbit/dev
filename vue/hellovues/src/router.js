import Vue from "vue";
import Router from "vue-router";
import CustomersList from "./components/CustomersList.vue";
Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "customers",
      alias: "/customer",
      component: CustomersList
    }
  ]
});