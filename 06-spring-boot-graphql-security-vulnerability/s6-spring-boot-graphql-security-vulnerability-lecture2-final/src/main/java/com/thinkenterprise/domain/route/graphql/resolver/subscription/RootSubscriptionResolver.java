package com.thinkenterprise.domain.route.graphql.resolver.subscription;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thinkenterprise.domain.route.graphql.publisher.RouteSubscriptionNotifier;
import com.thinkenterprise.domain.route.model.jpa.Route;

import graphql.kickstart.tools.GraphQLSubscriptionResolver;

/**  
* GraphQL Spring Boot Training 
* Design and Development by Michael Schäfer 
* Copyright (c) 2021 
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

@Component
public class RootSubscriptionResolver implements GraphQLSubscriptionResolver {


	private RouteSubscriptionNotifier routeSubscriptionNotifier;

	@Autowired
	public RootSubscriptionResolver(RouteSubscriptionNotifier routeUpdatePublisher) {
		this.routeSubscriptionNotifier = routeUpdatePublisher;
	}

	public Publisher<Route> registerRouteCreated() {
		return routeSubscriptionNotifier.getPublisher();
	}

}