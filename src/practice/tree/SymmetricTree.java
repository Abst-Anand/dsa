package src.practice.tree;

import src.tree.Node;

public class SymmetricTree {

    public static boolean isSymmetric(Node<Integer> node){
        if(node == null) return true;
        return isMirror(node.left, node.right);
    }

    private static boolean isMirror(Node<Integer> leftSubTree, Node<Integer> rightSubTree){
        if(leftSubTree == null && rightSubTree == null) return true;
        if(leftSubTree == null || rightSubTree == null) return false;

        return leftSubTree.data == rightSubTree.data && isMirror(leftSubTree.left, rightSubTree.right) && isMirror(leftSubTree.right, rightSubTree.left);
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>();
        root = root.getSampleSymmetricIntegerTreeRoot();
        boolean res = isSymmetric(root);
        System.out.println(res);
    }
}
