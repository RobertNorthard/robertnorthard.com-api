package com.robertnorthard.api.service.blog;

import java.util.List;

import com.robertnorthard.api.dao.PostDAO;
import com.robertnorthard.api.model.blog.Post;

/**
 * Implementation for Blog Service
 * @author robertnorthard
 *
 */
public class BlogService implements Blog {

    private PostDAO dao = new PostDAO();
    
    public Post createPost(Post post) {
        return this.dao.create(post);
    }

    public boolean deletePost(String id) {
        return this.dao.delete(id);
    }

    public List<Post> findAll() {
        return this.dao.findAll();
    }

    public Post findById(String id) {
        return this.dao.findById(id);
    }

    public Post update(String id, Post post) {
        return this.dao.update(id, post);
    }
}
