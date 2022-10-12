package com.boa.resilience4j.services;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@org.springframework.stereotype.Service
@Slf4j
public class Service {

    @Value("${serviceUrl}")
    String serviceUrl;

    @CircuitBreaker(name = "customerCircuitBreaker", 
    		fallbackMethod = "fallback")
    @Retry(name = "customerRetry")
    public String fetchData() {
        log.info(" Making a request to " + serviceUrl + " at :" 
    + LocalDateTime.now());

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(serviceUrl, String.class);
    }

    public String fallback(Exception e) {
        return "fallback value";
    }
}
