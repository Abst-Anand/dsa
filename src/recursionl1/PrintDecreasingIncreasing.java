package src.recursionl1;

/*
KNOWLEDGE SHARING SESSION (KT)
* every week 15-20 min only. Why only 15-20mins? anyone may not be interested in your topic..."just bare with me for 20 mins"
* weekly catch up
* we get to know how the other one's world is!
* knowledge expantion
* maybe a language session
* maybe something from The Geeta
* while preparing, you map a very complex process to a very easy scenario which makes you learn it even further in its depth
*
* Ajji & Appa
* I will store these sessions on google drive, so our future generation may get to know us
*
* */
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
