require.config({
    baseUrl:"js",
    paths:{
        jquery: "lib/jquery-3.5.1",
        service: "../service"
    }

})

require(["jquery","router"],function($,router) {
    console.log("app.js");
    $(".aside").on("click",".aside-items",function() {
        if($(this).hasClass("aside-saleman")) {
            router.push({path:"/saleman"});
        } else if($(this).hasClass("aside-car")) {
            alert("汽车模块");
        } else if($(this).hasClass("aside-shop")) {
            alert("商店模块");
        }
    })
    // 默认展示第一个菜单栏
    $(".aside .aside-items:eq(0)").trigger("click");
})