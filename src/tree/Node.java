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
		node1.right = node5;

		node2.left = node4;
		node3.right = node6;

		return root;
	}

}


