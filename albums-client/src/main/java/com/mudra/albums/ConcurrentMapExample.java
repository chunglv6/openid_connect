package com.mudra.albums;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class ConcurrentMapFirst implements Runnable{

    private ConcurrentMap<String,Integer> map;

    public ConcurrentMapFirst(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            map.put("A",12);
            Thread.sleep(2000);
            map.put("B",10);
            map.put("C",18);
            Thread.sleep(2000);
            map.put("D",100);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}


class ConcurrentMapSecond implements Runnable{

    private ConcurrentMap<String,Integer> map;

    public ConcurrentMapSecond(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            map.entrySet().stream().forEach(entry-> System.out.println("key : "+entry.getKey()+" value : "+entry.getValue()));
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}

public class ConcurrentMapExample {
    public static void main(String[] args) {
        ConcurrentMap<String,Integer> map = new ConcurrentHashMap<>();
        new Thread(new ConcurrentMapFirst(map)).start();
        new Thread(new ConcurrentMapSecond(map)).start();
    }
}
