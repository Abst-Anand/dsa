package src.recursionl1;

public class LinearPower {

    public static int power(int x, int n){
        if(n == 0 || x == 0) return 1;
        return x * power(x, n - 1);
    }

    public static int powerOptimised(int x, int n){
        if(n == 0) return 1;

        int xpnb2 = powerOptimised(x, n / 2);
        int xn = xpnb2 * xpnb2;

        if(n % 2 == 1){
            xn = xn * x;
        }

        return xn;
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 3;
        int res1 = power(x, n); // O(n)
        int res2 = powerOptimised(x, n); // O(logn) --> log base 2
        System.out.println(res1);
        System.out.println(res2);
    }
}
