package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping(path = "/secured/abc")
	public String hello2() {
		System.out.println("successfully logged in");
		return "Hello ..";
	}
}
