package com.springmvc.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:config.properties"),
	//@PropertySource("classpath:additional.properties")
})
public class MvcConfig {
	
	//1.2.3.4
	@Value("${mongodb.url}")
	private String mongodbUrl;

	//hello
	@Value("${mongodb.db}")
	private String defaultDb;
	
}