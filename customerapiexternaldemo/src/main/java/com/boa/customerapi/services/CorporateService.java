package com.boa.customerapi.services;

import java.util.List;

import com.boa.customerapi.models.Corporate;

public interface CorporateService {
	
	Corporate addCorporate(Corporate Corporate);
	Corporate updateCorporate(long customerId, String email, long contactNumber);
	List<Corporate> viewAllCorporates();
	Corporate viewCorporateById(long customerId);
	boolean deleteCorporateById(long customerId);
	

}
