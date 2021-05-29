package ru.job4j.forum.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.store.PostRepository;

import java.util.*;
/**
 *The class is a service layer for managing post entities.
 *
 *@author AndrewMs
 *@version 1.0
 */
@Service
public class PostService {
    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setCreated(new Date(System.currentTimeMillis()));
        }
        posts.save(post);
    }

    public List<Post> getAll() {
        return new ArrayList<>(posts.findAllByOrderByIdAsc());
    }

    public Post findById(int id) {
        return posts.findById(id).orElse(null);
    }
}
