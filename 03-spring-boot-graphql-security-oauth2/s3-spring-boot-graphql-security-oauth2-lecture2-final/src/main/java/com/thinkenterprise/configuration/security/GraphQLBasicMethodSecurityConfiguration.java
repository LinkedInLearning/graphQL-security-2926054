package com.thinkenterprise.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

 
@Configuration
@Profile("basicAuth")
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class GraphQLBasicMethodSecurityConfiguration extends GlobalMethodSecurityConfiguration  {
         
}