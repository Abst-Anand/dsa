package src.tree.traversal;

import java.util.Stack;

import src.tree.Node;

public class PreOrder {
	
	public static void recursive(Node<Integer> root) {
		if(root == null) return;
		System.out.print(root.data + " ");
		recursive(root.left);
		recursive(root.right);
	}
	
	public static void iterative(Node<Integer> root) {
		if(root == null) return;
		Stack<Node<Integer>> st = new Stack<>();
		
		st.add(root);
		
		while(!st.isEmpty()) {
			Node<Integer> curr = st.pop();
			System.out.print(curr.data + " ");
			if(curr.right != null) 
				st.add(curr.right);
			if(curr.left != null) 
				st.add(curr.left);
		}
	}

	public static void main(String[] args) {
		Node<Integer> root =  new Node<>(10);
		Node<Integer> node1 =  new Node<>(45);
		Node<Integer> node2 =  new Node<>(5);
		Node<Integer> node3 =  new Node<>(180);
		Node<Integer> node4 =  new Node<>(69);
		Node<Integer> node5 =  new Node<>(7);
		Node<Integer> node6 =  new Node<>(56);
		
		root.left = node1;
		root.right = node2;
		
		node1.left = node3;
		node1.right = node4;
		
		node2.left = node5;
		node2.right = node6;
		
		recursive(root);
		System.out.println();
		iterative(root);
	}

}
