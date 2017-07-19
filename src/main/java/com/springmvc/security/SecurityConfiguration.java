package com.springmvc.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.users.UserInfo;

/**
 * @author Amine
 * This class is defined with conjunction of web.xml filter configuration to include spring security
 * This class extends the WebSecurityConfigurerAdapter which Provides a convenient base class for creating a WebSecurityConfigurer instance. The implementation allows customization by overriding methods.
 * We also override the configure method to force the user to go to the login page (this is spring defined) if the user is not authenticated or logged out
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	/**
	 * @return driverManagerDataSource
	 * this should be a bean lease move?!?!?!?!?!?!
	 */
	public DriverManagerDataSource getDataSource() {
	     DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	     driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	     driverManagerDataSource.setUrl("jdbc:mysql://localhost/EDW");
	     driverManagerDataSource.setUsername("amine89");
	     driverManagerDataSource.setPassword("dehmani89");
	     return driverManagerDataSource;
	 } 
	
	/**
	 * 
	 * @return principal (which is the user name that is logged in)
	 */
	@Autowired
	public static String retrieveLoggedinUserName() {
		System.out.println("inside retrieveLoggedinUserName() Method in the Security controller");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails){
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();		
	}
	
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)throws Exception {		
		String usersQuery 		= "select username,password, enabled from users where username=?";
		String usersAuthority 	= "select username, role from user_roles where username=?";
		//method below is using jdbc authontication method to check if user exists.
		auth.jdbcAuthentication().dataSource(getDataSource()).usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(usersAuthority);
		
		//method below is using jdbc authontication method to check if user exists.
		//auth.inMemoryAuthentication().withUser("amine89").password("dehmani89").roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("You Are here");
		System.out.println("You Are here");
		System.out.println("You Are here");
		System.out.println("You Are here");
		http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/", "/*todo*/**").access("hasRole('USER')").and().formLogin();
		//http.authorizeRequests().antMatchers("/loginDisabled").permitAll().antMatchers("/", "/*todo*/**").access("hasRole('USER')").and().formLogin();
		
	}
}