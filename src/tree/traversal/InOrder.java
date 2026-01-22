package src.tree.traversal;

import src.tree.Node;

public class InOrder{
	
	public static void recursive(Node<Integer> root) {
		if(root == null) return;
		recursive(root.left);
		System.out.print(root.data + " ");
		recursive(root.right);
	}
	
	public static void iterative(Node<Integer> root) {
		
	}

	public static void main(String[] args) {
		
		Node<Integer> root = new Node<>(10);
		
		Node<Integer> node1 = new Node<>(20);
		
		root.left = node1;
		
		recursive(root);

	}

}
