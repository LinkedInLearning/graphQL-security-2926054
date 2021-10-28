package com.thinkenterprise.domain.model.jpa;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**  
* GraphQL Spring Boot Training 
* Design and Development by Michael Schäfer 
* Copyright (c) 2021 
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

@MappedSuperclass
public class AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

