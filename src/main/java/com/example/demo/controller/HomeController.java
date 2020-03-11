package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;

@RestController

public class HomeController {

	/*
	 * @GetMapping(path ="/login") public String error() {
	 * System.out.println("here in chaneg"); return "forward:/index.html"; }
	 */

	@GetMapping(path = "/hellos1")
	public String hello1() {
		System.out.println("successfully logged in");
		return "Hello ..";
	}
	
	@GetMapping(path = "/hellos2")
	public Person hello2() {
		
		return new Person();
	}

	@GetMapping(path = "/secured/abc")
	public String securedabc() {
		System.out.println("successfully logged in");
		return "Hello ..";
	}
}
