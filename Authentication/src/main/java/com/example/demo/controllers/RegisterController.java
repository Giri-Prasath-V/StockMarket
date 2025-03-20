package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.User;
import com.example.demo.entities.ChangePasswordRequest;
import com.example.demo.services.RegisterService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterController {
	
	@Autowired
    private RegisterService register;
	
	@GetMapping("/")
	
	public String greet()
	{
		return "Welcome";
	}

    
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) 
    {
        return register.registerUser(user);
    }

    
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        return register.loginUser(user.getUsername(), user.getPassword());
    }

    
   
    @PutMapping("/changepassword")
    public String changePassword(@RequestBody ChangePasswordRequest request) {
        return register.changePassword(request.getUsername(), request.getOldPassword(), request.getNewPassword());
    }

   
    @GetMapping("/forgetpassword")
    public String forgetPassword(@RequestParam String username, @RequestParam String dob) {
        return register.forgetPassword(username, dob);
    }
    
    @GetMapping("/balance/{userid}")
    public int getUserBalance(@PathVariable int userid) {
        return register.getUserBalance(userid);
    }


}
