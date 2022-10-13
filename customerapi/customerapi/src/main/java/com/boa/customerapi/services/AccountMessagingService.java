package com.boa.customerapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.boa.customerapi.facades.AccountFacade;
import com.boa.customerapi.payloads.MessageWrapper;

@Service
public class AccountMessagingService {
    @Autowired
	private AccountFacade accountFacade;
    
    public boolean publishAccountNo(long accountNo) {
    	MessageChannel messageChannel=accountFacade.publishAccountsChannel();
		if(accountNo>0) {
		return messageChannel.send(MessageBuilder
                .withPayload(new MessageWrapper("v1",String.valueOf(accountNo)))
                .setHeader(MessageHeaders.CONTENT_TYPE, 
                		MimeTypeUtils.APPLICATION_JSON)
                .build());
		}
		else
		{
			return false;
		}

    }
}
