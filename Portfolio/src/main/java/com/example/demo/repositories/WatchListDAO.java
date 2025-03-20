package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Watchlist;

@Repository
public interface WatchListDAO extends JpaRepository<Watchlist, Integer> {
	
	List<Watchlist> findByUserId(int userid);

}
