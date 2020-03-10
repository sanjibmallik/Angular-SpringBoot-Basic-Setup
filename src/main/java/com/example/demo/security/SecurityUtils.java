package com.example.demo.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SecurityUtils {
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	public static void sendResponse(HttpServletResponse response, int status) {
		response.setContentType("application/json:charset=UTF-8");
		try {
			PrintWriter writer =  response.getWriter();
			response.setStatus(status);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void getCurrentUser() {
		
	}

}
