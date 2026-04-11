package src.tree.traversal;

import src.tree.GenericNode;

public class InOrder{
	
	public static void recursive(GenericNode<Integer> root) {
		if(root == null) return;
		recursive(root.left);
		System.out.print(root.data + " ");
		recursive(root.right);
	}
	
	public static void iterative(GenericNode<Integer> root) {
		
	}

	public static void main(String[] args) {
		
		GenericNode<Integer> root = new GenericNode<>(10);
		
		GenericNode<Integer> genericNode1 = new GenericNode<>(20);
		
		root.left = genericNode1;
		
		recursive(root);

	}

}
