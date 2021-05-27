package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.store.UserRepository;

@Service
public class UserService {
    private UserRepository users;

    public UserService(UserRepository users) {
        this.users = users;
    }

    public void save(User user) {
        users.save(user);
    }

    public User findByUsername(String name) {
        return users.findByUsername(name);
    }
}
