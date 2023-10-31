package forkJoin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class App {
    public static void main(String[] args) {
//        int[] list = createArray(10);
//        System.out.println(Arrays.toString(list));
//        ForkJoinPool pool = new ForkJoinPool();
//        PrintInteger action = new PrintInteger(list,0,list.length-1);
//        action.invoke();
        ForkJoinPool pool = new ForkJoinPool();
        FibonaciNth task = new FibonaciNth(11);
        Integer invoke = pool.invoke(task);
        System.out.println(invoke);

    }

    private  static int[] createArray(int n){
        int[] a = new int[n];
        Random random = new Random();
        for (int i=0;i<n;i++){
            a[i] = random.nextInt(n);
        }
        return a;
    }
}
