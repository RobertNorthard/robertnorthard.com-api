package com.robertnorthard.api.service;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.robertnorthard.api.dao.UserDAO;
import com.robertnorthard.api.model.security.User;

/**
 * Implementation for User Service
 * 
 * @author robertnorthard
 *
 */
public class UserService implements UserDetailsService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    private UserDAO dao = new UserDAO();

    /**
     * Find user with specified name
     * 
     * @param username
     *            user to find
     * @return user, null if user not found.
     */
    public User findByUsername(String username) {
        return this.dao.findByUsername(username);
    }

    /**
     * Return user if authenticated else null
     * 
     * @param user
     *            user to authenticate with
     * @return user if authenticated else null
     */
    public User authenticate(User user) {
        User usr = this.dao.findByUsername(user.getUsername());

        if (usr != null && user.getPassword().equals(usr.getPassword())) {
            return usr;
        } else {
            LOGGER.debug(String.format("Authentication failed for user- [%s]", user.getUsername()));
            return null;
        }
    }

    /**
     * Find user with specified username
     * 
     * @param username
     *            username of user to find
     * @return user if exists
     * @exception UsernameNotFoundException
     *                user not found
     */
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = this.findByUsername(username);

        if (user == null) {
            LOGGER.debug(String.format("User not found - [%s]", username));
            throw new UsernameNotFoundException(username);
        }

        return user;
    }
}
