package com.example.providerconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProviderconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderconsumerApplication.class, args);
	}

	@Bean
	public RestTemplate  restTemplate()
	{
		return   new RestTemplate();
	}
}
