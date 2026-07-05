package src.pepcoding.binarytreel1;

import src.tree.Node;

import java.util.Stack;

class Pair{
    Node node;
    int state;

    Pair(Node node, int state){
        this.node = node;
        this.state = state;
    }
}

public class IterativePreInPost {

    static void iterativeTraversal(Node node){
        Stack<Pair> stk = new Stack<>();
        Pair p = new Pair(node, 1);
        stk.push(p);

        String preResult = "";
        String inResult = "";
        String postResult = "";

        while (!stk.isEmpty()){
            Pair curr = stk.peek();
            if(curr.state == 1){
                preResult += curr.node.data + " ";
                curr.state = 2;
                if(curr.node.left != null){
                    stk.push(new Pair(curr.node.left , 1));
                }

            } else if(curr.state == 2){
                inResult += curr.node.data + " ";
                curr.state = 3;
                if(curr.node.right != null){
                    stk.push(new Pair(curr.node.right , 1));
                }
            } else{
                postResult += curr.node.data + " ";
                stk.pop();
            }
        }
        System.out.println("Pre: " + preResult);
        System.out.println("In: " + inResult);
        System.out.println("Post: " + postResult);
    }

    public static void main(String[] args) {
        Node root = BT.getSampleTree();
        iterativeTraversal(root);
    }
}
