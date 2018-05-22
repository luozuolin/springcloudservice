package com.example.consumerribbon;

import com.netflix.discovery.converters.Auto;
import jdk.nashorn.internal.runtime.logging.Loggable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    private  static final Logger LOGGER= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/consumer/hello/{name}")
    public String gethello(@PathVariable String name)
    {
        System.out.println("consumer/hello/name:"+name);
        return "ConsumerController:"+this.restTemplate.getForObject("http://microservice-provider-user/hello/"+name,String.class);
    }
    @GetMapping("/log-instance")
    public void logHelloInstance()
    {
        ServiceInstance serviceInstance=this.loadBalancerClient.choose("microservice-provider-user");
        UserController.LOGGER.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }


}
