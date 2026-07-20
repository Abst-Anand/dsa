package src.pepcoding.dp;

import java.util.ArrayList;

public class Main {

    static ArrayList<Integer> dp1 = new ArrayList<>();

    // Q1: Fibonacci normal method and Memoised one (dp)
    static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
    static int fibMemoised(int n){
        if(n==0 || n==1){
            return n;
        }

        if(dp1.get(n-1) != 0){
            return dp1.get(n-1);
        }

        int fibnm1 = fibMemoised(n-1);
        int fibnm2 = fibMemoised(n-2);
        dp1.add(n-1, fibnm1+ fibnm2);
        return fibnm1 + fibnm2;
    }

    // Q2: Find all paths from nth stair to ground if three jumps of 1, 2, or 3 steps are pssble. Climbing Stairs Problem
    static int findPaths(int n){
        if(n==0){
            return 1;
        }
        if(n < 0){
            return 0;
        }

        int waysWith1Jump = findPaths(n-1);
        int waysWith2Jumps = findPaths(n-2);
        int waysWith3Jumps = findPaths(n-3);

        int totalWays = waysWith1Jump + waysWith2Jumps + waysWith3Jumps;
        return totalWays;
    }
    static int findPathsMemoised(int n, int[] dp){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        int waysWith1Jump = findPathsMemoised(n-1, dp);
        int waysWith2Jumps = findPathsMemoised(n-2, dp);
        int waysWith3Jumps = findPathsMemoised(n-3, dp);

        int totalWays = waysWith1Jump + waysWith2Jumps + waysWith3Jumps;
        dp[n] = totalWays;
        return totalWays;
    }
    static int findPathTabularised(int n){
        int[] dp = new int[n+1]; // storage and meaning (each cell will contain number of ways to reach ground from itself)
        // reaching ground from ground has 1 way, finding ways to top is complex so we will start from the simpler side
        // now that we are stating from start, so travel and sovle

        dp[0] = 1;

        for(int i=1; i<=n; i++){
            if(i>=3){
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
            if(i==2){
                dp[i] = dp[i-1] + dp[i-2];
            }
            if(i==1){
                dp[i] = dp[i-1];
            }
        }
        return dp[n];
    }

    // Q3: Climb stairs with variable number of jumps, here we need to reach the top
    // given another arr which implies the number of jumps allowed from i-th step
    static int findPathsVariableJump(int n, int[] arr){
        int[] dp = new int[n+1]; // storage and meaning(each cell will contain number of ways to reach top from itself)
                                 // reaching the last cell has 1 way => start from end (top) // direction
                                 // now that meaning, direction is set => travel and solve
        dp[n] = 1;

        for(int i=n-1; i>=0; i--){

            for(int j=1; j<=arr[i] && (i+j) < dp.length; j++){
                dp[i] +=  dp[i+j];
            }
        }
        for(int e: dp){
            System.out.print(e + " ");
        }
        System.out.println();
        return dp[0];
    }

    // Q4: Climb stairs with variable jumps but findTargetSumSubsets the minimum number of jumps required to reach the top from ground
    static int findPathWithMinimumJumps(int n, int[] arr){
        // storage and meaning
        Integer[] dp = new Integer[n+1]; // each cell will contain number of jumps to reach the top (n) from itself

        // direction: number of jumps from n is 0, because we are already at top when we are at n.
        // and we need to no. of jumps from 0 to n which is a bigger problem, so we will start from end of dp array, then travel and sovle.
        dp[n] = 0;

        // for each cell, we need to findTargetSumSubsets the minimum jumps in cells after it and add 1
        for(int i=n-1; i>=0; i--){
            int minSoFar = Integer.MAX_VALUE-1;
            for(int j=1; j<=arr[i] && (i+j < dp.length); j++){
                if(dp[i+j] != null && dp[i+j] < minSoFar){
                    minSoFar = dp[i+j];
                }
                dp[i] = 1 + minSoFar;
            }
        }

        for(Integer d: dp){
            System.out.print(d + " ");
        }
        System.out.println();
        return dp[0];
    }

    // Q5: Minimum cost path from left-top to right-bottom of a matrix

    // Q6: Goldmine, findTargetSumSubsets the max gold which can be extracted from a mine(matrix) where you can in prev, next, same row but always in next column
    static int maximumGoldFromMine(int[][] goldmine){
        int rows = goldmine.length;
        int cols = goldmine[0].length;

        int[][] dp = new int[rows][cols];
        for(int r=0; r<rows; r++){
            dp[r][cols-1] = goldmine[r][cols-1];
        }

        for(int j=cols-2; j>=0; j--){

            for(int i=0; i<rows; i++){

                int sameRowCandidate = dp[i][j+1]; // this candidate will always be there
                if(i==0){
                    int nextRowCandidate = dp[i+1][j+1];
                    dp[i][j] = goldmine[i][j] + Math.max(sameRowCandidate, nextRowCandidate);
                } else if(i==rows-1){
                    int previousRowCandidate = dp[i-1][j+1];
                    dp[i][j] = goldmine[i][j] + Math.max(sameRowCandidate, previousRowCandidate);
                } else{
                    int previousRowCandidate = dp[i-1][j+1];
                    int nextRowCandidate = dp[i+1][j+1];
                    dp[i][j] = goldmine[i][j] + Math.max(sameRowCandidate, Math.max(previousRowCandidate, nextRowCandidate));
                }
            }
        }

        // now findTargetSumSubsets the max in the first col and return it
        int max = dp[0][0];
        for(int i=1; i<rows; i++){
            if(dp[i][0] > max){
                max = dp[i][0];
            }
        }

        return max;
    }


    // Q7: Target Sum Subset, findTargetSumSubsets subsets (not subarrays) whose sum is equalt to target
    static void findTargetSumSubsets(int[] arr, int idx, int sum, int target, String ans, ArrayList<String> s){
        if(idx == arr.length){
//            System.out.println(ans); // here, ans will contain all the possible subsets one by one
            if(sum == target) {
                s.add(ans);
                System.out.println(ans);
            }
            return;
        }
        int f = arr[idx];
        findTargetSumSubsets(arr, idx+1, sum + f, target, ans +" " + f, s);
        findTargetSumSubsets(arr, idx +1, sum, target, ans + "", s);

    } // exponential
    static boolean findTargetSumSubsetsTabularized(int[] arr, int target){
        // task is to find if there is any subset of arr whose sum is equal to target
        // since in subsets, repetition is NOT allowed, so will are looking for COMBINATIONS not PERMUTATIONS
        // so the effect will be taken one by one each cell

        int n = arr.length;
        boolean[][] dp = new boolean[n+1][target+1];

        for(int i=0; i<=n; i++){

            for(int j=0; j<=target; j++){

                if(j==0){
                    dp[i][j] = true;
                }else if(i>0 && j>0){
                    int currentNum = arr[i-1];
                    if(j < currentNum){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = (dp[i-1][j-currentNum] || dp[i-1][j]);
                    }
                }

            }
        }

//        for(int i=0; i<=n; i++){
//            for(int j=0; j<=target; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        return dp[n][target];
    } // polynomail, O(n^2)

    // Q8: Coin Change Combination, given an array of coins(2,3,5) with infinite supply of each coin, find combinations in which you can pay a given target
    static int coinChangeCombination(int[] coins, int targetAmountToPay){
        // storage & meaning: a 1D array of size target+1 where indexes mean the targetAmount and values store number of ways to pay it
        // paying 0 has 1 way of paying
        // so smaller problem is on index 0, so start from left and travel, solve to right side

        int[] dp = new int[targetAmountToPay + 1];
        dp[0] = 1;

        // this is only to store possible conbinations of payments being made
        ArrayList<String>[] answers = new ArrayList[targetAmountToPay + 1];
        for(int i=0; i<=targetAmountToPay; i++){
            answers[i] = new ArrayList<String>();
        }
        answers[0].add("");

        // for each denomination (coin), try to pay using that amt, then dp[i] = dp[i] + dp[i-amt]
        for(int coin : coins){
            for(int amt=1; amt<=targetAmountToPay; amt++){
                if(amt >= coin){
                        dp[amt] += dp[amt - coin];
                        // extra work, only for insights
                        if(answers[amt-coin].size() > 0){
                            for(String s : answers[amt-coin]){
                                answers[amt].add(s + " " + coin);
                            }
                        }
                        // extra work end
                }
            }
        }

        for(ArrayList<String> ans : answers){
            System.out.println(ans);
        }
        System.out.println("Possible Combination of payment are: " + answers[targetAmountToPay]);

        return dp[targetAmountToPay];
    }



    // Q : Friends pairing problem
    static void findAllPossiblePairings(String str, int idx, String ans){

        if(idx == str.length()){
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(idx);

        findAllPossiblePairings(str, idx+1, ans + "");
        findAllPossiblePairings(str, idx+1, ans + " " + ch);
    }



    public static void main(String[] args) {
//=========================================================================================
        System.out.println("+++Q1+++++++++++++++++");
        for(int i=0; i<10; i++){
            dp1.add(0);
        }
        dp1.set(0, 0);
        dp1.set(1, 1);

        int n1 = 10;
        int res1 = fibMemoised(n1);
        System.out.println(res1);
//=========================================================================================
        System.out.println("+++Q2+++++++++++++++++");
        int n2 = 10;
        int res2 = findPathsMemoised(n2, new int[n2 + 1]);
        int res21 = findPathTabularised(n2);
        System.out.println(res2);
        System.out.println(res21);

//=========================================================================================
        System.out.println("+++Q3+++++++++++++++++");
        int[] arr3 = {3, 3, 0, 2, 2, 3};
        int n3 = 6;

        int res3 = findPathsVariableJump(n3, arr3);
        System.out.println(res3);
//=========================================================================================
        System.out.println("+++Q4+++++++++++++++++");
        int[] arr4 = {3, 2, 4, 2, 0, 2, 3, 1, 2, 2};
        int n4 = 10;

        int res4 = findPathWithMinimumJumps(n4, arr4);
        System.out.println(res4);
//=========================================================================================
        System.out.println("+++Q5+++++++++++++++++");

//=========================================================================================
        System.out.println("+++Q6+++++++++++++++++");
        int[][] mat6 = {
                {0,1,4,2,8,2},
                {4,3,6,5,0,4},
                {1,2,4,1,4,6},
                {2,0,7,3,2,2},
                {3,1,5,9,2,4},
                {2,7,0,8,5,1}
        };

        int res6 = maximumGoldFromMine(mat6);
        System.out.println(res6);
//=========================================================================================
//=========================================================================================
        System.out.println("+++Q7+++++++++++++++++");
        int[] arr7 = {4,2,7,1,3};
        int target7 = 10;
        ArrayList<String> s =  new ArrayList<>();
        findTargetSumSubsets(arr7,0, 0, target7, "", s);
        System.out.println(s.size());
        boolean res7 = findTargetSumSubsetsTabularized(arr7, target7);
        System.out.println(res7);
//=========================================================================================
        System.out.println("+++Q8+++++++++++++++++");
        int[] arr8 = {2, 3, 5};
        int target8 = 10;
        int res8 = coinChangeCombination(arr8, target8);
        System.out.println(res8);
//=========================================================================================
        System.out.println("+++Q9+++++++++++++++++");
        findAllPossiblePairings("123", 0, "");
    }
}
