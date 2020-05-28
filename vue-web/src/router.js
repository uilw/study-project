import Vue from 'vue'
import VUeRouter from 'vue-router'
import VueRouter from 'vue-router'
import home from "./views/home/home.vue"
import about from "./views/about.vue"
import user from "./views/user.vue"
import phone from "./views/home/phone"
import computer from "./views/home/computer"
import book from "./views/home/book"

Vue.use(VueRouter)

// const Foo = { template: '<div>foo</div>' }

const routes = [
    {
        path: "/home",
        component: home,
        children: [
        {
            path: "phone",
            component: phone
        }, 
        {
            path: "computer",
            component: computer
        },
        {
            path: "book",
            component: book
        }]
    },
    {
        path: "/about",
        component: about
    },
    {
        path: '/', 
        redirect: '/home' 
    },
    {
        path: '/user/:id',
        name: "user",
        component: user
    }
    // ,
    // {
    //     path: '/foo',
    //     component: foo
    // }
]

const router = new VueRouter({routes})

export default router;