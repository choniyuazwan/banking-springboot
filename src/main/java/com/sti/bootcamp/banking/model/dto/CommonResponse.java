package com.sti.bootcamp.banking.model.dto;

public class CommonResponse<T> {
    private String responsecode;
    private String responsemessage;
    private T data;

    public CommonResponse(){
        this.responsecode="01";
        this.responsemessage="success";
    }

    public String getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(String responsecode) {
        this.responsecode = responsecode;
    }

    public String getResponsemessage() {
        return responsemessage;
    }

    public void setResponsemessage(String responsemessage) {
        this.responsemessage = responsemessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
