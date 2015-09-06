package com.robertnorthard.api.controllers;

import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.robertnorthard.api.model.User;
import com.robertnorthard.api.model.blog.Blog;
import com.robertnorthard.api.model.blog.BlogService;
import com.robertnorthard.api.model.blog.Post;

/**
 * Expose Blog Post API
 * @author robertnorthard
 */

@RestController
@RequestMapping("/blog/post")
public class BlogPostController {
    
    private BlogService blog = new Blog();
    
    @RequestMapping(method=RequestMethod.GET)
    public Post retrieve(){
        
        // TODO Read from DAO, etc document store.
        return new Post(100, "Title - Example", "Body - Example", new User(100, "John", "Smith"), new Date());
    }
    
    @RequestMapping(value="{id}", method=RequestMethod.PUT)
    public Post post(@PathVariable long id, @RequestBody Post post){
        // TODO validation
        this.blog.createPost(post);
        return post;
    }
}
