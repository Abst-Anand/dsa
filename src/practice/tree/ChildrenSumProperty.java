package src.practice.tree;

import src.tree.GenericNode;

public class ChildrenSumProperty {

    public static boolean checkChildrenSumProperty(GenericNode<Integer> genericNode){
        if(genericNode == null) return true;
        if(genericNode.left == null && genericNode.right == null) return true;

        int leftValue = (genericNode.left != null) ? genericNode.left.data : 0;
        int rightValue = (genericNode.right != null) ? genericNode.right.data : 0;


        return (genericNode.data == leftValue + rightValue) && checkChildrenSumProperty(genericNode.left) && checkChildrenSumProperty(genericNode.right);
    }

    public static void main(String[] args) {
        GenericNode<Integer> root = new GenericNode<>(10);
        GenericNode<Integer> genericNode2 = new GenericNode<>(8);
        GenericNode<Integer> genericNode3 = new GenericNode<>(2);
        GenericNode<Integer> genericNode4 = new GenericNode<>(3);
        GenericNode<Integer> genericNode5 = new GenericNode<>(5);
        GenericNode<Integer> genericNode6 = new GenericNode<>(2);

        root.left = genericNode2;
        root.right = genericNode3;

        genericNode2.left = genericNode4;
        genericNode2.right = genericNode5;

        genericNode3.left = genericNode6;

        boolean res = checkChildrenSumProperty(root);
        System.out.println(res);

    }
}
