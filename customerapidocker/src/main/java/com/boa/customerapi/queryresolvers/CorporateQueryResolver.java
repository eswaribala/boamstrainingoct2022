package com.boa.customerapi.queryresolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.customerapi.models.Corporate;
import com.boa.customerapi.models.Individual;
import com.boa.customerapi.services.CorporateService;
import com.boa.customerapi.services.IndividualService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
@Component
public class CorporateQueryResolver implements GraphQLQueryResolver {
    @Autowired 
	private CorporateService corporateService;
	
	public List<Corporate> findAllCorporates(){
	   return this.corporateService.viewAllCorporates();	
	}
	
	public Corporate findCorporate(long customerId) {
		return this.corporateService.viewCorporateById(customerId);
	}
	
}
