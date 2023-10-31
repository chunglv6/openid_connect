package app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService es = null;
        Philosopher[] philosophers = null;
        Chopstick[] chopsticks = null;
        try {
            philosophers = new Philosopher[Constant.NUM_OF_PHILOSOPHERS];
            chopsticks = new Chopstick[Constant.NUM_OF_CHOPSTICKS];
            for (int i=0;i<Constant.NUM_OF_CHOPSTICKS;i++){
                chopsticks[i] = new Chopstick(i);
            }
            es  = Executors.newFixedThreadPool(Constant.NUM_OF_PHILOSOPHERS);
            for (int i=0;i<Constant.NUM_OF_PHILOSOPHERS;i++){
                philosophers[i] = new Philosopher(i,chopsticks[i], chopsticks[(i+1)%Constant.NUM_OF_PHILOSOPHERS]);
                es.execute(philosophers[i]);
            }
            Thread.sleep(Constant.DURATION);
            es.shutdown();
            for (Philosopher philosopher: philosophers){
                philosopher.setFull(true);
            }
        }finally {
            es.shutdown();
            while (!es.isTerminated())
                Thread.sleep(1000);
            for (Philosopher philosopher: philosophers){
                System.out.println(philosopher + " eat #"+ philosopher.getEatingCounter()+" times!");
            }
        }
    }
}
