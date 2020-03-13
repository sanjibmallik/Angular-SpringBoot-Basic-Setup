package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.utils.SecurityUtils;

@RestController
public class LoggedOnController {

	@RequestMapping(path = "/getLoggedOnUser", method = RequestMethod.GET)
	public User isLoggedOn() {
		return SecurityUtils.getCurrentUser();
	}

}
