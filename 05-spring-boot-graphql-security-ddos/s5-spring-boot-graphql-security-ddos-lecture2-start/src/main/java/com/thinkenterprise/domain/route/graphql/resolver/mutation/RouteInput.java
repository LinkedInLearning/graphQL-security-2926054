package com.thinkenterprise.domain.route.graphql.resolver.mutation;

/**  
* GraphQL Spring Boot Training 
* Design and Development by Michael Schäfer 
* Copyright (c) 2021 
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

public class RouteInput {
    
	
    String departure;
    String destination;
    
    public String getDeparture() {
        return this.departure;
    }

    public void setDeparture(String depature) {
        this.departure=depature;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination=destination;
    }
}