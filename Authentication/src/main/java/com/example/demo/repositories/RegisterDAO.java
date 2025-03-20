package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.User;

public interface RegisterDAO extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);

}
