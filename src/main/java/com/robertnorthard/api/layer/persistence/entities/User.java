package com.robertnorthard.api.layer.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * This class represents a user
 * 
 * @author robertnorthard
 */
public class User implements UserDetails {

    private String _id, username, password, displayName;
    private List<SimpleGrantedAuthority> authorities;

    /**
     * Default constructor
     */
    public User() { }

    /**
     * Constructor for class user
     * 
     * @param username user's username
     * @param password user's password
     */
    public User(String username, String password) {
        super();
        this._id = new ObjectId().toString();
        this.username = username;
        this.password = password;
        this.authorities = new ArrayList<>();
    }
    
    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @param displayName the displayName to set
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }


    /**
     * @return the password
     */
    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    @JsonSerialize
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the authorities
     */
    @JsonIgnore
    @Override
    public List<SimpleGrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    /**
     * @param authorities
     *            the authorities to set
     */
    @JsonSerialize
    @JsonProperty("authorities")
    public void setAuthorities(
            List<SimpleGrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    

    /**
     * @param authority
     *            the authority to add
     */
    public void addAuthority(SimpleGrantedAuthority authority) {
        this.authorities.add(authority);
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
    @JsonSerialize
    @JsonProperty("username")
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        // TODO 
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
     // TODO 
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
     // TODO 
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
     // TODO 
        return true;
    }
}
