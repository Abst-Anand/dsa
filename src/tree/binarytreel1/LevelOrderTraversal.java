package src.tree.binarytreel1;

import src.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    static void levelOrder(Node node){
        if(node == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            int count = q.size();
            for(int i=0; i < count; i++){
                Node curr = q.poll();

                System.out.print(curr.data + " ");

                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }

            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        Node root = BT.getSampleTree();
        levelOrder(root);
    }

}
