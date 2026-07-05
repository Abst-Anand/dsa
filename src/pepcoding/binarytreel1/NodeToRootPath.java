package src.pepcoding.binarytreel1;

import src.tree.Node;

import java.util.ArrayList;

public class NodeToRootPath {

    static boolean find(Node node, int target, ArrayList<Integer> result){
        if(node == null) return false;

        if(node.data == target){
            result.add(node.data);
            return true;
        }

        boolean presentInleftChild = find(node.left, target, result);
        if(presentInleftChild){
            result.add(node.data);
            return true;
        }

        boolean presentInRightChild = find(node.right, target, result);
        if(presentInRightChild){
            result.add(node.data);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Node root = BT.getSampleTree();

        ArrayList<Integer> res = new ArrayList<>();
        find(root, 70, res);
        System.out.println(res);
    }
}
