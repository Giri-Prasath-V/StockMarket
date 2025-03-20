package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entites.User;
import com.example.demo.repositories.RegisterDAO;

@Service
public class RegisterService {
	
	@Autowired
    private RegisterDAO register;

    public String registerUser(User user) 
    {
        if (user.getBalance() > 100000) {
            return "Deposit amount cannot exceed 1 lakh!";
        }
        register.save(user);
        return "User registered successfully!";
    }

    public String loginUser(String username, String password) {
        Optional<User> user = register.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) 
        {
            return "Login successful!";
        }
        return "Invalid username or password!";
    }
    
    public String changePassword(String username, String oldPassword, String newPassword) {
        Optional<User> user = register.findByUsername(username);
        if (user.isPresent()) {
            User existingUser = user.get();
            if (existingUser.getPassword().equals(oldPassword)) {
                existingUser.setPassword(newPassword);
                register.save(existingUser);
                return "Password changed successfully!";
            } else {
                return "Incorrect old password!";
            }
        }
        return "User not found!";
    }

    
    public String forgetPassword(String username, String dob) {
        Optional<User> user = register.findByUsername(username);
        if (user.isPresent() && user.get().getDob().equals(dob)) {
            return "Your password is: " + user.get().getPassword();
        }
        return "Invalid username or date of birth!";
    }
    
    public int getUserBalance( int userid) {
        User user = register.findById(userid).orElse(null);
        return (user != null) ? user.getBalance() : 0;
    }

}
