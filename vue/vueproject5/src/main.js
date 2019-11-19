import Vue from "vue";
import App from "./App.vue";
import router from './router'
import './plugins/element.js'
import Vuex from 'vuex'
import store from './store/index'

Vue.use(Vuex)

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
