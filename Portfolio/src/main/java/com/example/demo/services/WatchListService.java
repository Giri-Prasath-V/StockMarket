package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Watchlist;
import com.example.demo.repositories.WatchListDAO;

@Service
public class WatchListService {
	
	@Autowired
    private WatchListDAO watchlistRepository;

    
    public String addToWatchlist(Watchlist watchlist) 
    {
        watchlistRepository.save(watchlist);
        return "Stock added to watchlist successfully!";
    }

    
    public String removeFromWatchlist(int id) 
    {
        if (watchlistRepository.existsById(id)) 
        {
            watchlistRepository.deleteById(id);
            return "Stock removed from watchlist!";
        }
        return "Stock not found in watchlist!";
    }

    
    public List<Watchlist> getUserWatchlist(int userid) 
    {
        return watchlistRepository.findByUserId(userid);
    }

}
