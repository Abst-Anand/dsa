package src.tree;

public class Node<T> {
	public T data;
	public Node<T> left;
	public Node<T> right;

	public Node(){}

	public Node(T value){
		this.data = value;
		this.left = null;
		this.right = null;
	}

	public void createTreeUsingArray(T[] arr){

	}

	public Node getSampleIntegerTreeRoot(){
		Node<Integer> root =  new Node<>(1);
		Node<Integer> node2 =  new Node<>(2);
		Node<Integer> node3 =  new Node<>(3);
		Node<Integer> node4 =  new Node<>(4);
		Node<Integer> node5 =  new Node<>(5);
		Node<Integer> node6 =  new Node<>(6);
		Node<Integer> node7 =  new Node<>(7);
		Node<Integer> node8 =  new Node<>(8);
		Node<Integer> node9 =  new Node<>(9);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.left = node6;
		node3.right = node7;

		node4.left = node8;
		node8.left = node9;

		return root;
	}

	public Node getSampleSymmetricIntegerTreeRoot(){
		Node<Integer> root =  new Node<>(1);
		Node<Integer> node2 =  new Node<>(2);
		Node<Integer> node3 =  new Node<>(2);
		Node<Integer> node4 =  new Node<>(4);
		Node<Integer> node5 =  new Node<>(5);
		Node<Integer> node6 =  new Node<>(5);
		Node<Integer> node7 =  new Node<>(4);
		Node<Integer> node8 =  new Node<>(8);
		Node<Integer> node9 =  new Node<>(9);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.left = node6;
		node3.right = node7;

		//node4.left = node8;
		//node8.left = node9;

		return root;
	}

}


