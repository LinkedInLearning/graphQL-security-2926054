package com.thinkenterprise.domain.employee.model.jpa;

import javax.persistence.Entity;

/**  
* GraphQL Spring Boot Training 
* Design and Development by Michael Schäfer 
* Copyright (c) 2021 
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

@Entity
public class Attendant extends Employee {

    private int rank;

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}


}