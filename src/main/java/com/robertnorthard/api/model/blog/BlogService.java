package com.robertnorthard.api.model.blog;

import java.util.List;

import org.apache.log4j.Logger;

import com.mongodb.client.result.DeleteResult;
import com.robertnorthard.api.dao.PostDAO;

/**
 * Implementation for Blog Service
 * @author robertnorthard
 *
 */
public class BlogService implements Blog {

    private static final Logger LOGGER = Logger.getLogger(BlogService.class);
    
    private PostDAO dao = new PostDAO();
    
    public Post createPost(Post post) {
        // TODO Auto-generated method stub
        return this.dao.create(post);
    }

    public DeleteResult deletePost(String id) {
        // TODO Auto-generated method stub
        return this.dao.delete(id);
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
