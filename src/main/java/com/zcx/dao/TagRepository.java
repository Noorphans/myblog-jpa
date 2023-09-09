package com.zcx.dao;

import com.zcx.po.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author：卿抒z
 * @Package：com.zcx.dao
 * @Project：blog
 * @name：TagRepository
 * @Date：2023/3/4 10:32
 * @Filename：TagRepository
 */
public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);

    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}
