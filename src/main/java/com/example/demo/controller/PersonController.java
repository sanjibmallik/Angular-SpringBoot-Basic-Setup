package com.example.demo.controller;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;

@RestController
public class PersonController {
	private Random ran = new Random(); 
	@RequestMapping(path = "/person", method = RequestMethod.POST)
	public Person person(@Valid @RequestBody Person person) {
		 
	     int nxt = ran.nextInt(10); 
	     if(nxt>=5)
	     {
	    	 throw new RuntimeException("Breaking logic");
	     }
		return person;
	}
}
