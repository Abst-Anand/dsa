package src.patterns.slidingwindow;

import java.util.Arrays;

public class Main {

    // Q1 Max sum of subarray of size k, only positive numbers
    static int maxSubarraySum(int[] arr, int k){
        int sum = 0;

        int currWindowSum = 0;
        for(int i=0; i<k; i++){
            currWindowSum += arr[i];
        }

        int i = 0;
        int j = k;

        while(j < arr.length){
            if(currWindowSum > sum){
                sum = currWindowSum;
            }
            currWindowSum += arr[j] - arr[i];
            i++;
            j++;
        }

        return sum;
    }

    // Q6. maximun subarray average, find the max average of subarray of size k and return it
    static double maxAvgSubArray(int[] nums, int k){
        int sum = 0;
        double max = Double.MIN_VALUE;

        for(int i=0; i<k; i++){
            sum += nums[i];
        }

        for(int i=k; i<nums.length; i++){
            if(sum > max){
                max = sum;
            }
            sum += nums[i];
            sum -= nums[i - k];
        }

        return max/k;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 5, 1, 3, 2};
        Arrays.sort(arr1);
        int k1 = 3;
        System.out.println(maxSubarraySum(arr1, k1));

        int[] arr6 = {1,2,5,6,-7,-2};
        int k6 = 3;
        System.out.println(maxAvgSubArray(arr6, k6));

    }
}
