package src.tree.traversal;

import java.util.Stack;

import src.tree.GenericNode;

public class PreOrder {
	
	public static void recursive(GenericNode<Integer> root) {
		if(root == null) return;
		System.out.print(root.data + " ");
		recursive(root.left);
		recursive(root.right);
	}
	
	public static void iterative(GenericNode<Integer> root) {
		if(root == null) return;
		Stack<GenericNode<Integer>> st = new Stack<>();
		
		st.add(root);
		
		while(!st.isEmpty()) {
			GenericNode<Integer> curr = st.pop();
			System.out.print(curr.data + " ");
			if(curr.right != null) 
				st.add(curr.right);
			if(curr.left != null) 
				st.add(curr.left);
		}
	}

	public static void main(String[] args) {
		GenericNode<Integer> root =  new GenericNode<>(10);
		GenericNode<Integer> genericNode1 =  new GenericNode<>(45);
		GenericNode<Integer> genericNode2 =  new GenericNode<>(5);
		GenericNode<Integer> genericNode3 =  new GenericNode<>(180);
		GenericNode<Integer> genericNode4 =  new GenericNode<>(69);
		GenericNode<Integer> genericNode5 =  new GenericNode<>(7);
		GenericNode<Integer> genericNode6 =  new GenericNode<>(56);
		
		root.left = genericNode1;
		root.right = genericNode2;
		
		genericNode1.left = genericNode3;
		genericNode1.right = genericNode4;
		
		genericNode2.left = genericNode5;
		genericNode2.right = genericNode6;
		
		recursive(root);
		System.out.println();
		iterative(root);
	}

}
