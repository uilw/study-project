define(["jquery","service/salemanService","saleman/add"],function($,salemanService,salemanAdd) {
    return function() {
        // console.log(salemanService);
        // console.log("销售员index.js");
        var salemanList = salemanService.getList();
        // console.log(salemanList);
        var rowStr = salemanList.map(item=> {
            return `<tr><td>${item.name}</td><td>${item.age}</td></tr>`
        }).join(" ");
        var str = `<div>
                      <div>操作
                        <button class="add">添加</button>
                        <button>查询</button>
                      </div>
                      <table border="2" cellpadding="10">
                        <thead>
                          <tr>
                            <td>姓名</td>
                            <td>年龄</td>
                          </tr>
                        </thead>
                        <tbody>
                        ${salemanService.getList().map(item=>{
                            return `<tr><td>${item.name}</td><td>${item.age}</td></tr>`
                        }).join(" ")}
                        </tbody>
                      </table>
                   </div>`;
        $saleman = $(str);
        $saleman.on("click",".add",function() {
            salemanAdd();
        })
        $("#main .content").html($saleman);
    }
})