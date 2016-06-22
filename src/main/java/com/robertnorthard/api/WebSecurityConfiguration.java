package com.robertnorthard.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.robertnorthard.api.layer.services.UserService;

/**
 * Global Authentication Adapter
 * 
 * @author robertnorthard
 */

@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserService());
    }
}

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // TODO CORS/TIDY
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/health")
                .hasRole("ADMIN").antMatchers(HttpMethod.GET, "/blog/posts")
                .permitAll().antMatchers(HttpMethod.PUT, "/blog/posts/**")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/blog/posts/**")
                .hasRole("ADMIN").antMatchers(HttpMethod.PUT, "/auth")
                .permitAll().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .and().csrf().disable()
                .httpBasic().and().logout();
    }
}
