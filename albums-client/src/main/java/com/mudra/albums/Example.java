package com.mudra.albums;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example {

    private static Lock lock1 = new ReentrantLock(true);
    private static Lock lock2 = new ReentrantLock(true);
    private static void worker1(){
        lock1.lock();
        System.out.println("worker1 acquires the lock1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock2.lock();
        System.out.println("worker1 acquires the lock2");
        lock1.unlock();
        lock2.unlock();
    }

    private static void worker2(){
        lock2.lock();
        System.out.println("worker2 acquires the lock2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock1.lock();
        System.out.println("worker2 acquires the lock1");
        lock1.unlock();
        lock2.unlock();
    }

    public static void main(String[] args) {
        Example ex = new Example();
        new Thread(Example::worker1,"woker1").start();
        new Thread(Example::worker2,"woker2").start();
    }
}
