package com.example.springapi.api.model;


public class ResponseModel {
    private String response;

    public ResponseModel(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}