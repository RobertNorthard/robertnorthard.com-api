package com.robertnorthard.api.model.blog;

import java.util.List;

/**
 * Interface for Blog Service
 * @author robertnorthard
 *
 */
public interface BlogService {
   
    /**
     * Create Blog post
     * @param post post to create
     * @return created blog post
     */
    Post createPost(Post post);
    
    /**
     * Delete Blog post
     * @param id id of post to delete
     * @return true if deleted, else false
     */
    boolean deletePost(String id);
    
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
     * @param post post to update
     * @return updated blog post
     */
    Post update(String id, Post post);
}
