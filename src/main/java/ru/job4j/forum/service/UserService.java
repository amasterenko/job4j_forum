package ru.job4j.forum.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.store.UserRepository;
/**
 *The class represents a service layer and using for managing User entities.
 *It is also used to retrieve user-related data for Spring Http Security.
 *
 *@author AndrewMs
 *@version 1.0
 */
@Service
public class UserService implements UserDetailsService {
    private final UserRepository users;

    public UserService(UserRepository users) {
        this.users = users;
    }

    public void save(User user) {
        users.save(user);
    }

    public User findByUsername(String name) {
        return users.findByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(user);
    }
}
