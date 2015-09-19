package com.robertnorthard.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Generic HttpResponse object.
 * 
 * @author robertnorthard
 */
@JsonInclude(Include.NON_NULL)
public class HttpResponse<T> {
    
    private T data;
    private String status;
    private HttpResponseError error;
    
    /**
     * Constructor for class HttpResponse
     */
    public HttpResponse(){ }
   
    
    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the error
     */
    public HttpResponseError getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(HttpResponseError error) {
        this.error = error;
    }
}
