package com.robertnorthard.api.layer.services;

import java.util.List;

import com.robertnorthard.api.layer.persistence.entities.Post;

/**
 * Interface for Blog Service
 * @author robertnorthard
 *
 */
public interface BlogFacade {
   
    /**
     * Create Blog post
     * @param post post to create
     * @return created post.
     */
    Post createPost(Post post);
    
    /**
     * Delete Blog post
     * @param id id of post to delete
     */
    void deletePost(String id);
    
    /**
     * Collection of blog posts
     * @return all blog posts
     */
    List<Post> findAll();
    
    /**
     * Return blog post with specified id
     * @param id if of blog post
     * @return blog post with specified id
     */
    Post findById(String id);
    
    /**
     * Update blog post
     * @param id post id
     * @param post post to update
     */
    Post update(String id, Post post);
}
