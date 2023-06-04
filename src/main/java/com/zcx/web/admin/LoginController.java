package com.zcx.web.admin;

import com.zcx.po.User;
import com.zcx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author：卿抒z
 * @Package：com.zcx.web.admin
 * @Project：blog
 * @name：LoginController
 * @Date：2023/2/26 21:38
 * @Filename：LoginController
 */
@Controller
@RequestMapping("admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public  String longinPage() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/index";
        } else {
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin";
        }
    }

        @GetMapping("/logout")
        public String logout(HttpSession session) {
            session.removeAttribute("user");
            return "redirect:/admin";
        }
}
