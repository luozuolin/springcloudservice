package com.example.provideruser.springcloud8;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class DemoRestController {
    Random random=new Random();
    @GetMapping("/getHystrix")
    public String  getHystrix(){
        int data=random.nextInt(200);
        if(data>100){
            throw   new RuntimeException("Throw Exception :"+data);
        }else {
            return   "Hello Hystrix";
        }
    }
    @HystrixCommand(fallbackMethod ="fallback" ,commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "100")
    })
    @GetMapping("/getHystrix1")
    public String  getHystrix1() throws InterruptedException {
        int data=random.nextInt(200);
        System.out.println("休眠时间："+data+"ms");
        Thread.sleep(data);
       return "Hello Hystrix"+data;
    }
    public String  fallback(){
        return  "fallback";
    }
}
