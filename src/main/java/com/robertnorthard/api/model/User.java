package com.robertnorthard.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * This class represents a user
 * @author robertnorthard
 */
public class User {
    
    private int id;
    private String firstName;
    private String surname;

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
    public User(int id, String firstName, String surname) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the firstName
     */
    @JsonSerialize
    @JsonProperty("firstname")
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }
    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
