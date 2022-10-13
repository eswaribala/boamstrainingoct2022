package com.boa.accountapi.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class MessageWrapper<T> {
	private String version;
	private String message;
	private T payload;
	public MessageWrapper(String version, String message) {
		super();
		this.version = version;
		this.message = message;
	}
	public MessageWrapper(T payload) {
		super();
		this.payload = payload;
	}

	
}
