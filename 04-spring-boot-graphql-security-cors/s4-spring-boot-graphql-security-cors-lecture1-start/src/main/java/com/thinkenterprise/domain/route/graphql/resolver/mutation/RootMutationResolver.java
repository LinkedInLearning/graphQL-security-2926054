package com.thinkenterprise.domain.route.graphql.resolver.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thinkenterprise.domain.route.graphql.publisher.RouteSubscriptionNotifier;
import com.thinkenterprise.domain.route.model.jpa.Route;
import com.thinkenterprise.domain.route.model.jpa.RouteRepository;

import graphql.kickstart.tools.GraphQLMutationResolver;

/**  
* GraphQL Spring Boot Training 
* Design and Development by Michael Schäfer 
* Copyright (c) 2020 
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

@Component
public class RootMutationResolver implements GraphQLMutationResolver {
	

    private RouteRepository routeRepository;
    private RouteSubscriptionNotifier projectReactorRouteSubscriptionNotifier;


    @Autowired
    public RootMutationResolver(RouteRepository routeRepository, 
    							RouteSubscriptionNotifier projectReactorRouteSubscriptionNotifier) {
    	this.projectReactorRouteSubscriptionNotifier=projectReactorRouteSubscriptionNotifier;
        this.routeRepository=routeRepository;	 
    }
 
 
    public Route createRoute(String flightNumber) {
    	Route route = new Route(flightNumber);
        routeRepository.save(route);
        projectReactorRouteSubscriptionNotifier.emit(route);
        return route; 
    }

    public Route updateRoute(Long id, String departure) {
 		Route route = routeRepository.findById(id).get();
 		route.setDeparture(departure);
 		routeRepository.save(route);
 		return route;
 	}
    
    public Route updateRouteWithRouteInput(Long id, RouteInput routeInput) {
        Route route = routeRepository.findById(id).get();
        route.setDeparture(routeInput.getDeparture());
        route.setDestination(routeInput.getDestination());
        routeRepository.save(route);      
        return route;
    }
    
    public Boolean isDeleteRoute(Long id) {
        routeRepository.deleteById(id);
        return true;
    }
    

}