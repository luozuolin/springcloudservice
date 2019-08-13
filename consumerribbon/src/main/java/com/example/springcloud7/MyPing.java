package com.example.springcloud7;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
/***
 * 检查对象/health是否正常
 * 积累Javase，javaee的规范和技术
 */
public class MyPing implements IPing {
    @Override
    public boolean isAlive(Server server) {
        String  host=server.getHost();
        int port=server.getPort();
        String  url="http://"+host+":"+port+"/actuator/health";
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity responseEntity=restTemplate.getForEntity(url,String.class);
        return HttpStatus.OK.equals(responseEntity.getStatusCode());
    }
}
