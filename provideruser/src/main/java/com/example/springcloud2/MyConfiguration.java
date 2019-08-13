package com.example.springcloud2;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

public class MyConfiguration implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        //从ConfigurableApplicationContext 获取ConfigurableEnvironment实例
       ConfigurableEnvironment environment= applicationContext.getEnvironment();
       //从ConfigurableEnvironment 获取MutablePropertySources
        MutablePropertySources propertySources=environment.getPropertySources();
        //定义一个新的，并且放置在首位
        propertySources.addFirst(createPropertySource());
    }
    private PropertySource createPropertySource(){
        Map<String,Object> source=new HashMap<>();
        source.put("name","springcloud2");
        PropertySource propertySource=new MapPropertySource("my-property-source",source);
        return propertySource;
    }
}
