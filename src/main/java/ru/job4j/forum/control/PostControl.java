package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Class-controller provides the views of post create/read/update pages.
 *
 * @author AndrewMs
 * @version 1.0
 */
@Controller
public class PostControl {
    private final PostService posts;

    public PostControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "post/create";
    }

    @GetMapping("/read")
    public String read(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", posts.findById(id));
        return "post/post";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        posts.save(post);
        return "redirect:/index";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        Post post = posts.findById(id);
        model.addAttribute("post", post);
        return "post/update";
    }
}
