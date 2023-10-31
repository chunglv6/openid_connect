package sort;

import java.util.Arrays;

public class ParallelMergeSort {
    private int[] nums;
    private int[] tempArray;

    public ParallelMergeSort(int[] nums) {
        this.nums = nums;
        tempArray = new int[nums.length];
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void showArray(int[] nums) {

        System.out.println(Arrays.toString(nums));
    }

    public void sort() {
        mergeSort(0, nums.length - 1);
    }

    private void mergeSort(int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(low, mid);
        mergeSort(mid + 1, high);

        merge(low, mid, high);
    }

    private void merge(int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            tempArray[i] = nums[i];
        }

        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (tempArray[i] < tempArray[j]) {
                nums[k] = tempArray[i];
                ++i;
            } else {
                nums[k] = tempArray[j];
                ++j;
            }
            ++k;
        }
        while (i <= mid) {
            nums[k] = tempArray[i];
            ++i;
            ++k;
        }
        while (j <= high) {
            nums[k] = tempArray[j];
            ++j;
            ++k;
        }

    }

    public Thread createThread(int low, int high, int numOfThreads){
        return new Thread(new Runnable() {
            @Override
            public void run() {
                mergeSort(low, high, numOfThreads/2);
            }
        });
    }

    public void mergeSort(int low, int high, int numOfThreads) {
        if(numOfThreads <=1){
            mergeSort(low,high);
            return;
        }
        int mid = (low + high)/2;
        Thread leftSorter = createThread(low,mid,numOfThreads);
        Thread rightSorter = createThread(mid+1,high,numOfThreads);
        leftSorter.start();
        rightSorter.start();
        try {
            leftSorter.join();
            rightSorter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        merge(low,mid,high);

    }
}
