package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
    private final Map<String, User> users = new ConcurrentHashMap<>();

    public UserService() {
        users.put("user1", User.of("user1", "123"));
    }

    public void save(User user) {
        users.put(user.getUsername(), user);
    }

    public User findByUsername(String name) {
        return users.get(name);
    }
}
