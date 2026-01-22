package src.linkedList;

public class BinaryTreeNode {
	int val;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	public BinaryTreeNode() {	
	}
	
	BinaryTreeNode(int val){
		this.val = val;
	}

	public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

}
