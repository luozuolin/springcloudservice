package com.example.springcloud1;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/***
 * spring事件
 */
public class SpringEventListenerDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.addApplicationListener(new MyApplicationListener());
        annotationConfigApplicationContext.refresh();
        annotationConfigApplicationContext.publishEvent(new MyApplicationEvent("1"));
        annotationConfigApplicationContext.publishEvent(new MyApplicationEvent("hello world"));


    }
    public  static  class  MyApplicationEvent extends ApplicationEvent{
        /**
         * Create a new ApplicationEvent.
         *
         * @param source the object on which the event initially occurred (never {@code null})
         */
        public MyApplicationEvent(Object source) {
            super(source);
        }
    }
    public static class MyApplicationListener implements ApplicationListener<MyApplicationEvent>{
        @Override
        public void onApplicationEvent(MyApplicationEvent event) {
            System.out.println("receive myssage:"+event.getSource().toString());
        }
    }
}
