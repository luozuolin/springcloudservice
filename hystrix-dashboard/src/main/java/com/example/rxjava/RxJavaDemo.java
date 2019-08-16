package com.example.rxjava;

import rx.Observable;
import rx.Single;
import rx.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;

public class RxJavaDemo {
    public static void main(String[] args) throws InterruptedException {

        //demoSingle();
        //demoObservable();
        demoStandard();
        System.out.println("主线程："+Thread.currentThread().getName());
    }
    private static  void demoStandard() throws InterruptedException {
        List<Integer> list= Arrays.asList(1,2,3);
        Observable.from(list).subscribeOn(Schedulers.computation())
                .subscribe(
                        value->{
                            if(value>2)
                                throw  new IllegalStateException("数据不允许大于2.");
                            System.out.println("消费数据："+value);
                        },e->{
                            System.out.println("发生异常："+e.getMessage());
                        },()->{
                            System.out.println("流程执行完成。");
                        }
                );
        Thread.sleep(100);
    }
    private static  void demoObservable() throws InterruptedException {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9);
        Observable.from(list).subscribeOn(Schedulers.computation())
                .subscribe(RxJavaDemo::println);
        Thread.sleep(100);
    }
    private static  void demoSingle(){
        Single.just("hello world")//发布单个数据
                .subscribeOn(Schedulers.io())
                .subscribe(RxJavaDemo::println);      //订阅消费数据
    }
    private static void println(Object value){
        System.out.printf("[线程：%s] 数据：%s\n",Thread.currentThread().getName(),value);
    }
}
