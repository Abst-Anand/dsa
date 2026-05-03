package src.tree.binarytreel1;

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

    public static void display(Node node){
        if(node == null) return;

        String str = "";
        str += node.left != null ? node.left.data : "null";
        str += " <- " + node.data + " -> ";
        str += node.right != null ? node.right.data : "null";
        System.out.println(str);

        display(node.left);
        display(node.right);
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

    // max distance (no of edges) between any two nodes
    // inefficient approach : O(n^2) because of recusion in a recursive method
    static int diameter(Node node){
        if(node == null){
            return 0;
        }
        // factor 1: when the two nodes are to left of the root
        int leftDia = diameter(node.left);
        // factor 2: when the two nodes are to right of the root
        int rightDia = diameter(node.right);
        // factor 3: when the two nodes are on either side of the root
        int f = height(node.left) + height(node.right) + 2;

        return Math.max(f, Math.max(leftDia, rightDia));
    }

    // efficient approach to calc diameter
    static int diameter1(Node node){
        return 0;
    }

    // tilt of a tree is sum of tilt of all the nodes,
    // tilt of a node is abs diff between its two children
    static int tilt;
    static int findTilt(Node node){
        if(node == null){
            return 0;
        }

        int leftNodeData = findTilt(node.left);
        int rightNodeData = findTilt(node.right);

        tilt += Math.abs(leftNodeData - rightNodeData);
        return node.data + leftNodeData + rightNodeData;
    }

    public static void main(String[] args) {

        Node root = getSampleTree();

        display(root);
        System.out.println(size(root));
        System.out.println(sum(root));
        System.out.println(max(root));
        System.out.println(height(root));

        findTilt(root);
        System.out.println(tilt);

    }
}
