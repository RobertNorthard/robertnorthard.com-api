
package com.robertnorthard.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Expose health status API
 * @author robertnorthard
 */

@RestController
public class HealthController {
    @RequestMapping("/health")
    public String health(){
        //TODO: Implement Health Status Check
        return "{\"Status\":\"UP\"}";
    }
}
