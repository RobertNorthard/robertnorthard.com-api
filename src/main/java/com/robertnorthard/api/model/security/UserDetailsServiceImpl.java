package com.robertnorthard.api.model.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class UserDetailsServiceImpl implements UserDetailsService {

    public UserDetails loadUserByUsername(String login)
    {
        // TODO Get user using User Data Access Object
        List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        auth.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new CustomUserDetails(new User(login, "password"), true, true, true, true, auth);
    }
    
    /**
     * Custom User Details Implementation
     *
     */
    class CustomUserDetails extends org.springframework.security.core.userdetails.User {

        private User user;

        public CustomUserDetails(User user, Collection<? extends GrantedAuthority> authorities) {
            super(user.getUsername(), user.getPassword(), authorities);
            this.user = user;
        }

        public CustomUserDetails(User user, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
            super(user.getUsername(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }
}
