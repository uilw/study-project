define(["jquery","require","service/noteService",'router'],function($,require,noteService){
    return function(){
        var noteHTML=`
            <div>
                <div>销售单据列表</div>
                <p>
                    <button class="add">新增</button>
                    <button class="toPerson">去往销售员页面</button>
                </p>
                <table cellpadding="30" border="3" bordercolor="red">
                    <tr>
                        <td>车型</td>
                        <td>价格</td>
                        <td>操作</td>
                    </tr>
                    ${noteService.getList().map(item=>{
                        return `
                        <tr>
                            <td>${item.type}</td>
                            <td>${item.price}</td>
                            <td><button>编辑</button></td>
                        </tr>
                        `
                    })}
                </table>
            </div>
        `
        var $note=$(noteHTML)
        
        $note.on("click",".add",function(){
            require("router").push({path:"/note/add"})
        }).on("click",".toPerson",function(){
            require("router").push({path:"/person"})
        })
        $(".tab-content").html($note);
    }
})