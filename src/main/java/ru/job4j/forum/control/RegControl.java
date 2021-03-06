package ru.job4j.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;
/**
 * Class-controller provides the views of user registration page
 * and handles POST-requests for user registration.
 *
 * @author AndrewMs
 * @version 1.0
 */
@Controller
public class RegControl {
    private final UserService users;
    private final PasswordEncoder encoder;

    public RegControl(UserService users, PasswordEncoder encoder) {
        this.users = users;
        this.encoder = encoder;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user, Model model) {
        String message;
        if (users.findByUsername(user.getUsername()) != null) {
            message = "Username already exists!";
            model.addAttribute("message", message);
            return "reg";
        }
        message = "Registration is completed. Please, go to the login page.";
        model.addAttribute("message", message);
        user.setPassword(encoder.encode(user.getPassword()));
        users.save(user);
        return "reg";
    }

    @GetMapping("/reg")
    public String reg(Model model) {
        return "reg";
    }
}
