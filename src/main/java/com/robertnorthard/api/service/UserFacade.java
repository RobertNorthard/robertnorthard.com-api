package com.robertnorthard.api.service;

import com.robertnorthard.api.model.security.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Interface for user service.
 * 
 * @author robertnorthard
 */
public interface UserFacade extends UserDetailsService {
    
    /**
     * Find user with specified name
     *
     * @param username user to find
     * @return user, null if user not found.
     */
    public User findByUsername(String username);
    
    /**
     * Return user if authenticated else null
     *
     * @param user user to authenticate with
     * @return user if authenticated else null
     */
    public User authenticate(User user);
    
}
