package sort;


import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        int numOfThread = Runtime.getRuntime().availableProcessors();
//        System.out.println(numOfThread);
        int[] nums1 = createArray(500000);
        int[] nums2 = Arrays.copyOf(nums1,nums1.length);
//        System.out.println(Arrays.toString(nums1));

        //Parallel merge sort
        ParallelMergeSort parallelMergeSort = new ParallelMergeSort(nums1);
        long startTime = System.currentTimeMillis();
        parallelMergeSort.mergeSort(0,nums1.length-1,numOfThread);
        long endTime = System.currentTimeMillis();
        System.out.println("Time take with parallel : "+ (endTime-startTime) + " ms");
//        System.out.println(Arrays.toString(nums1));

        //sequential merge sort

        MergeSort mergeSort = new MergeSort(nums2);
         startTime = System.currentTimeMillis();
        mergeSort.sort();
         endTime = System.currentTimeMillis();
        System.out.println("Time take with sequential : "+ (endTime-startTime) + " ms");

    }
    private static int[] createArray(int n){
        int[] a = new int[n];
        Random random = new Random();
        for (int i=0;i<n;i++){
            a[i] = random.nextInt(n);

        }
        return a;
    }
}
