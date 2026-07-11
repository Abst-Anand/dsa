package src.patterns.slidingwindow;

import java.util.Arrays;

public class Main {

    // Q1 Max sum of subarray of size k
    static int maxSubarraySumBrute(int[] arr, int k){
        int sum = Integer.MIN_VALUE;

        for(int i=0; i<=arr.length-k; i++){
            int currentWindowSum = 0;
            for(int j=i; j<i+k; j++){
                currentWindowSum += arr[j];
            }

            sum = Math.max(sum, currentWindowSum);
        }

        return sum;
    }
    static int maxSubarraySumOptimised(int[] arr, int k){
        int sum = Integer.MIN_VALUE;
        int i=0, j=0;
        int currSum=0;

        while(j<arr.length){
            currSum += arr[j];

            if( (j-i+1) == k){
                sum = Math.max(currSum, sum);
                currSum -= arr[i];
                i++;
            }
            j++;
        }

        return sum;
    }

    // Q1.1 Max sum of subarray of size k, only positive numbers
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

    // Q6.1 maximun subarray average, find the max average of subarray of size k and return it
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
        int k1 = 3;

        int res1 = maxSubarraySumBrute(arr1, k1);
        System.out.println(res1);

        int res11 = maxSubarraySumOptimised(arr1, k1);
        System.out.println(res11);

        int[] arr6 = {1,2,5,6,-7,-2};
        int k6 = 3;
        System.out.println(maxAvgSubArray(arr6, k6));

    }
}
