package com.robertnorthard.api.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.robertnorthard.api.model.security.User;
import com.robertnorthard.api.service.UserService;

/**
 * Expose Auth API
 * @author robertnorthard
 */
@RestController
public class AuthController {
    
    private UserService userService = new UserService();

    @RequestMapping(value="/auth", method=RequestMethod.PUT)
    public User login(@RequestBody User user, HttpServletResponse response) {
        
        User userDetails = this.userService.authenticate(user);

        // User has successfully authenticated
        if (userDetails != null)
            return userDetails;
            
        // Failed to authenticate user
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return null;
    }
}
