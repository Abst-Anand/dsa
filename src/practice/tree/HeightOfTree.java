package src.practice.tree;

import src.tree.GenericNode;

public class HeightOfTree {

    public static int getHeight(GenericNode<Integer> root){
        if(root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        GenericNode<Integer> root = new GenericNode<>();
        root = root.getSampleIntegerTreeRoot();

        int ans = getHeight(root);
        System.out.println(ans);
    }
}
