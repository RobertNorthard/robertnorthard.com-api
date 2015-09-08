package com.robertnorthard.api.controllers;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.robertnorthard.api.model.blog.Blog;
import com.robertnorthard.api.model.blog.BlogService;
import com.robertnorthard.api.model.blog.Post;
import com.robertnorthard.api.controllers.RESTController;

/**
 * Expose Blog Post API
 * @author robertnorthard
 */

@RestController
public class BlogPostController extends RESTController<Post,String> {
    
    private static final Logger LOGGER = Logger.getLogger(BlogPostController.class);
    
    private BlogService blog = new Blog();

    @Override
    @RequestMapping(value="/blog/posts", method=RequestMethod.GET)
    public List<Post> listAll() {
        // TODO Auto-generated method stub
        return blog.findAll();
    }

    @Override
    @RequestMapping(value="/blog/posts", method=RequestMethod.PUT)
    public Post create(Post json) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @RequestMapping(value="/blog/posts/{id}", method=RequestMethod.GET)
    public Post get(@PathVariable("id") String id) {
        // TODO Auto-generated method stub
        return blog.findById(id);
    }

    @Override
    @RequestMapping(value="/blog/posts/{id}", method=RequestMethod.PUT)
    public Map<String, Object> update(@PathVariable("id") String id, Post json) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @RequestMapping(value="/blog/posts/{id}", method=RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable("id") String id) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
