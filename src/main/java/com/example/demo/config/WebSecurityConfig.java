package com.example.demo.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final ObjectMapper mapper = new ObjectMapper();


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		//.csrf().disable()
		//.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
		//.cors().disable()
		//.anonymous().authorities("ROLE_ANONYMOUS")
        //.and()
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS, "/").permitAll()
        .antMatchers(HttpMethod.GET, "/").permitAll()
        .antMatchers(HttpMethod.POST, "/person").permitAll()
        //.antMatchers(HttpMethod.GET, "/login").permitAll()
			
			
        .antMatchers( "/secured/**").authenticated()
				//.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginProcessingUrl("/login")

				.successHandler(new AuthenticationSuccessHandler() {
					//we could also have wired in a bean for AuthenticationSuccessHandler instead of this anonymous class
					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
						/*
						 * we are getting org.springframework.security.core.userdetails.User for principal
						 * This can be changed if needed seperately
						 * 
						 * If needed dont send the principal.
						 * wrap the data into some other bean.
						 */
						User user=(User) authentication.getPrincipal();
						
						response.setContentType("application/json;charset=UTF-8");
				        PrintWriter writer = response.getWriter();
				        writer.write(mapper.writeValueAsString(user));
				        response.setStatus(HttpServletResponse.SC_OK);
				        writer.flush();
				        writer.close();
					}
				})
				.permitAll()
				.and()
			.logout()
				.permitAll();
		
		http.csrf().ignoringAntMatchers("/login", "/person");
		//next remove /person from here
		//try invoking from angular
		//
	}
	
	private CsrfTokenRepository csrfTokenRepository() {
		  HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		  repository.setHeaderName("X-XSRF-TOKEN");
		  return repository;
		}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
