package com.thinkenterprise.domain.route.model.jpa;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.thinkenterprise.domain.employee.model.jpa.Employee;
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
public class Flight extends AbstractEntity {

	private double price;
	private LocalDate date;
	
	@Transient
	private Float discount;

	@ManyToOne
	private Route route;

	@OneToMany(mappedBy="flight",cascade=CascadeType.REMOVE)
	private Set<Employee> employees;

	public Flight() {
		super();
	}
	
	public Flight(double price, LocalDate date) {
		super();
		this.price = price;
		this.date = date;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
	
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

}
