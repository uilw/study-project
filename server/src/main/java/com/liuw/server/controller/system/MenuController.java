package com.liuw.server.controller.system;

import com.liuw.server.db.domain.User;
import com.liuw.server.service.MenuService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuw
 * @date 2020-05-29 0:11
 */
@RestController
@Slf4j
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "根据用户信息查询用户权限菜单")
    @GetMapping("/access")
    public Map<String, Object> getUserAccessMenu() {
        Map<String, Object> resp = new HashMap<>(3);

        Object object = menuService.getUserAccessMenu();

        resp.put("status", 200);
        resp.put("message", "success");
        resp.put("data", object);

        return resp;
    }
}
