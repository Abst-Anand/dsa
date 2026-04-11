package src.practice.tree;

import src.tree.GenericNode;

public class IdenticalTrees {

    public static boolean isIdentical(GenericNode<Integer> root1, GenericNode<Integer> root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null && root2 != null) return false;
        if(root1 != null && root2 == null) return false;

        boolean leftSame = isIdentical(root1.left, root2.left);
        boolean rightSame = isIdentical(root1.right, root2.right);
        if(root1.data == root2.data && leftSame && rightSame){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        GenericNode<Integer> root1 = new GenericNode<>();
        GenericNode<Integer> root2 = new GenericNode<>();

        root1 = root1.getSampleIntegerTreeRoot();
        root2 = root2.getSampleIntegerTreeRoot();
        root2.left.data = -89;

        boolean res = isIdentical(root1, root2);
        System.out.println(res);
    }
}
