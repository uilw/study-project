require.config({
    baseUrl: "js"
})

require(["user/index"],function() {
    console.log("入口文件")
})