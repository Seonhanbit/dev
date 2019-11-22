import Vue from "vue";
import Router from "vue-router";
import QnaList from "./components/QnaList.vue";
import DetailQna from "./components/DetailQna.vue";
import AddQna from "./components/AddQna.vue";
import UpdateQna from "./components/UpdateQna.vue";
import ProductInfo from "./components/ProductInfo.vue";
import Pdetail from "./components/Pdetail.vue";
import Main from "./components/Main.vue";
import BoardList from "./components/BoardList.vue";
import DetailBoard from "./components/DetailBoard.vue";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "Main",
      component: Main
    },
    {
      path: "/boardList",
      name: "BoardList",
      component: BoardList
    },
    {
      path: '/boarddetail/:num',
      name: 'DetailBoard',
      component: DetailBoard,
      props: true,
    },
    {
      path: "/qnalist",
      name: "QnaList",
      component: QnaList
    },
    {
      path: '/qnadetail/:num',
      name: 'DetailQna',
      component: DetailQna,
      props: true,
    },
    {
      path: "/add",
      name: "AddQna",
      component: AddQna
    },
    {
      path: '/updateQna/:num',
      name: 'UpdateQna',
      component: UpdateQna,
      props: true,
    },
    {
      path: '/productInfo',
      name: 'ProductInfo',
      component: ProductInfo,
      props: true,
    },
    {
      path: '/pdetail/:code',
      name: 'Pdetail',
      component: Pdetail,
      props: true,
    },
  ]
});