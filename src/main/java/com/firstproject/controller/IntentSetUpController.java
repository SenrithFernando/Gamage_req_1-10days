package com.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntentSetUpController {

    @Autowired
    IntentSetUpService intentService;

    @GetMapping
    public String forTest(){
        return"working fine";
    }

}
