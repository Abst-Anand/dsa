package src.practice.tree;

import src.tree.GenericNode;

public class SymmetricTree {

    public static boolean isSymmetric(GenericNode<Integer> genericNode){
        if(genericNode == null) return true;
        return isMirror(genericNode.left, genericNode.right);
    }

    private static boolean isMirror(GenericNode<Integer> leftSubTree, GenericNode<Integer> rightSubTree){
        if(leftSubTree == null && rightSubTree == null) return true;
        if(leftSubTree == null || rightSubTree == null) return false;

        return leftSubTree.data == rightSubTree.data && isMirror(leftSubTree.left, rightSubTree.right) && isMirror(leftSubTree.right, rightSubTree.left);
    }

    public static void main(String[] args) {
        GenericNode<Integer> root = new GenericNode<>();
        root = root.getSampleSymmetricIntegerTreeRoot();
        boolean res = isSymmetric(root);
        System.out.println(res);
    }
}
