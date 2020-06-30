define([],function() {
    function Route(option) {
        this.routes=option.routes;
        this.init();
    }
    Route.prototype={
        constructor:Route,
        init() {
            _that=this;
            window.addEventListener("hashchange",function() {
                var hash=location.hash.substring(1);
                console.log(`hash:, ${hash}`);
                var route=_that.routes.find(item=>{
                    return item.path === hash;
                })
                if(route) {
                    route.component();
                }
            })
        },
        push({path}) {
            _that= this;
            var route=_that.routes.find(item=>{
                return item.path === path
            });
            if(route) {
                route.component();
            }

        }
    }
    return Route;
})