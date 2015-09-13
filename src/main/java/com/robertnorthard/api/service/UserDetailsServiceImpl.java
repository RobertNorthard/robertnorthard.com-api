package com.robertnorthard.api.service;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.robertnorthard.api.model.security.User;

/**
 * User details service implementation. 
 * @author robertnorthard
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = Logger
            .getLogger(UserDetailsServiceImpl.class);

    private UserService userService = new UserService();

    /**
     * Find user with specified username
     * @param username username of user to find
     * @return user if exists
     * @exception UsernameNotFoundException user not found
     */
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = this.userService.findByUsername(username);

        if (user == null) {
            LOGGER.debug(String.format("User not found - [%s]", username));
            throw new UsernameNotFoundException(username);
        }

        return user;
    }
}
