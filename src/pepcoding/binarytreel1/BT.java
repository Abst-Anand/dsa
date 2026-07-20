package src.pepcoding.binarytreel1;

import src.tree.Node;

import java.util.ArrayList;
import java.util.Stack;

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

    // iterative pre, in, post
    static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    static void iterativePreInPost(Node root){
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        String pre = "";
        String in = "";
        String post = "";

        while (!stack.isEmpty()){
            Pair curr = stack.peek();

            if(curr.state == 1){ // pre, state++, push left child
                pre += curr.node.data + " ";
                curr.state++;
                if(curr.node.left != null) stack.push(new Pair(curr.node.left, 1));

            } else if (curr.state == 2) { // in, state++, push right child
                in += curr.node.data + " ";
                curr.state++;
                if(curr.node.right != null) stack.push(new Pair(curr.node.right, 1));

            }else { // post, pop
                post += curr.node.data + " ";
                stack.pop();
            }
        }
        System.out.println("Pre: " + pre);
        System.out.println("In: " + in);
        System.out.println("Post: " + post);
    }

    // node to root path
    static boolean nodeToRootPath(Node root, int targetNode, ArrayList<Integer> res){
        if(root == null) return false;

        if(root.data == targetNode){
            res.add(root.data);
            return true;
        }

        boolean hasPath = nodeToRootPath(root.left, targetNode, res) || nodeToRootPath(root.right, targetNode, res);
        if(hasPath){
            res.add(root.data);
        }
        return hasPath;
    }

    // print kth level, k=0 means root
    static void printKthLevel(Node node, int k){
        if(node == null || k<0){
            return;
        }

        if(k == 0){
            System.out.print(node.data + " ");
            return;
        }
        printKthLevel(node.left, k-1);
        printKthLevel(node.right, k-1);
    }

    // print nodes which are at K distance from a given node in all direction, no repetition
    static boolean findPathFromNodeToRootHelper(Node node, Node target, ArrayList<Node> path){
        if(node == null){
            return false;
        }

        if(node.data == target.data){
            path.add(node);
            return true;
        }

        boolean hasPath = findPathFromNodeToRootHelper(node.left, target, path) || findPathFromNodeToRootHelper(node.right, target, path);
        if(hasPath){
            path.add(node);
        }

        return hasPath;
    }
    static void printKLevelsDownHelper(Node node, int k, Node blocker){
        if(node == null || k<0 || node == blocker) return;
        if(k == 0){
            System.out.print(node.data + " ");
        }

        printKLevelsDownHelper(node.left, k-1, blocker);
        printKLevelsDownHelper(node.right, k-1, blocker);
    }
    static void printKNodesAway(Node node, Node target, int k){
        ArrayList<Node> path = new ArrayList<>();
        findPathFromNodeToRootHelper(node, target, path); // get the path from node to root then run printKLevelsDownHelper for each node in it

        for(int i=0; i<k; i++){
            Node blocker = i==0 ? null : path.get(i-1);
            printKLevelsDownHelper(path.get(i), k-i, blocker);
        }
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

        iterativePreInPost(root);

        ArrayList<Integer> al = new ArrayList<>();
        boolean res = nodeToRootPath(root, 70, al);
        System.out.println("Node to Root path exist: " + res);
        System.out.println("Path: " + al);

        System.out.println("Priting Kth level:");
        printKthLevel(root , 2);
        System.out.println();

        findTilt(root);
        System.out.println(tilt);

    }
}
