package com.mudra.albums;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

class ReadTask implements Runnable{

    private List<Integer> list;

    public ReadTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(list);
        }

    }
}


class WriteTask implements Runnable{

    private List<Integer> list;

    public WriteTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {

        while (true){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.set(1, list.get(1)+1);
            System.out.println(list);
        }
    }
}
public class CopyAndWriteArrayExample {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.addAll(Arrays.asList(0,0,0,0,0));
        Thread t1 = new Thread(new WriteTask(list));
        Thread t2 = new Thread(new WriteTask(list));
//        Thread t3 = new Thread(new WriteTask(list));
//        Thread t4 = new Thread(new ReadTask(list));
        t1.start();
        t2.start();
//        t3.start();
//        t4.start();
    }
}
