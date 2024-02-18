package com.example.springapi.service;

import com.example.springapi.api.model.ResponseModel;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {
    public ResponseModel getResponse(String name) {
        return new ResponseModel("Hi " + name  + "! I'm a Response from Spring API");
    }

}
