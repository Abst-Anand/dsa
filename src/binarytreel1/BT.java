package src.binarytreel1;

import src.tree.Node;

public class BT {
    // create sample tree and return root
    public static Node getSampleTree(){
        Node n7 = new Node(70, null, null);
        Node n6 = new Node(87, null, null);
        Node n5 = new Node(62, null, n7);
        Node n4 = new Node(37, null, null);
        Node n3 = new Node(12, null, null);
        Node n2 = new Node(75, n5, n6);
        Node n1 = new Node(25, n3, n4);
        Node root = new Node(50, n1 , n2);

        return  root;
    }

    // size of the tree (no of nodes)
    static int size(Node node){
        if(node == null) return 0;

        int leftSize = size(node.left);
        int rightSize = size(node.right);
        int totalSize = 1 + leftSize + rightSize;
        return totalSize;
    }

    // sum of tree
    static int sum(Node node){
        if(node == null) return 0;

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        int totalSum = node.data + leftSum + rightSum;
        return totalSum;
    }

    // max val in tree
    static int max(Node node){
        if(node == null) return Integer.MIN_VALUE;

        int leftMax = max(node.left);
        int rightMax = max(node.right);

        int maxLeftRight = Math.max(leftMax, rightMax);
        int actualMax = Math.max(node.data, maxLeftRight);
        return actualMax;
    }

    // height of the tree (no of edges)
    static int height(Node node){
        if (node == null) return -1; // for a tree with single node, height is 0 where as size is 1

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int maxHeight = Math.max(leftHeight, rightHeight);

        return 1 + maxHeight;
    }

    public static void main(String[] args) {

        Node root = getSampleTree();

        System.out.println(size(root));
        System.out.println(sum(root));
        System.out.println(max(root));
        System.out.println(height(root));

    }
}
