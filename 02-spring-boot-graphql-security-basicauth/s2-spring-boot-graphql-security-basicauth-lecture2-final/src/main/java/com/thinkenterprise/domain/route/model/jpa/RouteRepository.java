
package com.thinkenterprise.domain.route.model.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


public interface RouteRepository extends CrudRepository<Route, Long>{
	
	Optional<Route> findByFlightNumber(String flightNumber);
	
	@Query("select r from Route r")
	List<Route> findAll();
	
	@Query( "select r from Route r where r.parent = :route")
	Route findByRoute(@Param("route") Route route);
	
	Page<Route> findAll(Pageable pageable);
	
	
}