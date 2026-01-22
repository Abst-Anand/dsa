package src.recursionl1;

public class PrintDecreasingIncreasing {

    public static void printIncreasingDecreasing(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        printIncreasingDecreasing(n - 1);
        System.out.println(n);

//        PrintDecreasing.printDecreasing(n);
//        PrintIncreasing.printIncreasing(n);
    }

    public static void main(String[] args) {
        int n = 5;
        printIncreasingDecreasing(n);
    }
}
