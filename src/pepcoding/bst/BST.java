package src.pepcoding.bst;

// construct, display, size, sum, max, min, find, remove

import src.tree.Node;

public class BST {

    public static Node construct(int[] arr, int lo, int hi){
        if(lo > hi){
            return null;
        }

        int mid = (lo + hi) / 2;
        Node leftChild = construct(arr, lo, mid-1);
        Node rightChild = construct(arr, mid+1, hi);
        return new Node(arr[mid], leftChild, rightChild);
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

    public static int size(Node node){
        if(node == null) return 0;

        int leftSize = size(node.left);
        int rightSize = size(node.right);

        return leftSize + rightSize + 1;
    }

    public static int sum(Node node){
        if(node == null) return 0;

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        return leftSum + rightSum + node.data;
    }

    public static int max(Node node){
        if(node.right != null){
            return max(node.right);
        }
        return node.data;
    }

    public static int min(Node node){
        if(node.left != null){
            return min(node.left);
        }
        return node.data;
    }

    public static boolean find(Node node, int target){
        if(node == null) return false;

        if(node.data > target){
            return find(node.left, target);
        } else if(node.data < target){
            return find(node.right, target);
        }else {
            return true;
        }
    }

    public static Node remove(Node node, int target){
        if(node == null) return null;

        if(node.data > target){
            node.left = remove(node.left, target);
        } else if (node.data < target){
            node.right = remove(node.right, target);
        } else {
            // check for number of children: 0 or 1 or 2
            if(node.left != null && node.right != null){ // 2 children
                int maxVal = max(node.left);
                node.data = maxVal;
                node.left = remove(node.left, maxVal);
                return node;

            } else if(node.left != null){ // 1 child (left child)
                return node.left;
            } else if(node.right != null){ // 1 child (right child
                return node.right;
            } else { // 0 children
                return null;
            }

        }
        return node;
    }

    public static void main(String[] args) {
        // sorted array to create a binary search tree
        int[] arr = {12, 25, 37, 50, 60, 62, 75, 89};

        Node root = construct(arr, 0, arr.length-1);

        display(root);

        System.out.println(size(root));
        System.out.println("===========");

//
//        System.out.println(sum(root));
//
//        System.out.println(max(root));
//
//        System.out.println(min(root));
//
//        System.out.println(find(root, 89));
        remove(root, 25);
        display(root);
        System.out.println(size(root));


    }
}
