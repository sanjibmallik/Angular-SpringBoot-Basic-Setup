package com.example.demo.controller;

/**
 * 
 */


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/")
public class HomeController {
	
	
	
@GetMapping(path ="/hellos")	
public String hello() {
	System.out.println("successfully logged in");
	return "Hello ..";
}
}
