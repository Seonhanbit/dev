import Vue from "vue";
import Router from "vue-router";
import CustomersList from "./components/CustomersList.vue";
import DetailCustomer from "./components/DetailCustomer.vue";
import SearchCustomers from "./components/SearchCustomers.vue";
import SearchCustomersById from "./components/SearchCustomersById.vue";
import AddCustomer from "./components/AddCustomer.vue";
import ChartCustomer from "./components/ChartCustomer.vue";
import UpdateCustomer from "./components/UpdateCustomer.vue";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "customers",
      alias: "/customer",
      component: CustomersList
    },
    {
      path: '/detailcustomer/:id',
      name: 'detailcustomer',
      component: DetailCustomer,
      props: true,
    },
    {
      path: "/search",
      name: "search",
      component: SearchCustomers
    },
    {
      path: "/searchbyid",
      name: "searchbyid",
      component: SearchCustomersById
    },
    {
      path: "/add",
      name: "add",
      component: AddCustomer
    } ,
    {
      path: "/chartcustomer",
      name: "chartcustomer",
      component: ChartCustomer
    } 
    ,
    {
      path: '/updatecustomer/:id',
      name: 'updatecustomer',
      component: UpdateCustomer,
      props: true,
    }
  ]
});