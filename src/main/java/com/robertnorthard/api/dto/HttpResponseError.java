package com.robertnorthard.api.dto;

public class HttpResponseError {

    private int status;
    private String title, detail;
    
    public HttpResponseError(int status, String title, String detail){
        this.status = status;
        this.title = title;
        this.detail = detail;
    }
    
    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }    
}
