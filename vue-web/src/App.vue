<template>
  <div id="app">
    <img src="./assets/logo.png">
    <div>
      <el-button @click="startHacking">Start</el-button>
      <router-link to="/home">home</router-link>
      <router-link to="/about">about</router-link>
      <router-link :to="{name: 'user',params: {id: 111}}">user111</router-link>
      <router-link to="/user/222">user222</router-link>
      <router-link to="/foo">foo</router-link>
      <router-view></router-view>
      <el-button @click="toUser()">user</el-button>
      <div>{{getMyNum}}</div>
      <el-button @click="add">添加数量</el-button>
      <!-- <el-button>{{count}}</el-button> -->
      <!-- <el-button>{{numAlias}}</el-button> -->
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex"
export default {
  methods: {
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
      console.log("添加数量");
      this.$store.commit("addNum");
      console.log(this.$store.getters.getNum);
    }
  },
  computed: {
    getMyNum() {
      return this.$store.getters.getNum;
    }
  }
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
