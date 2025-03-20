package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Holding;
import com.example.demo.services.HoldingService;

@RestController
@RequestMapping("/holdings")
public class HoldingController {
	
	@Autowired
    private HoldingService holdingService;


    @GetMapping("/{userid}")
    public List<Holding> getUserHoldings(@PathVariable int userid) 
    {
        return holdingService.getUserHoldings(userid);
    }

 
    @GetMapping("/details/{id}")
    public Holding getHoldingDetails(@PathVariable int id) {
        return holdingService.getHoldingDetails(id);
    }

    
    @PostMapping("/update")
    public String updateHolding(@RequestBody Holding holding) 
    {
        return holdingService.updateHolding(holding);
    }

}
