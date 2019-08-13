package com.example.provideruser;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UserController {
    @RequestMapping(value = "/hello/{name}",method = RequestMethod.GET)
    public ResponseEntity<String> hello(@PathVariable("name") String name)
    {
        return new ResponseEntity<String>("hello rest service"+name, HttpStatus.OK);
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public void hello()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println("hello:"+df.format(new Date()));// new Date()为获取当前系统时间
        //System.out.println("hello"+);
    }
}
