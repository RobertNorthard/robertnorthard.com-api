package com.robertnorthard.api.service;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.robertnorthard.api.model.security.User;

public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = Logger.getLogger(UserDetailsServiceImpl.class);
    private UserService userService = new UserService();

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = this.userService.findByUsername(username);
        
        if (user == null)
            throw new UsernameNotFoundException(username);

        return new CustomUserDetails(user, true, true, true, true,
                user.getAuthorities());
    }

    /**
     * Custom User Details Implementation
     *
     */
    class CustomUserDetails extends
            org.springframework.security.core.userdetails.User {

        private User user;

        public CustomUserDetails(User user,
                Collection<? extends GrantedAuthority> authorities) {
            super(user.getUsername(), user.getPassword(), authorities);
            this.user = user;
        }

        public CustomUserDetails(User user, boolean enabled,
                boolean accountNonExpired, boolean credentialsNonExpired,
                boolean accountNonLocked,
                Collection<? extends GrantedAuthority> authorities) {
            super(user.getUsername(), user.getPassword(), enabled,
                    accountNonExpired, credentialsNonExpired, accountNonLocked,
                    authorities);
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }
}
