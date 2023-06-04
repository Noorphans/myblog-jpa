package com.zcx.service;

import com.zcx.po.Comment;

import java.util.List;

/**
 * @Author：卿抒z
 * @Package：com.zcx.service
 * @Project：blog
 * @name：CommentService
 * @Date：2023/3/7 21:44
 * @Filename：CommentService
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
