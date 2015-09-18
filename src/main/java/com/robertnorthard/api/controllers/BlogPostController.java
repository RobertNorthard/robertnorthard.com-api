package com.robertnorthard.api.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.result.DeleteResult;
import com.robertnorthard.api.model.blog.Post;
import com.robertnorthard.api.model.security.User;
import com.robertnorthard.api.service.blog.Blog;
import com.robertnorthard.api.service.blog.BlogService;
import com.robertnorthard.api.controllers.RESTController;

/**
 * Expose Blog Post API
 * @author robertnorthard
 */
@RestController
public class BlogPostController extends RESTController<Post,String> {
    
    private Blog blog = new BlogService();

    @Override
    @RequestMapping(value="/blog/posts", method=RequestMethod.GET)
    public List<Post> get() {
        return this.blog.findAll();
    }

    @Override
    @RequestMapping(value="/blog/posts", method=RequestMethod.PUT)
    public Post create(@RequestBody Post post) {
        Post p = new Post(post.getTitle(), post.getBody(), post.getAuthor());
        return this.blog.createPost(p);
    }

    @Override
    @RequestMapping(value="/blog/posts/{id}", method=RequestMethod.GET)
    public Post findById(@PathVariable("id") String id, HttpServletResponse response) {
        Post post = this.blog.findById(id);
        
        if (post != null) return post;
        
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return null;
    }
    
    @RequestMapping(value="/blog/posts/{id}/authors", method=RequestMethod.GET)
    public User findAuthorByPost(@PathVariable("id") String id, HttpServletResponse response) {
        
        if (this.blog.findById(id) != null){
            return this.blog.findById(id).getAuthor();
        }else{
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
    }

    @Override
    @RequestMapping(value="/blog/posts/{id}", method=RequestMethod.POST)
    public Post update(@PathVariable("id") String id, @RequestBody Post post, HttpServletResponse response) {
        return this.blog.update(id, post);
    }

    @Override
    @RequestMapping(value="/blog/posts/{id}", method=RequestMethod.DELETE)
    public DeleteResult delete(@PathVariable("id") String id, HttpServletResponse response) {
        if (this.blog.findById(id) != null){
            return this.blog.deletePost(id);
        }else{
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
    }
}
