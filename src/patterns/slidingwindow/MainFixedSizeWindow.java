package src.patterns.slidingwindow;

import java.util.*;

public class MainFixedSizeWindow {

    // Q1: Maximum sum subarray of size k, find the max sum out of all possible subarrays of size k
    static int maxSumOfSubarrays(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;

        int i = 0, j = 0, currSum = 0;

        while (j < arr.length) {
            currSum += arr[j];

            if (j - i + 1 == k) {
                maxSum = Math.max(currSum, maxSum);
                currSum -= arr[i];
                i++;
            }
            j++;
        }

        return maxSum;
    }

    // Q2: First -ve num in each window of size k
    static void firstNegativeInEachWindow(int[] arr, int k) {
        for (int i = 0; i <= arr.length - k; i++) {
            int f = 0;
            for (int j = i; j < i + k; j++) {
                if (arr[j] < 0) {
                    f = 1;
                    System.out.print(arr[j] + " ");
                    break;
                }
            }
            if (f == 0)
                System.out.print(0);
        }
        System.out.println();
    }
    static void firstNegativeOptimised(int[] arr, int k) {
        // Optimised using sliding window
        int i = 0, j = 0;
        Queue<Integer> queue = new LinkedList<>();

        while (j < arr.length) {
            if (arr[j] < 0) {
                queue.offer(arr[j]);
            }

            if (j - i + 1 == k) {
                if (queue.isEmpty()) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(queue.peek() + " ");
                }

                if (arr[i] < 0) {
                    queue.remove();
                }
                i++;
            }
            j++;
        }

        System.out.println();
    }
    static void firstNegativeOptimisedAndIndexBased(int[] arr, int k) {
        int i = 0, j = 0;
        Queue<Integer> queue = new ArrayDeque<>();

        while (j < arr.length) {
            //calculation
            if (arr[j] < 0)
                queue.add(j);

            // window size hit
            if (j - i + 1 == k) {

                // ans
                if (queue.isEmpty()) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(arr[queue.peek()] + " ");
                }

                // shrink window
                if (!queue.isEmpty() && i == queue.peek()) {
                    queue.poll();
                }
                i++;
            }
            j++;
        }

        System.out.println();
    }

    // Q3: Find number of anagrams of @param pattern present in @param str
    static int findNumberOfAnagrams(String str, String pattern) {
        int count = 0;

        int windowSize = pattern.length();
        Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            int charFreq = freq.getOrDefault(pattern.charAt(i), 0);
            freq.put(pattern.charAt(i), charFreq + 1);
        }

        int distinctChars = freq.size();

        int i = 0, j = 0;

        while (j < str.length()) {
            Integer temp = freq.get(str.charAt(j));
            if (temp != null) {
                temp--;
                freq.put(str.charAt(j), temp);
                if (temp == 0)
                    distinctChars--;
            }

            if (j - i + 1 == windowSize) {
                if (distinctChars == 0) {
                    count++;
                }
                Integer removeTemp = freq.get(str.charAt(i));
                if (removeTemp != null) {
                    if (removeTemp == 0)
                        distinctChars++;
                    freq.put(str.charAt(i), removeTemp + 1);
                }
                i++;
            }
            j++;
        }

        return count;
    }

    // Q4: Find max in each subarray of size k
    static void maxInEachSubarray(int[] arr, int k){
        for(int i=0; i<=arr.length-k; i++){
            int currMax = Integer.MIN_VALUE;
            for(int j=i; j<i+k; j++){
                if(arr[j] > currMax){
                    currMax = arr[j];
                }
            }
            System.out.print(currMax + " ");
        }

        System.out.println();
    }
    static void maxInEachSubarrayOptimised(int[] arr, int k) {
        int i = 0, j = 0;

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        while (j < arr.length) {

            while (!queue.isEmpty() && arr[j] > queue.peekLast()) {
                queue.pollLast();
            }
            queue.addLast(arr[j]);


            if (j - i + 1 == k) {
                System.out.print(queue.peekFirst() + " ");

                if(arr[i] == queue.peekFirst()){
                    queue.pollFirst();
                }
                i++;
            }

            j++;
        }

        System.out.println();
    }

    public static void main(String[] args) {
//===================================================================
        System.out.println("+++Q1+++++++++++++++++++");
        int[] arr1 = {2, -5, 1, 8, 2, -9, 1};
        int k1 = 3;
        int res1 = maxSumOfSubarrays(arr1, k1);
        System.out.println(res1);
//===================================================================
        System.out.println("+++Q2+++++++++++++++++++");
        int[] arr2 = {12, -1, -7, 8, -15, 20, 16, 28};
        int k2 = 3;
        firstNegativeInEachWindow(arr2, k2);
        firstNegativeOptimised(arr2, k2);
        firstNegativeOptimisedAndIndexBased(arr2, k2);
//===================================================================
        System.out.println("+++Q3+++++++++++++++++++");
        String str = "abxuabcabcaby";
        String prt = "abc";
        int res = findNumberOfAnagrams(str, prt);
        System.out.println(res);
//===================================================================
        System.out.println("+++Q4+++++++++++++++++++");
        maxInEachSubarray(arr2, k2);
        maxInEachSubarrayOptimised(arr2, k2);
    }
}
