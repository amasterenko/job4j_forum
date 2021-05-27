package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService {

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private final AtomicInteger index = new AtomicInteger(2);

    public PostService() {
        posts.put(1, Post.of(1, "Post 1", "It's a very interesting description.."));
        posts.put(2, Post.of(2, "Post 2", "Not a very interesting description.."));
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(index.incrementAndGet());
            post.setCreated(new Date(System.currentTimeMillis()));
        }
        posts.put(post.getId(), post);
    }

    public Collection<Post> getAll() {
        return posts.values();
    }

    public Post findById(int id) {
        return posts.get(id);
    }
}
