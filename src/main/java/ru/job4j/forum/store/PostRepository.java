package ru.job4j.forum.store;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Post;
/**
 *Interface provides CRUD functionality for the Post entity class.
 *
 *@author AndrewMs
 *@version 1.0
 */
public interface PostRepository extends CrudRepository<Post, Integer> {
}
