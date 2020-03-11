package com.example.demo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoWhileLabelErrorController implements ErrorController  {
 
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
    	Integer status = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Throwable problem=(Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
    	System.out.println("in error with "+status+" and exception "+problem);
        return "/";
    }
 
    @Override
    public String getErrorPath() {
        return "/error";
    }
}