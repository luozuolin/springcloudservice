package com.example.provideruser.springcloud8;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = DemoRestController.class)
public class DemoRestControllerAdvice {
    @ExceptionHandler(RuntimeException.class)
    public Object  faultToleranceRuntime(Throwable throwable){
        return throwable.getMessage();
    }
}
