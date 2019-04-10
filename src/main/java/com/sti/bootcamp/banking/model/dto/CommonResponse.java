package com.sti.bootcamp.banking.model.dto;

public class CommonResponse<T> {
    private String responseCode;
    private String responseMessage;
    private T data;

    public CommonResponse(){
        this.responseCode ="01";
        this.responseMessage ="success";
    }

    public CommonResponse(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
