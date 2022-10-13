package com.boa.accountapi.services;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.boa.accountapi.facade.AccountFacade;
import com.boa.accountapi.payloads.MessageWrapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountSubscriber {


	@StreamListener(target = AccountFacade.inChannelName)
    public void handlePayment(@Payload MessageWrapper messageWrapper) {
     log.info("invoked.....");   
	 log.info("Received Account details: {}",messageWrapper);
	
    }
	
	

}
