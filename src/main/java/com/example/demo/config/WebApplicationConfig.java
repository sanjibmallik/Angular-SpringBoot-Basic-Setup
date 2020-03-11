package com.example.demo.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class WebApplicationConfig implements
  WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
  
    public void customize(ConfigurableServletWebServerFactory factory) {
    	ErrorPage errorPage = new ErrorPage(HttpStatus.NOT_FOUND, "/");
       factory.addErrorPages(new ErrorPage[]{errorPage});
     }
}