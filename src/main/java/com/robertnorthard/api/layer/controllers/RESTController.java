package com.robertnorthard.api.layer.controllers;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.robertnorthard.api.layer.persistence.dto.HttpResponse;

@RestController
public abstract class RESTController<T, ID extends Serializable> {

    @RequestMapping(method=RequestMethod.GET)
    public abstract @ResponseBody HttpResponse<List<T>> get();

    @RequestMapping(method=RequestMethod.PUT, consumes={MediaType.APPLICATION_JSON_VALUE})
    public abstract @ResponseBody HttpResponse<T> create(@RequestBody T json);

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public abstract @ResponseBody HttpResponse<T> findById(@PathVariable("id") ID id, HttpServletResponse response);

    @RequestMapping(value="/{id}", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
    public abstract @ResponseBody HttpResponse<T> update(@PathVariable("id") ID id, @RequestBody T json, HttpServletResponse response);
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public  abstract @ResponseBody HttpResponse<T> delete(@PathVariable("id") ID id, HttpServletResponse response);
}