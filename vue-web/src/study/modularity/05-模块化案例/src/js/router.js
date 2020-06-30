define(["Route","saleman/index","saleman/add"],function(Route,salemanIndex,salemanAdd) {
 const router=new Route({
        routes:[ 
            {path:"/",redirect:"/saleman"},
            {path:"/saleman",component:salemanIndex},
            {path:"/saleman/add",component:salemanAdd}
        ]
       
    });
    return router;
})