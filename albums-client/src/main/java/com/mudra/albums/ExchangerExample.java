package com.mudra.albums;

import java.util.concurrent.Exchanger;

class First implements Runnable{

    private int counter = 0;
    private Exchanger<Integer> exchanger;

    public First(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true){
            counter++;
            System.out.println("First thread incremented counter : "+counter);
            try {
                counter = exchanger.exchange(counter);
                System.out.println("First thread get counter: "+counter);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Second implements Runnable{

    private int counter = 0;
    private Exchanger<Integer> exchanger;

    public Second(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true){
            counter--;
            System.out.println("Second thread incremented counter : "+counter);
            try {
                counter = exchanger.exchange(counter);
                System.out.println("Second thread get counter: "+counter);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Third implements Runnable{

    private int counter = 1000;
    private Exchanger<Integer> exchanger;

    public Third(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true){
            counter++;
            System.out.println("Third thread incremented counter : "+counter);
            try {
                counter = exchanger.exchange(counter);
                System.out.println("Third thread get counter: "+counter);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();
        new Thread(new First(exchanger)).start();
        new Thread(new Second(exchanger)).start();
        new Thread(new Third(exchanger)).start();
    }
}
