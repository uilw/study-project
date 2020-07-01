<template>
  <div id="app">
    <img src="assets/logo.png">
    <div>
      <el-button @click="startHacking">Start</el-button>
      <router-link to="/home">home</router-link>
      <router-link to="/about">about</router-link>
      <router-link :to="{name: 'user',params: {id: 111}}">user111</router-link>
      <router-link to="/user/222">user222</router-link>
      <router-link to="/foo">foo</router-link>
      <router-view></router-view>
      <el-button @click="toUser()">user</el-button>

      <!-- 可以用,但是不建议 -->
      <!-- 可以用$store直接访问，因为main.js的vue实例中注入了store -->
      <div>{{$store.state.num}}</div>
      <div>{{$store.getters.getNum}}</div>
      <!-- 哈哈哈,原来num为1时,显示为"1个",是因为谷歌浏览器翻译成中文导致的 -->

      <!-- getters结合computed,直接用方法名访问 -->
      <div>{{getMyNum}}</div>

      <!-- 更改 -->
      <el-button @click="add">添加数量</el-button>
      <el-button @click="addByNum">添加一定数量</el-button>
      <el-button @click="addByNumAsync">异步添加一定数量</el-button>
      <el-button @click="addByNumAsync">正确异步添加一定数量</el-button>
      <el-button @click="isType">判断类型</el-button>

      <div>{{getMyNum}}</div>
      <!-- <el-button>{{count}}</el-button> -->
      <!-- <el-button>{{numAlias}}</el-button> -->
    </div>
  </div>
</template>

<script>
// mapState需要import
import { mapState } from "vuex"

export default {
  methods: {
    isType() {
      console.log(typeof(null))
    },
    startHacking () {
      this.$notify({
        title: 'It works!',
        type: 'success',
        message: 'We\'ve laid the ground work for you. It\'s time for you to build something epic!',
        duration: 5000
      })
    },
    toUser() {
      this.$router.push("/user/234");
    },
    add() {
      // 不建议直接这么搞
      // 谷歌浏览器视图不更新,火狐可以
      this.$store.commit("addNum");
    },
    addByNum() {
      // 不建议直接这么搞
      this.$store.commit("addByNum",10);
    },
    addByNumAsync() {
      // 不建议直接这么搞
      // 页面显示是对的,但是vue-devtools看,每次总少一步记录
      // 只能是同步,否则丢失记录
      console.log(`错误异步添加前${this.getMyNum}`);
      // this.$store.commit("addByNumAsync",20);
      console.log(`错误异步添加后${this.getMyNum}`);
      this.$store.dispatch("addByNumAction",30);
    }
  },
  // getters结合omputed使用,监视属性更改,从而得到一个通知
  computed: {
    getMyNum() {
      return this.$store.getters.getNum;
    }
  }
  // 函数接收一个数组,返回一个对象,字符串就是getters中的key,...负责将一个对象变为多个key和value
  // computed: (
  //   ...mapGetters(["getNum"])
  // )
  // computed: mapState({
  //   count:state=> state.count,
  //   numAlias:'num'

  // })
}
</script>

<style>
#app {
  font-family: Helvetica, sans-serif;
  text-align: center;
}
.router-link-active {
   color: red;
}
</style>
