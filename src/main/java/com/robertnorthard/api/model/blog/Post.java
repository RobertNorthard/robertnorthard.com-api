package com.robertnorthard.api.model.blog;

import java.util.Date;

import com.robertnorthard.api.model.User;

/**
 * This class represents a blog post
 * @author robertnorthard
 *
 */
public class Post {

    private int id;
    private String title, body;
    private User author;
    private Date timestamp;
    
    /**
     * Default constructor
     */
    public Post(){ }
    
    /**
     * @param id
     * @param title
     * @param body
     * @param author
     * @param timestamp
     */
    public Post(int id, String title, String body, User author, Date timestamp) {
        super();
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
        this.timestamp = timestamp;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
   
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }
    
    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }
    
    /**
     * @return the author
     */
    public User getAuthor() {
        return author;
    }
    
    /**
     * @param author the author to set
     */
    public void setAuthor(User author) {
        this.author = author;
    }
    
    /**
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }
    
    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
}
