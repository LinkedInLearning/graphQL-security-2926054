package com.thinkenterprise.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Profile("basicAuth")
public class GraphQLBasicWebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    
      @Override
      protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests().anyRequest().authenticated()
            .and().httpBasic();   
      }
    
      @Override
      protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
    	  auth.inMemoryAuthentication()
            .withUser("user")
            .password(passwordEncoder().encode("user2021!"))
            .roles("USER");
        
        auth.inMemoryAuthentication()
        	.withUser("admin")
        	.password(passwordEncoder().encode("admin2021!"))
        	.roles("ADMIN");
            
      }
    
      @Bean
      PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
      }
      
}      