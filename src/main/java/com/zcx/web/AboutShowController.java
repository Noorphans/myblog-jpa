package com.zcx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author：卿抒z
 * @Package：com.zcx.web
 * @Project：blog
 * @name：AboutShowController
 * @Date：2023/3/10 15:58
 * @Filename：AboutShowController
 */
@Controller
public class AboutShowController {

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
