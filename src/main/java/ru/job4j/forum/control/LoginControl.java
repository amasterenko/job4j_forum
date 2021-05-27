package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

@Controller
public class LoginControl {
    private UserService users;

    public LoginControl(UserService users) {
        this.users = users;
    }

    @PostMapping("/login")
    public String loginPage(@ModelAttribute User user, Model model) {
        String errorMessage = null;
        if (!user.getPassword().equals(users.findByUsername(user.getUsername()).getPassword())) {
            errorMessage = "Username or password is not valid!";
            model.addAttribute("errorMessage", errorMessage);
            return "login";
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
}
