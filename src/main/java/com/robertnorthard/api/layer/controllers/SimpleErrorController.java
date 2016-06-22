package com.robertnorthard.api.layer.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
public class SimpleErrorController implements ErrorController {

    private static final String PATH = "/error";
    
    @Autowired
    private ErrorAttributes errorAttributes;
    
    @Value("${app.debug:false}")
    private boolean debug;

    @RequestMapping(value = PATH)
    public @ResponseBody Map<String, Object> error(HttpServletRequest request, HttpServletResponse response) {
        return this.getErrorAttributes(request, debug);
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

    /**
     * Return error attributes
     * @param request HTTP request object
     * @param includeStackTrace include stack trace in error message
     * @return Key value map of error message
     */
    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }

}