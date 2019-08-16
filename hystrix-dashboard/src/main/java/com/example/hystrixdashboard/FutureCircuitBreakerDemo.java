package com.example.hystrixdashboard;

import java.util.Random;
import java.util.concurrent.*;

public class FutureCircuitBreakerDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Command<String> command=new RandomCommand();
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Future<String> future=executorService.submit(command::run);
        String  result;
        try {
            result=future.get(100, TimeUnit.MILLISECONDS);
        }  catch (TimeoutException e) {
            result=command.fallback();
        }
        System.out.println(result);
        executorService.shutdown();

    }
    private  static  final Random randon=new Random();
    public static   class  RandomCommand implements  Command<String>{

        @Override
        public String run() throws InterruptedException {
            long executeTime=randon.nextInt(200);
            System.out.println("Execute Time :"+executeTime+" ms");
            Thread.sleep(executeTime);
            return "Hello,World";
        }

        @Override
        public String fallback() {
            return "fallback";
        }
    }
    public  interface  Command<T>{
        T run() throws InterruptedException;
        T fallback();
    }
}
