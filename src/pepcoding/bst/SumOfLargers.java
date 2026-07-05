package src.pepcoding.bst;

import src.tree.Node;

public class SumOfLargers {

    static int SUM = 0;
    static void sumOfLargers(Node node){
        if(node == null) return;

        sumOfLargers(node.right);

        int temp = node.data;
        node.data = SUM;
        SUM += temp;

        sumOfLargers(node.left);
    }

    static int SUM1 = 0;
    static void sumOfLargers1(Node node){
        if(node == null) return;

        sumOfLargers(node.right);

        sumOfLargers(node.left);
        int temp = node.data;
        node.data = SUM;
        SUM += temp;
    }

    public static void main(String[] args) {
        int[] arr = {12, 25, 37, 50, 60, 62, 75, 89};
        Node root = BST.construct(arr, 0 , arr.length-1);

        sumOfLargers(root);
        BST.display(root);

        System.out.println("++++++++++");
        root = BST.construct(arr, 0 , arr.length-1);

        sumOfLargers1(root);
        BST.display(root);

    }
}
