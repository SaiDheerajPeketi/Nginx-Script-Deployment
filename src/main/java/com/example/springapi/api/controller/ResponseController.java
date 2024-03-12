package com.example.springapi.api.controller;

import com.example.springapi.api.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.springapi.service.ResponseService;

@RestController
public class ResponseController
{

    private ResponseService responseService;

    @Autowired
    public ResponseController(ResponseService responseService){
        this.responseService = responseService;
    }
    @GetMapping("/response")
    public ResponseModel getResponse(@RequestParam(value="name", defaultValue = "User") String name){
        return responseService.getResponse(name);
    }

    @GetMapping("/store")
    public ResponseModel storeData(@RequestParam(value="data", defaultValue = "0.0") String temperature){
        return responseService.storeData(temperature);
    }
}
