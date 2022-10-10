package com.boa.customerapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.boa.customerapi.models.Corporate;
import com.boa.customerapi.repositories.CorporateRepository;

public class CorporateServiceImpl implements CorporateService{
	@Autowired
	private CorporateRepository CorporateRepository;

	@Override
	public Corporate addCorporate(Corporate Corporate) {
		// TODO Auto-generated method stub
		return CorporateRepository.save(Corporate);
	}

	@Override
	public Corporate updateCorporate(long customerId, String email, long contactNumber) {
		// TODO Auto-generated method stub
		Corporate CorporateObj=CorporateRepository.findById(customerId).orElse(null);
		if(CorporateObj!=null) {
			CorporateObj.setEmail(email);
			CorporateObj.setContactNumber(contactNumber);
		}
	  return CorporateRepository.save(CorporateObj);
	}

	@Override
	public List<Corporate> viewAllCorporates() {
		// TODO Auto-generated method stub
		return CorporateRepository.findAll();
	}

	@Override
	public Corporate viewCorporateById(long customerId) {
		// TODO Auto-generated method stub
		return CorporateRepository.findById(customerId).orElse(null);
	}

	@Override
	public boolean deleteCorporateById(long customerId) {
		boolean status=false;
		// TODO Auto-generated method stub
		if(CorporateRepository.findById(customerId)!=null)
		{
			CorporateRepository.deleteById(customerId);
			status=true;
		}	
		return status;
	}
	


}
