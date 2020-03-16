package com.example.demo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoWhiteLabelErrorController implements ErrorController  {
 
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
    	Integer status = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Throwable problem=(Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
    
        return "/";
    }
 
    @Override
    public String getErrorPath() {
        return "/error";
    }
}