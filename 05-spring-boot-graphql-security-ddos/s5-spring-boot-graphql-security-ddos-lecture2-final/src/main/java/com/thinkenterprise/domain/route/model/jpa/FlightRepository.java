package com.thinkenterprise.domain.route.model.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**  
* GraphQL Spring Boot Training 
* Design and Development by Michael Schäfer 
* Copyright (c) 2021 
* All Rights Reserved.
* 
* @author Michael Schäfer
*/



public interface FlightRepository extends CrudRepository<Flight, Long> {
		
	@Query( "select f from Flight f where f.route = :route")
	List<Flight> findByRoute(@Param("route") Route route);
	
	@Query( "select f from Flight f where id in :keys" )
	List<Flight> findAllById(@Param("keys") List<Long> keys);
	
	@Query( "select f.id from Flight f where f.route = :route")
	List<Long> findIdsByRoute(@Param("route") Route route);

}
