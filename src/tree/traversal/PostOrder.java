package tree.traversal;

import java.util.Stack;

import tree.Node;

// post order traversal both recursive and iterative
public class PostOrder {
	
	static void iterative(Node<Integer> root) {
		Stack<Node<Integer>> st = new Stack<>();
		st.add(root);
		while(!st.isEmpty()) {
			Node<Integer> curr = st.peek();
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
	
	static void recursive(Node<Integer> root) {
		if(root == null) return;
		recursive(root.left);
		recursive(root.right);
		System.out.print(root.data + " ");
	}

	public static void main(String[] args) {

		Node<Integer> root = new Node<>(10);
		Node<Integer> node1 = new Node<>(20);
		Node<Integer> node2 = new Node<>(30);
		Node<Integer> node3 = new Node<>(40);
		Node<Integer> node4 = new Node<>(50);
		Node<Integer> node5 = new Node<>(880);
		Node<Integer> node6 = new Node<>(8);
		
		root.left = node1;
		root.right = node2;
		
		node1.left = node3;
		node1.right = node4;
		
		node2.left = node5;
		node2.right = node6;
		
		iterative(root);
		System.out.println();
//		recursive(root);
	}

}
