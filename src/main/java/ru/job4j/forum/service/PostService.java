package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.store.PostRepository;

import java.util.*;

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
        List<Post> res = new ArrayList<>();
        posts.findAll().forEach(res::add);
        return res;
    }

    public Post findById(int id) {
        return posts.findById(id).orElse(null);
    }
}
