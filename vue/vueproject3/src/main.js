import Vue from "vue";
import App from "./App.vue";
import router from './router'

Vue.config.productionTip = false;

new Vue({
  router, //라우터를 쓰겠다라는 표시(위의 import)
  render: h => h(App) //랜더링 람다식
}).$mount("#app"); // index.html의 div id와 똑같음
