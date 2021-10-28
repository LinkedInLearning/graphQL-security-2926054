package com.thinkenterprise.domain.route.graphql.resolver.query;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import com.thinkenterprise.domain.route.model.jpa.Route;
import com.thinkenterprise.domain.route.model.jpa.RouteRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;


@Component
@Profile("oauth2")
public class RootQueryResolverOAuth2 implements GraphQLQueryResolver {

	protected static Logger log = LoggerFactory.getLogger(RootQueryResolverOAuth2.class);

	private RouteRepository routeRepository;

	@Autowired
	public RootQueryResolverOAuth2(RouteRepository routeRepository) {
		this.routeRepository = routeRepository;
	}

	
	@PreAuthorize("hasAuthority('SCOPE_read')")
	public Optional<Route> route(String flightNumber) {
		return routeRepository.findByFlightNumber(flightNumber); 	                                           
	}
	
	@PreAuthorize("hasAuthority('SCOPE_read')")
	public List<Route> routes(int page, int size, DataFetchingEnvironment dataFetchingEnvironment) throws InterruptedException  {
				
		Pageable pageable = PageRequest.of(page, size);

		Page<Route> pageResult = routeRepository.findAll(pageable);
		
		return  pageResult.toList(); 	
	}
	
	
}
