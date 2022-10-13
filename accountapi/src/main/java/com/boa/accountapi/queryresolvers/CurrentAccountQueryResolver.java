package com.boa.accountapi.queryresolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.accountapi.models.CurrentAccount;
import com.boa.accountapi.models.CurrentAccount;
import com.boa.accountapi.services.CurrentService;
import com.boa.accountapi.services.CurrentService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
@Component
public class CurrentAccountQueryResolver implements GraphQLQueryResolver {
	 @Autowired 
		private CurrentService CurrentService;
		
		public List<CurrentAccount> findAllCurrentAccounts(){
		   return this.CurrentService.viewAllCurrentAccounts();	
		}
		
		public CurrentAccount findCurrentAccount(long accountNo) {
			return this.CurrentService.viewCurrentAccountByAccountNo(accountNo);
		}
	
}
