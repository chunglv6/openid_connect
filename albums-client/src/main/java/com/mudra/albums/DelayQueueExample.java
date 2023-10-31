package com.mudra.albums;

import java.util.concurrent.*;

class DelayWorker implements Delayed{

    private long duration;
    private String message;
    DelayWorker(String message, long duration){
        this.message = message;
        this.duration = System.currentTimeMillis() + duration;
    }

    @Override
    public String toString() {
        return "DelayWorker{" +
                "duration=" + duration +
                ", message='" + message + '\'' +
                '}' +" "+Thread.currentThread().getName();
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.duration- System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if(this.duration < ((DelayWorker) o).getDuration()){
            return -1;
        }else if (this.duration > ((DelayWorker) o).getDuration()){
            return 1;
        }
        return 0;
    }
}

public class DelayQueueExample {
    public static void main(String[] args) {
        BlockingQueue<DelayWorker> queue = new DelayQueue<>();
        try {
            queue.put(new DelayWorker("this is the first message ...",1000));
            queue.put(new DelayWorker("this is the first message ...",2000));
            queue.put(new DelayWorker("this is the first message ...",3000));
            queue.put(new DelayWorker("this is the first message ...",4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (!queue.isEmpty()){
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
