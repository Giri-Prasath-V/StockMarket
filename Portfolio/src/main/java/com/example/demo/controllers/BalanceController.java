package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/balance")
public class BalanceController {

	@Autowired
    private RestTemplate restTemplate;

    private final String AUTH_SERVICE_URL = "http://AUTHENTICATION/balance/";

    
    @GetMapping("/{userid}")
    public int getUserBalance(@PathVariable int userid) {
        String url = AUTH_SERVICE_URL + userid;
        Integer balance = restTemplate.getForObject(url, Integer.class);
        return (balance != null) ? balance : 0;
    }
}
