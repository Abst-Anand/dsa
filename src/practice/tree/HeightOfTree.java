package src.practice.tree;

import src.tree.Node;

public class HeightOfTree {

    public static int getHeight(Node<Integer> root){
        if(root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>();
        root = root.getSampleIntegerTreeRoot();

        int ans = getHeight(root);
        System.out.println(ans);
    }
}
