package src.recursionl1;

public class LinearPower {

    public static int power(int x, int n){
        if(n == 0 || x == 0) return 1;
        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 3;
        int res = power(x, n);
        System.out.println(res);
    }
}
