package com.liuw.server.service.impl;


import com.liuw.server.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuw
 * @date 2020-05-23 3:26
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Override
    public Object getUserAccessMenu() {

        List<Map<String, Object>> menus = new ArrayList<>();

        Map<String, Object> menu = new HashMap<>();
        menu.put("path", "/home");
        menu.put("component", "/home");
        menu.put("children", null);

        menus.add(menu);

        return menus;
    }
}
