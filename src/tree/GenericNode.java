package src.tree;

public class GenericNode<T> {
	public T data;
	public GenericNode<T> left;
	public GenericNode<T> right;

	public GenericNode(){}

	public GenericNode(T value){
		this.data = value;
		this.left = null;
		this.right = null;
	}

	public GenericNode(T value, GenericNode left, GenericNode right){
		this.data = value;
		this.left = left;
		this.right = right;
	}

	public void createTreeUsingArray(T[] arr){

	}

	public GenericNode getSampleIntegerTreeRoot(){
		GenericNode<Integer> root =  new GenericNode<>(1);
		GenericNode<Integer> genericNode2 =  new GenericNode<>(2);
		GenericNode<Integer> genericNode3 =  new GenericNode<>(3);
		GenericNode<Integer> genericNode4 =  new GenericNode<>(4);
		GenericNode<Integer> genericNode5 =  new GenericNode<>(5);
		GenericNode<Integer> genericNode6 =  new GenericNode<>(6);
		GenericNode<Integer> genericNode7 =  new GenericNode<>(7);
		GenericNode<Integer> genericNode8 =  new GenericNode<>(8);
		GenericNode<Integer> genericNode9 =  new GenericNode<>(9);

		root.left = genericNode2;
		root.right = genericNode3;

		genericNode2.left = genericNode4;
		genericNode2.right = genericNode5;

		genericNode3.left = genericNode6;
		genericNode3.right = genericNode7;

		genericNode4.left = genericNode8;
		genericNode8.left = genericNode9;

		return root;
	}

	public GenericNode getSampleSymmetricIntegerTreeRoot(){
		GenericNode<Integer> root =  new GenericNode<>(1);
		GenericNode<Integer> genericNode2 =  new GenericNode<>(2);
		GenericNode<Integer> genericNode3 =  new GenericNode<>(2);
		GenericNode<Integer> genericNode4 =  new GenericNode<>(4);
		GenericNode<Integer> genericNode5 =  new GenericNode<>(5);
		GenericNode<Integer> genericNode6 =  new GenericNode<>(5);
		GenericNode<Integer> genericNode7 =  new GenericNode<>(4);
		GenericNode<Integer> genericNode8 =  new GenericNode<>(8);
		GenericNode<Integer> genericNode9 =  new GenericNode<>(9);

		root.left = genericNode2;
		root.right = genericNode3;

		genericNode2.left = genericNode4;
		genericNode2.right = genericNode5;

		genericNode3.left = genericNode6;
		genericNode3.right = genericNode7;

		//node4.left = node8;
		//node8.left = node9;

		return root;
	}

}


