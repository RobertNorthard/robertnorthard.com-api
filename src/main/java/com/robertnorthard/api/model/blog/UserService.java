package com.robertnorthard.api.model.blog;

import com.robertnorthard.api.dao.UserDAO;
import com.robertnorthard.api.model.security.User;

/**
 * Implementation for User Service
 * @author robertnorthard
 *
 */
public class UserService {

    private UserDAO dao = new UserDAO();
    
    /**
     * Find user with specified name
     * @param username user to find
     * @return user, null if user not found.
     */
    public User findByUsername(String username) {
        return this.dao.findByUsername(username);
    }
}
