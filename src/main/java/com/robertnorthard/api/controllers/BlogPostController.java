package com.robertnorthard.api.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.robertnorthard.api.model.blog.Blog;
import com.robertnorthard.api.model.blog.BlogService;
import com.robertnorthard.api.model.blog.Post;

/**
 * Expose Blog Post API
 * @author robertnorthard
 */

@RestController
public class BlogPostController {
    
    private static final Logger LOGGER = Logger.getLogger(BlogPostController.class);
    
    private BlogService blog = new Blog();
    
    @RequestMapping(value="/blog/posts", method=RequestMethod.GET)
    public List<Post> retrieve(){
        return blog.findAll();
    }
    
    @RequestMapping(value="/blog/posts", method=RequestMethod.PUT)
    public Post post(@RequestBody Post post){
        // TODO validation
        Post newPost = new Post(post.getTitle(), post.getBody(), post.getAuthor());
        this.blog.createPost(newPost);
        return newPost;
    }
    
    @RequestMapping(value="/blog/posts/{id}", method=RequestMethod.GET)
    public Post findPost(@PathVariable("id") String id){
        return this.blog.findById(id);
    }
}
