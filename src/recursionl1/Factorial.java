package src.recursionl1;

public class Factorial {

    public static long factorial(long n){
        if(n == 1){
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        long n = 500l;
        long res = factorial(n);
        System.out.println(res);
    }
}
