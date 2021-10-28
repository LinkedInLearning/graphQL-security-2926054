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
public class Pilot extends Employee {

    String certificateNumber;

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber=certificateNumber;
    }

    public String getCertificateNumber() {
        return this.certificateNumber;
    }

}