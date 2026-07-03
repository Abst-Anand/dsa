package src.patterns.slidingwindow;

public class Main {

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

        int[] arr6 = {1,2,5,6,-7,-2};
        int k6 = 3;
        System.out.println(maxAvgSubArray(arr6, k6));

    }
}
