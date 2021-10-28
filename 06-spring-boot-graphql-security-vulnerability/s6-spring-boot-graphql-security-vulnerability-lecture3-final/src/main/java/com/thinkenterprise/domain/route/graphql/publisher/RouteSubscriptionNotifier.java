package com.thinkenterprise.domain.route.graphql.publisher;

import org.reactivestreams.Publisher;

import com.thinkenterprise.domain.route.model.jpa.Route;

/**  
* GraphQL Spring Boot Training 
* Design and Development by Michael Schäfer 
* Copyright (c) 2020 
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

public interface RouteSubscriptionNotifier {
	
	   public void emit(Route route);

	    public Publisher <Route> getPublisher();

}
