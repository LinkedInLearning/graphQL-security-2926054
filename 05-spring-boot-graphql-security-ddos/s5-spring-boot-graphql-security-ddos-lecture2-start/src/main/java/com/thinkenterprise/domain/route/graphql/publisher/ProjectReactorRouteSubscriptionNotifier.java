	package com.thinkenterprise.domain.route.graphql.publisher;

import org.reactivestreams.Publisher;

import com.thinkenterprise.domain.route.model.jpa.Route;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

/**  
* GraphQL Spring Boot Training 
* Design and Development by Michael Schäfer 
* Copyright (c) 2020 
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

public class ProjectReactorRouteSubscriptionNotifier implements RouteSubscriptionNotifier {
	
	private Flux<Route> publisher;
	private FluxSink<Route> emitter;
	
	public ProjectReactorRouteSubscriptionNotifier() {
		
		Flux<Route> createdPublisher = Flux.create(emitter -> {
			this.emitter=emitter;
		}, FluxSink.OverflowStrategy.BUFFER);
		
		ConnectableFlux<Route> connectableFlux = createdPublisher.share().publish();
		connectableFlux.connect();

		publisher = Flux.from(connectableFlux);
	}
	
	@Override
	public void emit(Route route) {
		emitter.next(route);
	}

	@Override
	public Publisher<Route> getPublisher() {
		return publisher;
	}

}
