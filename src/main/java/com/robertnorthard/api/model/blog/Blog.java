package com.robertnorthard.api.model.blog;

import java.util.List;

import org.apache.log4j.Logger;

import com.robertnorthard.api.dao.blog.PostDAO;

/**
 * Implementation for Blog Service
 * @author robertnorthard
 *
 */
public class Blog implements BlogService {

    private static final Logger LOGGER = Logger.getLogger(Blog.class);
    
    private PostDAO dao = new PostDAO();
    
    public Post createPost(Post post) {
        // TODO Auto-generated method stub
        return this.dao.create(post);
    }

    public boolean deletePost(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    public List<Post> findAll() {
        return this.dao.findAll();
    }

    public Post findById(String id) {
        return this.dao.findById(id);
    }

    public Post update(String id, Post post) {
        // TODO Auto-generated method stub
        return this.dao.update(id, post);
    }
}
