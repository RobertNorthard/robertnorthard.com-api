package com.robertnorthard.api.layer.controllers;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.robertnorthard.api.layer.persistence.dto.HttpResponse;
import com.robertnorthard.api.layer.persistence.dto.HttpResponseError;
import com.robertnorthard.api.layer.persistence.entities.User;
import com.robertnorthard.api.layer.services.UserFacade;
import com.robertnorthard.api.layer.services.UserService;

/**
 * Expose Auth API
 * @author robertnorthard
 */
@RestController
public class AuthController {
    
    private static final Logger LOGGER = Logger.getLogger(AuthController.class);
    
    private UserFacade userService = new UserService();

    @RequestMapping(value="/auth", method=RequestMethod.PUT)
    public HttpResponse<User> login(@RequestBody User user, HttpServletResponse response) {
        
        HttpResponse<User> httpResponse = new HttpResponse<User>();
        User userDetails = this.userService.authenticate(user);

        // User has successfully authenticated
        if (userDetails != null){
            httpResponse.setData(userDetails);
            return httpResponse;
        }
        
        // Failed to authenticate user
        LOGGER.warn(String.format("Authentication failed for user - [%s]", user.getUsername()));
        
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        
        httpResponse.setError(new HttpResponseError(
                HttpServletResponse.SC_FORBIDDEN, "Authentication failure",
                "Authentication failure for user " + user.getUsername()));

        return httpResponse;
    }
}
