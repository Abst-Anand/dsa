package tree;

public class Node<T> {
	public T data;
	public Node<T> left;
	public Node<T> right;
	
	public Node(T newData){
		this.data = newData;
		this.left = null;
		this.right = null;
	}

}


