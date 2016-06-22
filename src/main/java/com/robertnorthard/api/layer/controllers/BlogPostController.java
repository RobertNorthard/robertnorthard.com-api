package com.robertnorthard.api.layer.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.robertnorthard.api.layer.persistence.entities.Post;
import com.robertnorthard.api.layer.persistence.entities.User;
import com.robertnorthard.api.layer.services.BlogFacade;
import com.robertnorthard.api.layer.services.BlogService;
import com.robertnorthard.api.layer.controllers.RESTController;
import com.robertnorthard.api.layer.persistence.dto.HttpResponse;
import com.robertnorthard.api.layer.persistence.dto.HttpResponseError;

/**
 * Expose Blog Post API
 * 
 * @author robertnorthard
 */
@RestController
public class BlogPostController extends RESTController<Post, String> {

    private BlogFacade blog = new BlogService();

    @Override
    @RequestMapping(value = "/blog/posts", method = RequestMethod.GET)
    public HttpResponse<List<Post>> get() {
        HttpResponse<List<Post>> httpResponse = new HttpResponse<List<Post>>();
        httpResponse.setData(this.blog.findAll());
        return httpResponse;
    }

    @Override
    @RequestMapping(value = "/blog/posts", method = RequestMethod.PUT)
    public HttpResponse<Post> create(@RequestBody Post post) {
        Post p = new Post(post.getTitle(), post.getBody(), post.getAuthor());
        this.blog.createPost(p);
        HttpResponse<Post> httpResponse = new HttpResponse<Post>();
        httpResponse.setData(p);
        return httpResponse;
    }

    @Override
    @RequestMapping(value = "/blog/posts/{id}", method = RequestMethod.GET)
    public HttpResponse<Post> findById(@PathVariable("id") String id,
            HttpServletResponse response) {

        HttpResponse<Post> httpResponse = new HttpResponse<Post>();

        Post post = this.blog.findById(id);

        if (post != null) {
            httpResponse.setData(post);
            return httpResponse;
        }

        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        httpResponse.setError(new HttpResponseError(
                HttpServletResponse.SC_NOT_FOUND, "Post Not Found",
                "Blog post with id " + id + " not found"));

        return httpResponse;
    }

    @RequestMapping(value = "/blog/posts/{id}/authors", method = RequestMethod.GET)
    public HttpResponse<User> findAuthorByPost(@PathVariable("id") String id,
            HttpServletResponse response) {

        HttpResponse<User> httpResponse = new HttpResponse<User>();

        Post post = this.blog.findById(id);

        if (post != null) {
            httpResponse.setData(post.getAuthor());
            return httpResponse;
        }

        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        httpResponse.setError(new HttpResponseError(
                HttpServletResponse.SC_NOT_FOUND, "Post Not Found",
                "Blog post with id " + id + " not found"));

        return httpResponse;
    }

    @Override
    @RequestMapping(value = "/blog/posts/{id}", method = RequestMethod.POST)
    public HttpResponse<Post> update(@PathVariable("id") String id,
            @RequestBody Post post, HttpServletResponse response) {
        HttpResponse<Post> httpResponse = new HttpResponse<Post>();

        Post p = this.blog.findById(id);

        if (post != null) {
            httpResponse.setData(this.blog.update(id, p));
            return httpResponse;
        }

        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        httpResponse.setError(new HttpResponseError(
                HttpServletResponse.SC_NOT_FOUND, "Post Not Found",
                "Blog post with id " + id + " not found"));

        return httpResponse;
    }

    @Override
    @RequestMapping(value = "/blog/posts/{id}", method = RequestMethod.DELETE)
    public HttpResponse<Post> delete(@PathVariable("id") String id,
            HttpServletResponse response) {
        HttpResponse<Post> httpResponse = new HttpResponse<Post>();

        Post post = this.blog.findById(id);

        if (post != null) {
            this.blog.deletePost(id);
            httpResponse.setStatus("Blog post with id " + id + " deleted.");
            return httpResponse;
        }

        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        httpResponse.setError(new HttpResponseError(
                HttpServletResponse.SC_NOT_FOUND, "Post Not Found",
                "Blog post with id " + id + " not found"));

        return httpResponse;
    }
}
