package com.mudra.albums;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    private int id;

    Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task with id "+this.id + " is in work - thread id : "+Thread.currentThread().getId());
        long duration = (long) (Math.random()*5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ExecutorExample {
    public static void main(String[] args) {
//        ExecutorService es = Executors.newFixedThreadPool(3);
//        for(int i=0;i<12;i++){
//            es.execute(new Task(i+1));
//        }
//        System.out.println(Thread.activeCount());

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(new Task(1),1000,5000,TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(new Task(2),1000,5000,TimeUnit.MILLISECONDS);
    }
}
