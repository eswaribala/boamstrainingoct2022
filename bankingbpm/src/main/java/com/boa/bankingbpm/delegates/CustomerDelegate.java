package com.boa.bankingbpm.delegates;

import java.net.ConnectException;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
@Component("customerdelegate")
@Slf4j
public class CustomerDelegate implements JavaDelegate {
    @Autowired 
	private RestTemplate restTemplate;
	@Value("${url}")
    private String url;
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		log.info("Account No"+execution.getVariable("accountNo"));
		long accountNo=Long.parseLong(execution.getVariable("accountNo").toString());
		try {
		ResponseEntity<String> responseEntityStr = restTemplate.
			       exchange(url+accountNo,HttpMethod.GET, null,
					  String.class); 
		log.info(responseEntityStr.toString());
		
		 if(responseEntityStr.toString().contains("Data Published"))
			   execution.setVariable("status", true);
			 else
				 execution.setVariable("status", false); 
		}
		catch(Exception ex) {
			
				execution.setVariable("status", false); 
			
			
		}
		 
		
		 
	}

}
