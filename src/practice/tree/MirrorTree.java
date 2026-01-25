package src.practice.tree;

import src.tree.Node;
import src.tree.traversal.LevelOrder;

public class MirrorTree {

    public static void mirrorTree(Node<Integer> root){
        if(root == null) return;

        Node<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>();
        root = root.getSampleIntegerTreeRoot();

        LevelOrder.levelOrder(root);
        mirrorTree(root);
        LevelOrder.levelOrder(root);

    }
}
