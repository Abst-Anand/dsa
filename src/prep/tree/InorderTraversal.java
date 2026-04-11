package src.prep.tree;

import java.util.*;

public class InorderTraversal {
    static ArrayList<Integer> list = new ArrayList<>();
    static Map<Integer, Integer> pairs = new HashMap<>();

    static void inorder(Node node){
        if(node == null) return;

        inorder(node.left);
        list.add(node.data);
        inorder(node.right);
    }

    static void findPairs(Node node, int target, Set<Integer> set){
        if(node == null) return;

        if(set.contains(target - node.data)){
            System.out.println(node.data + ", " + (target - node.data));
        }

        set.add(node.data);

        findPairs(node.left, target, set);
        findPairs(node.right, target, set);
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        Node left1 = new Node(-20);
        Node right1 = new Node(300);

        Node left2 = new Node(40);
        Node right2 = new Node(5);
        Node left3 = new Node(19);

        root.left = left1;
        root.right = right1;

        left1.left = left2;
        left1.right = right2;
        right1.left = left3;
        left2.left = new Node(70);

        inorder(root);
        System.out.println(list);

        findPairs(root, 20, new HashSet<>());
    }
}
