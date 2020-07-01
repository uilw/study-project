<template>
    <div>
        <h1>user组件</h1>
        <p>此时id是{{dynamicSegment}}</p>
    </div>
</template>

<script>
export default {
    data() {
        return {
            dynamicSegment: ''
        }
    },
    // computed: {
    //     dynamicSegment() {
    //         return this.$route.params.id
    //     }
    // }
    watch: {
        $route(to, from) {
            console.log(from);
            console.log(to);
            this.dynamicSegment = to.params.id
        }
    }
}
</script>