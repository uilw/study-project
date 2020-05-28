import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App.vue'
import VueRouter from 'vue-router'
import router from "./router.js"

Vue.use(ElementUI)

new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
