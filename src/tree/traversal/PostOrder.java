package src.tree.traversal;

import java.util.Stack;

import src.tree.GenericNode;

// post order traversal both recursive and iterative
public class PostOrder {
	
	static void iterative(GenericNode<Integer> root) {
		Stack<GenericNode<Integer>> st = new Stack<>();
		st.add(root);
		while(!st.isEmpty()) {
			GenericNode<Integer> curr = st.peek();
			if(curr.right != null)
				st.add(curr.right);
			if(curr.left != null)
				st.add(curr.left);	
			curr = st.pop();
			System.out.print(curr.data + " ");
			if(curr == root) break;
		}
		System.out.println(root.data);
	}
	
	static void recursive(GenericNode<Integer> root) {
		if(root == null) return;
		recursive(root.left);
		recursive(root.right);
		System.out.print(root.data + " ");
	}

	public static void main(String[] args) {

		GenericNode<Integer> root = new GenericNode<>(10);
		GenericNode<Integer> genericNode1 = new GenericNode<>(20);
		GenericNode<Integer> genericNode2 = new GenericNode<>(30);
		GenericNode<Integer> genericNode3 = new GenericNode<>(40);
		GenericNode<Integer> genericNode4 = new GenericNode<>(50);
		GenericNode<Integer> genericNode5 = new GenericNode<>(880);
		GenericNode<Integer> genericNode6 = new GenericNode<>(8);
		
		root.left = genericNode1;
		root.right = genericNode2;
		
		genericNode1.left = genericNode3;
		genericNode1.right = genericNode4;
		
		genericNode2.left = genericNode5;
		genericNode2.right = genericNode6;
		
		iterative(root);
		System.out.println();
//		recursive(root);
	}

}
