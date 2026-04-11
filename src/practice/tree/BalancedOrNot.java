package src.practice.tree;

import src.tree.GenericNode;

public class BalancedOrNot {

    public static boolean isBalanced(GenericNode<Integer> root){
        if(root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getHeight(GenericNode<Integer> genericNode){
        if(genericNode == null) return 0;

        int leftHeight = getHeight(genericNode.left);
        int rightHeight = getHeight(genericNode.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        GenericNode<Integer> root = new GenericNode<>();
        root = root.getSampleIntegerTreeRoot();
        boolean res = isBalanced(root);
        System.out.println(res);
    }
}
