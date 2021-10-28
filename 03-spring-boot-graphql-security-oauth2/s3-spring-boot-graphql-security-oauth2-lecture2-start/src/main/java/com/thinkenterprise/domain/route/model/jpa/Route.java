package com.thinkenterprise.domain.route.model.jpa;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.thinkenterprise.domain.model.jpa.AbstractEntity;

/**  
* GraphQL Spring Boot Training 
* Design and Development by Michael Schäfer 
* Copyright (c) 2021 
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

@Entity
public class Route extends AbstractEntity {

	private String flightNumber;
	private String departure;
	private String destination;
	private Boolean isDisabled;

	@OneToOne
	private Route parent;

	@OneToMany(mappedBy = "route", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private Set<Flight> flights;

	public Route() {
		super();
	}

	public Route(String flightNumber) {
		super();
		this.flightNumber = flightNumber;
	}

	public Route(String flightNumber, String departure, String destination, Boolean isDisabled) {
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.departure = departure;
		this.isDisabled = isDisabled;
	}

	public void setDisabled(Boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	public Boolean getDisabled() {
		return this.isDisabled;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String number) {
		this.flightNumber = number;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}

	public void setParent(Route route) {
		this.parent = route;
	}

	public Route getParent() {
		return this.parent;
	}

}
