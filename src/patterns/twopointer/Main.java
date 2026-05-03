package src.patterns.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    // remove all non-alphanumerics and then check if its a palindrome
    static boolean validPalindrome(String str){
        System.out.println("Q1");

        int left = 0,
            right = str.length() - 1;

        while(left<right){
            char l = str.charAt(left);
            char r = str.charAt(right);

            if(!Character.isLetterOrDigit(l)){
                left++;
                continue;
            }

            if(!Character.isLetterOrDigit(r)){
                right--;
                continue;
            }

            if(Character.toLowerCase(l) != Character.toLowerCase(r)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // reverse char array in-place(no extra space)
    static void reverseStringInPlace(char[] srr){
        System.out.println("Q2");

        int lo = 0;
        int hi = srr.length-1;

        while(lo < hi){
            char temp = srr[lo];
            srr[lo] = srr[hi];
            srr[hi] = temp;

            lo++;
            hi--;
        }
    }

    // squares of a sorted array to sorted array
    static int[] sortedSquares(int[] nums){
        System.out.println("Q3");

        int[] res = new int[nums.length];
        int idx = nums.length - 1;
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi){
            int leftSqr = nums[lo] * nums[lo];
            int rightSqr = nums[hi] * nums[hi];

            if(leftSqr > rightSqr){
                res[idx--] = leftSqr;
                lo++;
            } else {
                res[idx--] = rightSqr;
                hi--;
            }

        }
        return res;
    }

    // valid palindrome with 1 delete allowed
    static boolean validPalindrome2(String str){
        System.out.println("Q4");

        int lo = 0;
        int hi = str.length() - 1;

        while(lo < hi){
            char leftChar = str.charAt(lo);
            char rightChar = str.charAt(hi);

            // use the superpower to delete a char and check if it makes the remaining string palindrome
            if(leftChar != rightChar){
                return palindrome2Helper(str, lo+1 , hi) || palindrome2Helper(str, lo, hi-1);
            }else {
                lo++;
                hi--;
            }
        }

        return true;
    }

    private static boolean palindrome2Helper(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // check whether the given abbreviation is a valid one for a given string, i.e: implementation ==> i12n is valid
    static boolean validateAbbreviation(String word, String abbr){
        System.out.println("Q5");
        int wordPointer = 0;
        int abbrPointer = 0;

        while (wordPointer != word.length() && abbrPointer != abbr.length()){
            char wordChar = word.charAt(wordPointer);
            char abbrChar = abbr.charAt(abbrPointer);

            if(Character.isDigit(abbrChar)){
                if(abbrChar == '0'){
                    return false;
                }

                // contruct the number from digits
                int number = 0;
                while (abbrPointer != abbr.length() && Character.isDigit(abbr.charAt(abbrPointer))){
                    number = number * 10 + (abbr.charAt(abbrPointer) - '0');
                    abbrPointer++;
                }

                wordPointer += number;
            }else{
                if(wordChar != abbrChar){
                    return false;
                }
                wordPointer++;
                abbrPointer++;
            }

        }

        return wordPointer == word.length() && abbrPointer == abbr.length();
    }

    // Q6: merge two sorted arrays in one
    static int[] mergeTwoSortedArrays(int[] nums1, int[] nums2){
        System.out.println("Q6");
        int[] res = new int[nums1.length + nums2.length];
        int idx = 0;
        int first = 0;
        int second = 0;

        while(first < nums1.length && second < nums2.length){
            if(nums1[first] <= nums2[second]){
                res[idx] = nums1[first];
                first++;
            }else{
                res[idx] = nums2[second];
                second++;
            }
            idx++;
        }

        // here it may happen that there are still elements left in either of the arrays
        while (first < nums1.length){
            res[idx] = nums1[first];
            idx++;
            first++;
        }

        while (second < nums2.length){
            res[idx] = nums2[second];
            idx++;
            second++;
        }

        return res;
    }

    // Q7: count pairs whose sum is lest than target
    static int countPairsWithSumLessThanTarget(int[] arr, int target){
        System.out.println("Q7");
        int count = 0;
        Arrays.sort(arr);
        int lo = 0;
        int hi = arr.length - 1;

        while(lo < hi){
            int sum = arr[lo] + arr[hi];
            if(sum < target){
                count += hi - lo;
                lo++;
            }else{
                hi--;
            }
        }
        return count;
    }

    // Q8: Two Sum= return the indices of two diff elements whose sum is equal to target
    static int[] twoSum(int[] arr, int target){
        System.out.println("Q8");
        int res[] = {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        // 3 2 4, t=6, ot=[1,2]
        for(int i=1; i<arr.length; i++){
            if(map.containsKey(target - arr[i])){
                res[0] = map.get(target  - arr[i]);
                res[1] = i;
                break; // no need to check further if pair found
            }else{
                map.put(arr[i], i);
            }
        }

        return res;
    }

    // Q9: Two Sum but the given array is sorted and we cant use extra space
    static int[] twoSumWithSortedArray(int[] arr, int target){
        System.out.println("Q9");
        int lo = 0;
        int hi = arr.length - 1;

        while(lo < hi){
            int sum = arr[lo] + arr[hi];
            if(sum < target){
                lo++;
            } else if( sum > target){
                hi--;
            }else{
                return new int[] {lo, hi};
            }
        }

        return new int[] {-1 , -1};
    }


    // Q14 : reverse words in a string (hello world => world hello)
    static String reverseWords(String s){
        System.out.println("Q14");
        String[] chunks = s.split(" ");

        int i = 0;
        int j = chunks.length - 1;

        while (i < j){
            String temp = chunks[i];
            chunks[i] = chunks[j];
            chunks[j] = temp;
            i++;
            j--;
        }

        return String.join(" ", chunks);
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(s.length());
        System.out.println(validPalindrome(s));

        String str = "12345";
        char[] c = str.toCharArray();
        reverseStringInPlace(c);
        System.out.println(c);

        int[] arr = {-4, 2, 15};
        int[] res = sortedSquares(arr);
        for(int i : res){
            System.out.print(i + " ");
        }
        System.out.println();

        String s4 = "abbxa";
        System.out.println(validPalindrome2(s4));

        String word = "implementation";
        String abbr = "i13n";
        System.out.println(validateAbbreviation(word, abbr));

        // Q6
        int[] nums1 = {1,3,5,7,9};
        int[] nums2 = {2,4,6,8,10,11,12};
        int[] merged = mergeTwoSortedArrays(nums1, nums2);
        for(int e : merged){
            System.out.print(e + " ");
        }
        System.out.println();

        //Q7
        int[] arr7 = {12, 3, 45, 7, -35};
        int target = 10;
        int count = countPairsWithSumLessThanTarget(arr7, target);
        System.out.println(count);

        // Q8
        int[] arr8 = {3,2,4,5,67,-9};
        target = -6;
        int[] res8 = twoSum(arr8, target);
        System.out.println(res8[0] + ", " + res8[1]);

        // Q9
        int[] arr9 = {1,2,4,5,6};
        target = 9;
        int[] res9 = twoSumWithSortedArray(arr9, target);
        System.out.println(res9[0] + ", " + res9[1]);

        //Q14
        String s14 = "Hello World";
        System.out.println(reverseWords(s14));
    }
}
