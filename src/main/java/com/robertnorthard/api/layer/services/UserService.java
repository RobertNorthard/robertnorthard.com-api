package com.robertnorthard.api.layer.services;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.robertnorthard.api.layer.persistence.dao.UserDAO;
import com.robertnorthard.api.layer.persistence.entities.User;
import com.robertnorthard.api.util.AuthenticationUtils;

/**
 * Implementation for User Service
 *
 * @author robertnorthard
 *
 */
public class UserService implements UserFacade {

    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    private UserDAO dao;

    public UserService() {
        dao = new UserDAO();
    }

    public UserService(UserDAO dao) {
        this.dao = dao;
    }

    /**
     * Find user with specified name
     *
     * @param username user to find
     * @return user, null if user not found.
     */
    public User findByUsername(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        } else {
            return this.dao.findByUsername(username);
        }
    }

    /**
     * Return user if authenticated else null
     *
     * @param user user to authenticate with
     * @return user if authenticated else null
     */
    public User authenticate(User user) {
        User usr = this.dao.findByUsername(user.getUsername());

        if (usr != null && AuthenticationUtils.checkPassword(user.getPassword(), usr.getPassword())) {
            return usr;
        } else {
            LOGGER.debug(String.format("Authentication failed for user - [%s]", user.getUsername()));
            return null;
        }
    }

    /**
     * Find user with specified username
     *
     * @param username username of user to find
     * @return user if exists
     * @exception UsernameNotFoundException user not found
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
