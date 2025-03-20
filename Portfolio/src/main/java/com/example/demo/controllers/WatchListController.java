package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Watchlist;
import com.example.demo.services.WatchListService;

@RestController
@RequestMapping("/watchlist")
public class WatchListController {
	
	@Autowired
    private WatchListService watchlistService;

    
    @PostMapping("/add")
    public String addToWatchlist(@RequestBody Watchlist watchlist) 
    {
        return watchlistService.addToWatchlist(watchlist);
    }

    
    @DeleteMapping("/remove/{id}")
    public String removeFromWatchlist(@PathVariable int id) 
    {
        return watchlistService.removeFromWatchlist(id);
    }

    
    @GetMapping("/{userid}")
    public List<Watchlist> getUserWatchlist(@PathVariable int userid) 
    {
        return watchlistService.getUserWatchlist(userid);
    }

}
