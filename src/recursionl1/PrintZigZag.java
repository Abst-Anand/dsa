package src.recursionl1;

// Purpose is to visualise the flow of recursion.
public class PrintZigZag {

    public static void pzz(int n){
        if(n == 0) return;
        System.out.println("Pre: " + n);
        pzz(n-1);
        System.out.println("In: " + n);
        pzz(n-1);
        System.out.println("Post: " + n);
    }

    public static void main(String[] args) {
        int n = 3;
        pzz(n);
    }
}
