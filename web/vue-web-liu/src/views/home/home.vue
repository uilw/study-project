<template>
    <div>
        <h1>home</h1>
        <p>
            <router-link to="/home/phone">phone</router-link>
            <router-link to="/home/computer">computer</router-link>
            <router-link to="/home/book">book</router-link>
        </p>
        <router-view></router-view>
    </div>
</template>
<script>
export default {
    data() {
        return {
            msg: "我是home组件"
        }
    }
}
</script>