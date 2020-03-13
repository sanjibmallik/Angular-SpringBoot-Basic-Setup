package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class LoggedOnController {

	@RequestMapping(path = "/getLoggedOnUser", method = RequestMethod.GET)
	public User getLoggedOnUser(HttpServletRequest request) {
		
		Authentication authentication = SecurityContextHolder.getContext()
        .getAuthentication();
		User ret=null;
		if(authentication instanceof UsernamePasswordAuthenticationToken)
		{
			Object principal=authentication.getPrincipal();
			if(principal instanceof User)
			{
				ret=(User) principal;
			}
			else
			{
				throw new RuntimeException("improve logic and return type here according to the customisation you must have implemented for "+principal.getClass().getName());
			}
			
		}
		else if(authentication instanceof AnonymousAuthenticationToken)
		{
			//ignoring
		}
		else
		{
			//handle in case of customization in security
			throw new RuntimeException("improve logic here according to the customisation you must have implemented for "+authentication.getClass().getName());
		}
		
		return ret;
	}

}
