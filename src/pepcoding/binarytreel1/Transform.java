package src.pepcoding.binarytreel1;

import src.tree.Node;

public class Transform {

    static Node transformLeftClonedTree(Node node){
        if(node == null){
            return null;
        }

        Node left = transformLeftClonedTree(node.left);
        Node right = transformLeftClonedTree(node.right);

        Node nn = new Node(node.data, left, null);
        node.left = nn;
//        node.right = right;
        return node;
    }

    static Node transformBackFromClonedTree(Node node){
        if(node == null){
            return null;
        }

        Node leftNormalised = transformBackFromClonedTree(node.left.left);
        Node rightNormalised = transformBackFromClonedTree(node.right);

        node.left = leftNormalised;
        node.right = rightNormalised;
        return node;
    }

    static void printSingleChildNodes(Node node){ // print those children whose parent has only one child
        if(node == null) return;

        if(node.right == null && node.left != null){
            System.out.println(node.left.data);
        }

        if(node.left == null && node.right != null){
            System.out.println(node.right.data);
        }

        printSingleChildNodes(node.left);
        printSingleChildNodes(node.right);
    }

    static Node removeLeaves(Node node){
        if(node == null){
            return null;
        }

        if(node.left == null && node.right == null){
            return null;
        }

        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);
        return node;
    }

    public static void main(String[] args) {
        Node root = BT.getSampleTree();
        BT.display(root);
        System.out.println();

        transformLeftClonedTree(root);
//        BT.display(root);

        transformBackFromClonedTree(root);
        BT.display(root);

        printSingleChildNodes(root);
    }
}
