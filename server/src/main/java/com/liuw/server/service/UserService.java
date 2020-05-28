package com.liuw.server.service;

import com.liuw.server.db.domain.User;

/**
 * @author liuw
 * @date 2020-05-28 23:37
 */
public interface UserService {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    User getUserById(Long id);

}
