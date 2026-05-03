package src.tree.binarytreel1;

import src.tree.Node;

public class Paths {

    static void pathToNodeFromRootSumWithinRange(Node node, String path, int sum, int lo, int hi){
        if(node == null){
            return;
        }

        if(node.left==null && node.right==null){
            sum += node.data;
            if(sum >= lo && sum<= hi){ // sum must be between [lo, hi]
                System.out.println(path + node.data + " ");
            }
        }

        pathToNodeFromRootSumWithinRange(node.left, path + node.data + " ", sum+ node.data, lo , hi);
        pathToNodeFromRootSumWithinRange(node.right, path + node.data + " ", sum+ node.data, lo , hi);
    }


    public static void main(String[] args) {
        Node root = BT.getSampleTree();
        pathToNodeFromRootSumWithinRange(root, "", 0, 50, 87);
    }
}
