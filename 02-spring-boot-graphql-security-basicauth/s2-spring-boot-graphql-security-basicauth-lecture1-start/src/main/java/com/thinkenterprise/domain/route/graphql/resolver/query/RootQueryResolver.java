package com.thinkenterprise.domain.route.graphql.resolver.query;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.thinkenterprise.domain.route.model.jpa.Route;
import com.thinkenterprise.domain.route.model.jpa.RouteRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;

/**
 * GraphQL Spring Boot Training Design and Development by Michael Schäfer
 * Copyright (c) 2021 All Rights Reserved.
 * 
 * @author Michael Schäfer
 */

@Component
public class RootQueryResolver implements GraphQLQueryResolver {

	protected static Logger log = LoggerFactory.getLogger(RootQueryResolver.class);

	private RouteRepository routeRepository;

	@Autowired
	public RootQueryResolver(RouteRepository routeRepository) {
		this.routeRepository = routeRepository;
	}

	
	public Optional<Route> route(String flightNumber) {
		return routeRepository.findByFlightNumber(flightNumber); 	                                           
	}
	
	
	public List<Route> routes(int page, int size, DataFetchingEnvironment dataFetchingEnvironment) throws InterruptedException  {
				
		Pageable pageable = PageRequest.of(page, size);

		Page<Route> pageResult = routeRepository.findAll(pageable);
		
		return  pageResult.toList(); 	
	}
	
	
}
