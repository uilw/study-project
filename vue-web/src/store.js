import Vue from "vue"
// 1、引入Vuex对象
import Vuex from "vuex"

// 2、安装插件
Vue.use(Vuex);

// 3、创建store对象
let store = new Vuex.Store({
    // 配置module{state,getter,mutation,action}
    state:{
        num:1
        // ,
        // count:0
    },
    //获取器离state很近
    getters: {
        getNum(state) {
            return state.num;
        }
    },
    // 更改也和state很近,第一个参数就是state
    mutations: {
        addNum(state) {
            state.num++;
        },
        // 接收参数的(state,data),只能传一个参数,可以传对象
        addByNum(state,num) {
            state.num += num;
        },
        // mutations对state的操作只能是同步,如果出现异步
        addByNumAsync(state,num) {
            setTimeout(() => {
                state.num += num;
            }, 0);
        }    
    },
    actions: {
        // 如果传store,则有store.getters||commit||state,data
        // 如果只用commit,可以用es6解构赋值
        addByNumAction({commit},data) {
            setTimeout(() => {
                commit("addByNum",data);
            }, 0);
        }
    }
})

// 4、向外暴露一个对象
export default store;