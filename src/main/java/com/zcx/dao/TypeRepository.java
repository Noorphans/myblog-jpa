package com.zcx.dao;

import com.zcx.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author：卿抒z
 * @Package：com.zcx.dao
 * @Project：blog
 * @name：TypeRepository
 * @Date：2023/2/27 11:39
 * @Filename：TypeRepository
 */
public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);

    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
