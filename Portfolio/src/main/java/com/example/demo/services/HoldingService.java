package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Holding;
import com.example.demo.repositories.HoldingsDAO;

@Service
public class HoldingService {
	
	@Autowired
    private HoldingsDAO holdingRepository;

	 public List<Holding> getUserHoldings(int userid) 
	 {
		 return holdingRepository.findByUserid(userid);
	 }

	 public Holding getHoldingDetails(int id) 
	 {
	        return holdingRepository.findById(id).orElse(null);
	 }

	 public String updateHolding(Holding holding) 
	 {
		 if (holdingRepository.existsById(holding.getId())) {
	            holdingRepository.save(holding);
	            return "Holding updated successfully!";
	        }
	        return "Holding not found!";
	 }

}
