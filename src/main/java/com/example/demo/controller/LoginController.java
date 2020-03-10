package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.User;

@Controller
@RequestMapping("/")
public class LoginController {

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public boolean login(@RequestBody User user) {
        return
          user.getUsername().equals("admin") && user.getPassword().equals("admin");
    }
	
	@RequestMapping(value = "authenticate", method = RequestMethod.GET)
	public boolean authenticate() {
		
		return true;
	}
	
}
