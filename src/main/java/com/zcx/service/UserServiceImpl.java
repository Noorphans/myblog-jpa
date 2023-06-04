package com.zcx.service;


import com.zcx.dao.UserRepository;
import com.zcx.po.User;
import com.zcx.service.UserService;
import com.zcx.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author：卿抒z
 * @Package：com.zcx.service
 * @Project：blog
 * @name：UserServiceImpl
 * @Date：2023/2/26 21:04
 * @Filename：UserServiceImpl
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }

}
