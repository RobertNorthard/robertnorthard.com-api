package com.robertnorthard.api.service.blog;

import java.util.List;

import com.robertnorthard.api.dao.PostDAO;
import com.robertnorthard.api.dao.EntityDao;
import com.robertnorthard.api.model.blog.Post;

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
