package striverSdeSheet.tree;

public class Traversal {
	
	static void inOrder(Node root) {
		if(root == null) {
			return;
		}
		
		// left
		inOrder(root.left);
		
		//root (process || print)
		System.out.print(root.data + " ");
		
		//right
		inOrder(root.right);
	}

	static void preOrder(Node root) {
		if(root == null) return;
		
		//root (process || print)
		System.out.print(root.data + " ");
		
		//left
		preOrder(root.left);
		
		//right
		preOrder(root.right);
	}
	
	static void postOrder(Node root) {
		if(root == null) return;
		
		//left
		postOrder(root.left);
		
		//right
		postOrder(root.right);
		
		//root (process || print)
		System.out.print(root.data + " ");
	}
	
	public static void main(String[] args) {
		Node r = new Node(4);
		r.left = new Node(2);
		r.left.left = new Node(3);
		r.left.left.right = new Node(9);
		r.left.left.right.left = new Node(1);
		
		r.right = new Node(5);
		r.right.left = new Node(7);
		r.right.right = new Node(6);
		r.right.right.left = new Node(8);
		
		System.out.println("Output for InOrder Traversal: ");
		inOrder(r);
		//output for InOrder Traversal: 3 1 9 2 4 7 5 8 6	
		
		System.out.println("\nOutput for PreOrder Traversal: ");
		preOrder(r);
		//output for PreOrder Traversal: 4 2 3 9 1 5 7 6 8
		
		System.out.println("\nOutput for PostOrder Traversal: ");
		postOrder(r);
		//output for PostOrder Traversal: 1 9 3 2 7 8 6 5 4

	}

}
