package src.prep.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthTraversal {

    static int height(Node root){
        if(root == null) return -1;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    static void traverse(Node root){
        if(root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            Node curr = q.poll();
            System.out.println(curr.data);
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
    }


    public static void main(String[] args) {
        Node root = new Node(10);

        Node left1 = new Node(20);
        Node right1 = new Node(30);

        Node left2 = new Node(40);
        Node right2 = new Node(50);
        Node left3 = new Node(60);

        root.left = left1;
        root.right = right1;

        left1.left = left2;
        left1.right = right2;
        right1.left = left3;
        left2.left = new Node(70);

        traverse(root);
        System.out.println("Height: " + height(root));
    }
}
