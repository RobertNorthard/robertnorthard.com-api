package com.robertnorthard.api.layer.persistence.entities;

import java.util.Date;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * This class represents a blog post
 * @author robertnorthard
 *
 */
public class Post {

    private String _id, title, body;
    private User author;
    private Date timestamp;
    
    /**
     * Default constructor
     */
    public Post(){ }
    
    /**
     * @param title
     * @param body
     * @param author
     */
    public Post(String title, String body, User author) {
        super();
        this._id = new ObjectId().toString();
        this.title = title;
        this.body = body;
        this.author = author;
        this.timestamp = new Date();
    }
    
    /**
     * @return the title
     */
    @JsonSerialize
    @JsonProperty("title")
    public String getTitle() {
        return this.title;
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
    @JsonSerialize
    @JsonProperty("body")
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
    @JsonSerialize
    @JsonProperty("author")
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
    @JsonSerialize
    @JsonProperty("timestamp")
    public Date getTimestamp() {
        return timestamp;
    }
    
    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the _id
     */
    @JsonSerialize
    @JsonProperty("id")
    public String get_id() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void set_id(String _id) {
        this._id = _id;
    }
}
