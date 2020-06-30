define(["service/salemanService"],function(salemanService) {
    return function() {
        var addStr=`<form>
                      <label>姓名</label><input name="name"/>
                      <label>年龄</label><input name="age"/>
                      <button type="submit">提交</button>
                    </form>`;
        var $add= $(addStr);
        $add.on("submit",function(event) {
            event.preventDefault();
            var name= $(this).find("input[name=name]").val();
            var age=$(this).find("input[name=age]").val();
            salemanService.add(name,age);
            $(".aside .aside-items:eq(0)").trigger("click");
        })
        $("#main .content").html($add);
    }
})