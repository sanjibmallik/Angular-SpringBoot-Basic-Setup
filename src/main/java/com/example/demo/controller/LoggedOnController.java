package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;


@RestController
public class LoggedOnController {

	@RequestMapping(path = "/getLoggedOnUser", method = RequestMethod.GET)
	public User isLoggedOn(HttpServletRequest request) {
		System.out.println("refresh begins");
		HttpSession session = request.getSession(false);
		if(session!=null)
		{
			System.out.println("sessionId="+session.getId());
		}
		else
		{
			System.out.println("null session");
		}
		String remoteUser = request.getRemoteUser();
		System.out.println("remoteUser="+remoteUser);
		Authentication authentication = SecurityContextHolder.getContext()
        .getAuthentication();
		System.out.println("auth="+authentication+"@"+authentication.getClass().getName());
		boolean authenticated = authentication.isAuthenticated();
		
		System.out.println("authenticated="+authenticated);
		User ret=null;
		if(authentication instanceof AnonymousAuthenticationToken)
		{
			
		}
		else if(authentication instanceof UsernamePasswordAuthenticationToken)
		{
			ret=(User) authentication.getPrincipal();
		}
		else
		{
			//handle in case of customization in security
			throw new RuntimeException("improve logic here according to the customisation you must have implemented");
		}
		return ret;
	}

}
