package com.boa.customerapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.boa.customerapi.models.Individual;
import com.boa.customerapi.repositories.IndividualRepository;
@Service
public class IndividualServiceImpl implements IndividualService{
	@Autowired
	private IndividualRepository individualRepository;

	@Override
	public Individual addIndividual(Individual individual) {
		// TODO Auto-generated method stub
		return individualRepository.save(individual);
	}

	@Override
	public Individual updateIndividual(long customerId, String email, long contactNumber) {
		// TODO Auto-generated method stub
		Individual individualObj=individualRepository.findById(customerId).orElse(null);
		if(individualObj!=null) {
			individualObj.setEmail(email);
			individualObj.setContactNumber(contactNumber);
		}
	  return individualRepository.save(individualObj);
	}

	@Override
	public List<Individual> viewAllIndividuals() {
		// TODO Auto-generated method stub
		return individualRepository.findAll();
	}

	@Override
	public Individual viewIndividualById(long customerId) {
		// TODO Auto-generated method stub
		return individualRepository.findById(customerId).orElse(null);
	}

	@Override
	public boolean deleteIndividualById(long customerId) {
		boolean status=false;
		// TODO Auto-generated method stub
		if(individualRepository.findById(customerId)!=null)
		{
			individualRepository.deleteById(customerId);
			status=true;
		}	
		return status;
	}
	


}
