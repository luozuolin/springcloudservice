package com.example.consumerribbon;

import com.example.springcloud7.MyPing;
import com.netflix.loadbalancer.IPing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumerribbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerribbonApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate()
	{
		return   new RestTemplate();
	}

	@Bean
	public IPing iPing(){
		return new MyPing();
	}

}
