package com.zcx.web;

import com.zcx.po.Blog;
import com.zcx.po.Comment;
import com.zcx.po.User;
import com.zcx.service.BlogService;
import com.zcx.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author：卿抒z
 * @Package：com.zcx.web
 * @Project：blog
 * @name：CommentController
 * @Date：2023/3/7 21:34
 * @Filename：CommentController
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        model.addAttribute("comments", commentService.listCommentByBlogId(blogId));
        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session) {
        Long blogId = comment.getBlog().getId();
        comment.setBlog(blogService.getBlog(blogId));
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
            comment.setAvatar(avatar);
        }
        commentService.saveComment(comment);
        return "redirect:/comments/" + blogId;
    }

    //删除评论
    @GetMapping("/comment/{blogId}/{id}/delete")
    public String delete(@PathVariable Long blogId,
                         @PathVariable Long id,
                         Comment comment,
                         HttpSession session,
                         Model model,
                         RedirectAttributes attributes){
        User user = (User) session.getAttribute("user");
        Blog andConvert = blogService.getAndConvert(blogId);
        List<Comment> comments = commentService.listCommentByBlogId(blogId);

//        List<Long> parentId = commentService.getParentId(id);
//        if (ObjectUtils.isEmpty(parentId)) {
//            attributes.addFlashAttribute("message", "该评论存在子评论,无法删除");
//            model.addAttribute("blog", andConvert);
//            model.addAttribute("comments", comments);
//            return "blog";
//        }
        if(user != null) {
            commentService.deleteComment(comment,id);
        }
        model.addAttribute("blog", andConvert);
        model.addAttribute("comments", comments);
        return "blog";
    }
}
