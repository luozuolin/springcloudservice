package com.example.provideruser;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class UserController {
    @RequestMapping(value = "/hello/{name}",method = RequestMethod.GET)
    public ResponseEntity<String> hello(@PathVariable("name") String name)
    {
        return new ResponseEntity<String>("hello rest service"+name, HttpStatus.OK);
    }
}
