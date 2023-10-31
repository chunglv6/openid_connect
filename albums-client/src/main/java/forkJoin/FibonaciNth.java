package forkJoin;

import java.util.concurrent.RecursiveTask;

public class FibonaciNth extends RecursiveTask<Integer> {
    private int n;
    private int fn;

    public FibonaciNth(int n) {
        this.n = n;
        fn = 0;
    }

    @Override
    protected Integer compute() {
        if(n <=2){
            return 1;
        }else {
            FibonaciNth f1 = new FibonaciNth(n-1);
            FibonaciNth f2 = new FibonaciNth(n-2);
            f1.fork();
            f2.fork();
            fn += f1.join();
            fn += f2.join();
        }
        return fn;
    }
}
