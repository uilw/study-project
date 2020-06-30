define([],function() {
    var salemanList = [
        {name: "刘芮", age:24},
        {name:"刘伟", age:25},
        {name:"刘若彤",age:20}
    ]
    return {
        getList() {
            return salemanList;
        },
        add(name, age) {
            salemanList.push({name,age})
        },
        update() {

        },
        del() {
            
        }
    }

    
})