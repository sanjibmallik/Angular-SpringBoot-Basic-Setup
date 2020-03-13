package com.example.demo.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.model.User;
//import org.springframework.security.core.userdetails.User;

public final class SecurityUtils {
	
	private SecurityUtils() {}
	
	
	public static User getCurrentUser() {	
		
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication =  securityContext.getAuthentication();
		User user = null;
		
		
		user  = (User) authentication.getPrincipal();
		System.out.println(authentication.getPrincipal().toString());
		
	
		if(authentication != null) {
			if(authentication.getPrincipal() instanceof User) {
				user  = (User) authentication.getPrincipal();
				System.out.println(authentication.getPrincipal().toString());
						
			}
		}
		return user;

	}


}
