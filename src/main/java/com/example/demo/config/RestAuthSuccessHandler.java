package com.example.demo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.demo.security.SecurityUtils;

@Component
public class RestAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, 
			Authentication authentication) {
		
		try {
			SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK);
		}catch(Exception e) {
			
		}
		
		}
}
