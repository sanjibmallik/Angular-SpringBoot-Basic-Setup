package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;

@RestController

public class HomeController {

	

	@GetMapping(path = "/hellos1")
	public String hello1() {
		
		return "Hello ..";
	}
	
	@GetMapping(path = "/hellos2")
	public Person hello2() {
		
		return new Person();
	}

	@GetMapping(path = "/secured/abc")
	public String securedabc() {
		
		return "Hello ..";
	}
}
