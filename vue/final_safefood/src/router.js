import Vue from "vue";
import Vuex from 'vuex';
import Router from "vue-router";
import QnaList from "./components/QnaList.vue";
import DetailQna from "./components/DetailQna.vue";
import AddQna from "./components/AddQna.vue";
import UpdateQna from "./components/UpdateQna.vue";
import ProductInfo from "./components/ProductInfo.vue";
import Pdetail from "./components/Pdetail.vue";
import Main from "./components/Main.vue";
import Mainre from "./components/Mainre.vue";
import BoardList from "./components/BoardList.vue";
import DetailBoard from "./components/DetailBoard.vue";
import AddBoard from "./components/AddBoard.vue";
import UpdateBoard from "./components/UpdateBoard.vue";
import Mypick from "./components/Mypick.vue";
import DetailUser from "./components/DetailUser.vue";
import UpdateUser from "./components/UpdateUser.vue";

Vue.use(Router);

Vue.use(Vuex);
export default new Router({
  mode: "history",
  routes: [
    {
      path:"/",
      name:"Main",
      component:Mainre
    },

    {
      path: "/main",
      name: "Main",
      component: Main
    },
    {
      path: "/mypick",
      name: "Mypick",
      component: Mypick
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
      path: "/addQna",
      name: "AddQna",
      component: AddQna
    },
    {
      path: "/addBoard",
      name: "AddBoard",
      component: AddBoard
    },
    {
      path: '/updateQna/:num',
      name: 'UpdateQna',
      component: UpdateQna,
      props: true,
    },
    {
      path: '/updateBoard/:num',
      name: 'UpdateBoard',
      component: UpdateBoard,
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
    {
      path: "/DetailUser",
      component: DetailUser
    },
    {
      path: "/UpdateUser",
      component: UpdateUser
    }
  ]
});