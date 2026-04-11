package src.recursionl1;

import java.util.ArrayList;

public class Fibonacci {

    static ArrayList<Integer> dp = new ArrayList<>();

    static int fib(int n){
        System.out.println("Called for n = " + n);
        if(n <= 1) return n;

        if(dp.get(n-1) == 0){
            int ans = fib(n-1) + fib(n - 2);
            dp.set(n-1, ans);
        }
        return dp.get(n-1);
    }


    public static void main(String[] args) {



        int n = 5;

        for(int i = 0; i < n; i++){
            dp.add(0);
        }

        dp.set(0, 1);
        dp.set(1, 2);

        int res  = fib(n);
        System.out.println(res);
    }
}
// 1 1 0 0 0 0 0 0 0 0 0
