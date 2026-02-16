package src.recursionl1;

// all the work is done in the "In" part of the Euler Diagram
public class TowerOfHanoi {

    public static void towerOfHanoi(int n, char src, char dest, char aux){
        if(n==0) return;
        towerOfHanoi(n-1, src, aux, dest);
        System.out.println(n + " [" + src + "->" + dest +"]");
        towerOfHanoi(n-1, aux, dest, src);
    }

    public static void main(String[] args) {
        int n = 3;

        towerOfHanoi(n, 'A', 'B', 'C');
    }
}
