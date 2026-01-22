package src.recursionl1;

public class PrintIncreasing {

    public static void printIncreasing(int n){
        if(n == 0){
            return;
        }
        printIncreasing(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n = 5;
        printIncreasing(n);
    }
}
