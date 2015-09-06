
package com.robertnorthard.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Expose health status API
 * @author robertnorthard
 */

@RestController
@RequestMapping("/health")
public class HealthController {
    @RequestMapping(method=RequestMethod.GET)
    public String health(){
        //TODO: Implement Health Status Check
        return "{\"Status\":\"UP\"}";
    }
}
