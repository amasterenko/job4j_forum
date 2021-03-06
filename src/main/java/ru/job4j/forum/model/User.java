package ru.job4j.forum.model;

import javax.persistence.*;
import java.util.Objects;
/**
 *Class represents the system user model.
 *
 *@author AndrewMs
 *@version 1.0
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String password;
    private String username;

    public static User of(String username) {
        User user = new User();
        user.username = username;
        return user;
    }

    public static User of(String username, String pwd) {
        User user = new User();
        user.username = username;
        user.setPassword(pwd);
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
