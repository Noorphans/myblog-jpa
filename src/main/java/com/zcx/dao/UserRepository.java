package com.zcx.dao;

import com.zcx.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author：卿抒z
 * @Package：com.zcx.dao
 * @Project：blog
 * @name：UserRepository
 * @Date：2023/2/26 21:23
 * @Filename：UserRepository
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username, String password);

}
