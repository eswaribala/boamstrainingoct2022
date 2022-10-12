package com.boa.hystrix.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class CustomerHandler {

	@Autowired
	private RestTemplate restTemplate;

    @Value("${serviceUrl}")
	private String serviceUrl;
    @Value("${fallbackUrl}")
	private String fallbackUrl;

    @HystrixCommand(commandKey = "GetProductCommand", groupKey = "ProductGroupKey", threadPoolKey = "Test",
    		fallbackMethod = "requestFallBackHandler",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "110"),
                    @HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout", value = "false")
            },
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "30"),
                    @HystrixProperty(name = "maxQueueSize", value = "101"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
            })

	public ResponseEntity<String> requestHandler(){
		return restTemplate.exchange(serviceUrl+"/individuals/v1.0",
				HttpMethod.GET,null,String.class);

	}
	
	public ResponseEntity<String> requestFallBackHandler(){
		return restTemplate.exchange(fallbackUrl+"/individuals/v1.0",
				HttpMethod.GET,null,String.class);

	}
	
}
