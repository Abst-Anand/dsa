package src.practice.tree;

import src.tree.Node;

public class IdenticalTrees {

    public static boolean isIdentical(Node<Integer> root1, Node<Integer> root2){
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
        Node<Integer> root1 = new Node<>();
        Node<Integer> root2 = new Node<>();

        root1 = root1.getSampleIntegerTreeRoot();
        root2 = root2.getSampleIntegerTreeRoot();
        root2.left.data = -89;

        boolean res = isIdentical(root1, root2);
        System.out.println(res);
    }
}
