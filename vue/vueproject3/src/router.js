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
  routes: [ //배열로 여러개의 라우터를 담고 있음
    {
      path: "/", //path는 to랑 연결
      name: "customers", //별명같은 이름
      alias: "/customer",
      component: CustomersList //import하는 연결 이름
    },
    {
      path: '/detailcustomer/:id', //뒤에 인자를 같이 보내줄때
      name: 'detailcustomer',
      component: DetailCustomer,
      props: true, //부모에서 자식으로 인자를 보낼때 props를 true해주기
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