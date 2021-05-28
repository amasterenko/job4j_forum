package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.forum.service.PostService;
/**
 *Class-controller provides the view of the index page.
 *
 *@author AndrewMs
 *@version 1.0
 */
@Controller
public class IndexControl {
    private final PostService posts;

    public IndexControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("posts", posts.getAll());
        model.addAttribute("user", SecurityContextHolder
                .getContext().getAuthentication().getPrincipal());
        return "index";
    }
}
