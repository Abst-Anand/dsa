package src.practice.tree;

import src.tree.Node;

public class BalancedOrNot {

    public static boolean isBalanced(Node<Integer> root){
        if(root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getHeight(Node<Integer> node){
        if(node == null) return 0;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>();
        root = root.getSampleIntegerTreeRoot();
        boolean res = isBalanced(root);
        System.out.println(res);
    }
}
