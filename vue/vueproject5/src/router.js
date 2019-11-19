import Vue from "vue";
import Router from "vue-router";
import CustomersList from "./components/CustomersList.vue";
import SearchCustomers from "./components/SearchCustomers.vue";
import SearchCustomersById from "./components/SearchCustomersById.vue";
import ChartCustomer from "./components/ChartCustomer.vue";
import AddCustomer from "./components/AddCustomer.vue";
import DetailCustomer from "./components/DetailCustomer.vue";
import UpdateCustomer from "./components/UpdateCustomer.vue";
//import Login from "./components/Login.vue";
//import CustomerRegistry from "./components/CustomerRegistry.vue";
import ChartPieCustomer from "./components/ChartPieCustomer.vue";

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
      path: "/search",
      name: "search",
      component: SearchCustomers
    },
    {
      path: "/searchbyid",
      name: "searchbyid",
      component: SearchCustomersById
    }
    ,
    {
      path: "/chartcustomer",
      name: "chartcustomer",
      component: ChartCustomer
    } ,
    {
      path: "/add",
      name: "add",
      component: AddCustomer
    }
    ,
    {
      path: '/detailcustomer/:id',
      name: 'detailcustomer',
      component: DetailCustomer,
      props: true,
    }
    ,
    {
      path: '/updatecustomer/:id',
      name: 'updatecustomer',
      component: UpdateCustomer,
      props: true,
    }
    ,
    {
      path: '/chartpiecustomer',
      name: 'chartpiecustomer',
      component: ChartPieCustomer
    }
    
  ]
});