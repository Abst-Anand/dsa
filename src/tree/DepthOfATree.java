package src.tree;

public class DepthOfATree {

    public static int findDepth(GenericNode<Integer> root) {
        if(root == null) return 0;

        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        GenericNode<Integer> root = new GenericNode<>();
        root = root.getSampleIntegerTreeRoot();

        int heigth = DepthOfATree.findDepth(root);
        System.out.println(heigth);

    }
}
