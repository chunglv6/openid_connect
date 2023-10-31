package MergesortForkJoin;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class MergeSort extends RecursiveAction {

    private int[] nums;

    public MergeSort(int[] nums) {
        this.nums = nums;
    }

    @Override
    protected void compute() {

        if (nums.length <= 10) {
            mergeSort(nums);
            return;
        }

        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        mergeSort(left);
        mergeSort(right);
        MergeSort task1 = new MergeSort(left);
        MergeSort task2 = new MergeSort(right);
        invokeAll(task1, task2);

        merge(left, right, nums);


    }

    private void merge(int[] left, int[] right, int[] nums) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                nums[k] = left[i];
                i++;

            } else {
                nums[k] = left[j];
                j++;

            }
            k++;
        }
        while (i < left.length){
            nums[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length){
            nums[k] = right[j];
            j++;
            k++;
        }
    }

    private void mergeSort(int[] nums) {
        if (nums.length <= 1)
            return;

        int middleIndex = nums.length / 2;

        int[] left = Arrays.copyOfRange(nums, 0, middleIndex);
        int[] right = Arrays.copyOfRange(nums, middleIndex, nums.length);

        mergeSort(left);
        mergeSort(right);

        merge(left, right, nums);
    }
}
