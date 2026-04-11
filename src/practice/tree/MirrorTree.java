package src.practice.tree;

import src.tree.GenericNode;
import src.tree.traversal.LevelOrder;

public class MirrorTree {

    public static void mirrorTree(GenericNode<Integer> root){
        if(root == null) return;

        GenericNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);
    }

    public static void main(String[] args) {
        GenericNode<Integer> root = new GenericNode<>();
        root = root.getSampleIntegerTreeRoot();

        LevelOrder.levelOrder(root);
        mirrorTree(root);
        LevelOrder.levelOrder(root);

    }
}
