package com.example.providerconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer/hello/{name}")
    public String gethello(@PathVariable String name)
    {
        System.out.println("consumer/hello/name:"+name);
        return "ConsumerController:"+this.restTemplate.getForObject("http://localhost:8000/hello/"+name,String.class);
    }
}
