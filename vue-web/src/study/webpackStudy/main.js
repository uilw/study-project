import App from "./app.js";
import Vue from "vue"
console.log(Vue);

new Vue({
    el: "#app",
    compontents: {
        App
    },
    template:`<app />`
});