package striverSdeSheet.tree;

import java.util.ArrayList;
import java.util.Stack;

public class FindOneSidedChildren {
	
	static void getAllLeftChildren(Node root) {
		if(root ==  null) return;
		
		if(root.left != null) {
			System.out.println(root.left.data);
			getAllLeftChildren(root.left);
		}
		
		if(root.right != null) {
			getAllLeftChildren(root.right);
		}
		
	}
	
	static void getAllRightChildren(Node root, ArrayList<Integer> res) {
		if(root == null) return;
		
		if(root.left != null)
			getAllRightChildren(root.left, res);
		
		if(root.right != null) {
//			System.out.println(root.right.data);
			res.add(root.right.data);
			getAllRightChildren(root.right,  res);
		}
	}
	
	static void flattenTree(Node root){
		
		if(root == null) return;
		
		Stack<Node> stk = new Stack<>();
		
		stk.add(root);
		
		while(!stk.isEmpty()) {
			Node curr = stk.pop();
			
			if(curr.right != null)
				stk.add(curr.right);
			
			if(curr.left != null) {
				stk.add(curr.left);
			}
			
			if(!stk.isEmpty()) {
				curr.right = stk.peek();
			}
			
			curr.left = null;
		}
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(10);
		Node node1 = new Node(20);
		Node node2 = new Node(30);
		Node node3 = new Node(40);
		Node node4 = new Node(50);
		Node node5 = new Node(60);
		Node node6 = new Node(70);
		
		root.left = node1;
		root.right = node2;
		
		node1.left = node3;
		node1.right = node4;
		
		node3.left = node5;
		
		node2.left = node6;
		
//		getAllLeftChildren(root);
		
		flattenTree(root);
		ArrayList<Integer> values = new ArrayList<Integer>();
		values.add(root.data);
		getAllRightChildren(root, values);
		
		System.out.println(values);

	}

}
