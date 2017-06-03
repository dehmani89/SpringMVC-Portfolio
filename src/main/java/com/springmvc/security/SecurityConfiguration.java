package com.springmvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Amine
 * This class is defined with conjunction of web.xml filter configuration to include spring security
 * This class extends the WebSecurityConfigurerAdapter which Provides a convenient base class for creating a WebSecurityConfigurer instance. The implementation allows customization by overriding methods.
 * We also override the configure method to force the user to go to the login page (this is spring defined) if the user is not authenticated or logged out
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)throws Exception {
		auth.inMemoryAuthentication().withUser("amine89").password("dehmani89").roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/", "/*todo*/**").access("hasRole('USER')").and().formLogin();
	}
}