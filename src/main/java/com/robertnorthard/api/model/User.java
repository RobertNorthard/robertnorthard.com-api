package com.robertnorthard.api.model;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * This class represents a user
 * @author robertnorthard
 */
public class User {
    
    
    private String _id;
    private String username;
    private String displayName;
    private String[] roles;

    /**
     * Default constructor
     */
    public User(){ }
    
    /**
     * Constructor for class user
     * @param id the user's id
     * @param firstName the user's firstname
     * @param surname the user's surname
     */
    public User(String username) {
        super();
        this._id = new ObjectId().toString();
        this.username = username;
    }
    
    /**
     * @return the id
     */
    @JsonSerialize
    @JsonProperty("id")
    public String getId() {
        return _id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this._id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Authenticate user
     * @param password user's password
     * @return true if authenticated, else false.
     */
    public boolean authenticate(String password){
        // TODO add authentication
        return false;
    }

    /**
     * @return the roles
     */
    @JsonIgnore
    public String[] getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(String[] roles) {
        this.roles = roles;
    }

}
