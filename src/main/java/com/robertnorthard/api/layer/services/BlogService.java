package com.robertnorthard.api.layer.services;

import java.util.List;

import com.robertnorthard.api.layer.persistence.dao.PostDAO;
import com.robertnorthard.api.layer.persistence.dao.EntityDao;
import com.robertnorthard.api.layer.persistence.entities.Post;

/**
 * Implementation for Blog Service
 * @author robertnorthard
 *
 */
public class BlogService implements BlogFacade {

    private PostDAO dao = new PostDAO();
    
    public Post createPost(Post post) {
        return this.dao.persistEntity(post);
    }

    public void deletePost(String id) {
        this.dao.deleteEntityById(id);
    }

    public List<Post> findAll() {
        return this.dao.findAll();
    }

    public Post findById(String id) {
        return this.dao.findEntityById(id);
    }

    public Post update(String id, Post post) {
        return this.dao.update(id, post);
    }
}
