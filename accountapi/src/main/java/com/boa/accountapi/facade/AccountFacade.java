package com.boa.accountapi.facade;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface AccountFacade {

	String inChannelName="account-in";
	@Input(inChannelName)
	MessageChannel subscribeAccountNo();
}
