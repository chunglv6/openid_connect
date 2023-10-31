package com.mudra.albums;


import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BarrierWorker implements Runnable {

    private int id;
    private CyclicBarrier cyclicBarrier;
    private Random random;

    BarrierWorker(int id, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.random = new Random();
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Thread with Id " + this.id + " is starting ..");
        try {
            Thread.sleep(this.random.nextInt(3000));
            this.cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("after await() ....");

    }
}

public class BarrierExample {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("all tasks are finished ..");
            }
        });
        for(int i=0;i<5;i++){
            es.execute(new BarrierWorker(i+1,barrier));
        }
        es.shutdown();
    }
}
