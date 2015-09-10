package com.robertnorthard.api.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.result.DeleteResult;

@RestController
public abstract class RESTController<T, ID extends Serializable> {

    @RequestMapping(method=RequestMethod.GET)
    public abstract @ResponseBody List<T> listAll();

    @RequestMapping(method=RequestMethod.PUT, consumes={MediaType.APPLICATION_JSON_VALUE})
    public abstract @ResponseBody T create(@RequestBody T json);

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public abstract @ResponseBody T get(@PathVariable("id") ID id);

    @RequestMapping(value="/{id}", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
    public abstract @ResponseBody T update(@PathVariable("id") ID id, @RequestBody T json);
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public  abstract @ResponseBody DeleteResult delete(@PathVariable("id") ID id);
}