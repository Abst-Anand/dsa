package src.practice.tree;

import src.tree.Node;

public class ChildrenSumProperty {

    public static boolean checkChildrenSumProperty(Node<Integer> node){
        if(node == null) return true;
        if(node.left == null && node.right == null) return true;

        int leftValue = (node.left != null) ? node.left.data : 0;
        int rightValue = (node.right != null) ? node.right.data : 0;


        return (node.data == leftValue + rightValue) && checkChildrenSumProperty(node.left) && checkChildrenSumProperty(node.right);
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(10);
        Node<Integer> node2 = new Node<>(8);
        Node<Integer> node3 = new Node<>(2);
        Node<Integer> node4 = new Node<>(3);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node6 = new Node<>(2);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;

        boolean res = checkChildrenSumProperty(root);
        System.out.println(res);

    }
}
