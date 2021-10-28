package com.thinkenterprise.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

 
@Configuration
@Profile("oauth2")
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class GraphQLOAuth2BasicMethodSecurityConfiguration extends GlobalMethodSecurityConfiguration  {
         
}