package com.robertnorthard.api.model.security;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * This class represents a user
 * 
 * @author robertnorthard
 */
public class User {

    private String _id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    /**
     * Default constructor
     */
    public User() {
    }

    /**
     * Constructor for class user
     * 
     * @param id
     *            the user's id
     * @param firstName
     *            the user's firstname
     * @param surname
     *            the user's surname
     */
    public User(String username, String password) {
        super();
        this._id = new ObjectId().toString();
        this.username = username;
        this.password = password;
    }

    /**
     * @return the password
     */
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the authorities
     */
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    /**
     * @param authorities
     *            the authorities to set
     */
    public void setAuthorities(
            Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
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
     * @param id
     *            the id to set
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
}
