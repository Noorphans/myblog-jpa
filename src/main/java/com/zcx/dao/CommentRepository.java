package com.zcx.dao;

import com.zcx.po.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

//    @Query("SELECT t.id FROM t_comment t WHERE t.id IN ( SELECT c.parent_comment_id FROM t_comment c) AND t.id = ?1")
//    List<Long> getParentId(Long id);
}
