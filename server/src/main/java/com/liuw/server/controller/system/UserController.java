package com.liuw.server.controller.system;

import com.liuw.server.db.domain.User;
import com.liuw.server.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuw
 * @date 2020-05-28 23:36
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据i查询用户信息")
    @GetMapping("/id/{id}")
    public Map<String, Object> getUserById(@PathVariable("id") Long id) {

        User user = null;
        try {
            user = userService.getUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> resp = new HashMap<>(3);
        resp.put("status", 200);
        resp.put("message", "success");
        resp.put("data", user);

        return resp;
    }
}
