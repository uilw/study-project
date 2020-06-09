import Vue from "vue"
import Vuex from "vuex"

Vue.use(Vuex);

let store = new Vuex.Store({
    state:{
        num:0,
        count:0
    },
    getters: {
        getNum(state) {
            return state.num;
        }
    },
    mutations: {
        addNum(state) {
            return state.num++;
        }
    }
})

export default store;