package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

@Controller
public class RegControl {
    private final UserService users;

    public RegControl(UserService users) {
        this.users = users;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user, Model model) {
        String errorMessage = null;
        if (users.findByUsername(user.getUsername()) != null) {
            errorMessage = "Username already exists!";
            model.addAttribute("errorMessage", errorMessage);
            return "reg";
        }
        users.save(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String reg(Model model) {
        return "reg";
    }
}
