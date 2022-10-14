package com.boa.customerapi.services;

import java.util.List;

import com.boa.customerapi.models.Individual;

public interface IndividualService {
	
	Individual addIndividual(Individual individual);
	Individual updateIndividual(long customerId, String email, long contactNumber);
	List<Individual> viewAllIndividuals();
	Individual viewIndividualById(long customerId);
	boolean deleteIndividualById(long customerId);
	

}
