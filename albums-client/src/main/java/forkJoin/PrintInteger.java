package forkJoin;

import java.util.concurrent.RecursiveAction;

public class PrintInteger extends RecursiveAction {

    private int[] nums;
    private int low;
    private int high;

    public PrintInteger(int[] nums, int low, int high) {
        this.nums = nums;
        this.low = low;
        this.high = high;
    }

    @Override
    protected void compute() {
        if(low == high){
            printOut(nums,low,high);
        }else {
            int mid = (low + high)/2;
            PrintInteger printInteger1 = new PrintInteger(nums,low,mid);
            PrintInteger printInteger2 = new PrintInteger(nums,mid+1,high);
            invokeAll(printInteger1,printInteger2);
        }

    }

    private void printOut(int[] nums, int low, int high) {
        System.out.println(nums[low]);
    }
}
