package com.zcx.service;

import com.zcx.po.User;

/**
 * @Author：卿抒z
 * @Package：com.zcx.service
 * @Project：blog
 * @name：UserService
 * @Date：2023/2/26 20:38
 * @Filename：UserService
 */
public interface UserService {
    User checkUser(String username, String password);
}
