package com.zcx.dao;

import com.zcx.po.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author：卿抒z
 * @Package：com.zcx.dao
 * @Project：blog
 * @name：CommentRepository
 * @Date：2023/3/7 21:49
 * @Filename：CommentRepository
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
}
