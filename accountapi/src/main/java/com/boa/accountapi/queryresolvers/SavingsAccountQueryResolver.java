package com.boa.accountapi.queryresolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.accountapi.models.CurrentAccount;
import com.boa.accountapi.models.SavingsAccount;
import com.boa.accountapi.services.SavingsService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
@Component
public class SavingsAccountQueryResolver implements GraphQLQueryResolver {
    @Autowired 
	private SavingsService savingsService;
	
	public List<SavingsAccount> findAllSavingsAccount(){
	   return this.savingsService.viewAllSavingsAccounts();	
	}
	
	public SavingsAccount findSavingsAccount(long accountNo) {
		return this.savingsService.viewSavingsAccountByAccountNo(accountNo);
	}
	
}
