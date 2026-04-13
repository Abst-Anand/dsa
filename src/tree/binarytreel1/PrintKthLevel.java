package src.tree.binarytreel1;

import src.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PrintKthLevel {

    static void printKthLevelRecursive(Node node, int k){
        if(node == null || k < 0) return;

        if(k == 0){
            System.out.print(node.data + " ");
        }

        printKthLevelRecursive(node.left, k-1);
        printKthLevelRecursive(node.right, k-1);
    }

    static void printKthLevel(Node node, int k){
        if(node == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int level = 0;

        while (!q.isEmpty()){
            int count = q.size();
            for(int i=0; i<count; i++){
                Node curr = q.poll();

                if(level == k){
                    System.out.print(curr.data + " ");
                }
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }

            level++;
        }

    }

    public static void main(String[] args) {
        Node root = BT.getSampleTree();
        printKthLevel(root, 2);
        System.out.println();
        printKthLevelRecursive(root, 2);
    }
}
