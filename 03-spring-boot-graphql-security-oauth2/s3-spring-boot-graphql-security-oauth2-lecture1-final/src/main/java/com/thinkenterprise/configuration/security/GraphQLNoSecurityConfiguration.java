package com.thinkenterprise.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**  
* GraphQL Spring Boot Training 
* Design and Development by Michael Schäfer 
* Copyright (c) 2020 
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

@Configuration
@Profile("noSecurity")
public class GraphQLNoSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/h2-console/**").permitAll()
        .antMatchers("/graphql/**").permitAll();

		http.csrf().disable();
		http.headers().frameOptions().disable();
	} 
}