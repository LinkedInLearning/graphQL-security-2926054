package com.thinkenterprise.domain.employee.model.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.thinkenterprise.domain.route.model.jpa.Flight;
import com.thinkenterprise.domain.route.model.jpa.Route;

/**  
* GraphQL Spring Boot Training 
* Design and Development by Michael Schäfer 
* Copyright (c) 20201
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	@Query("select e from Employee e")
	List<Employee> findAll();
	
	@Query( "select e from Employee e where e.flight = :flight")
	List<Employee> findByFlight(@Param("flight") Flight flight);
}
