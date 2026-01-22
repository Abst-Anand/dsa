package src.linkedList;

public class FlattenBinaryTree {
	
	public static BinaryTreeNode flattenTree(BinaryTreeNode node) {
		if(node == null) {
			return null;
		}
		
		if(node.left == null && node.right == null) {
			return node;
		}
		
		BinaryTreeNode leftTail = flattenTree(node.left);
		BinaryTreeNode rightTail = flattenTree(node.right);
		
		if(leftTail != null) {
			leftTail.right = node.right;
			node.right = node.left;
			node.left = null;
		}
		
		if(rightTail == null)
			return leftTail;
		
		return rightTail;
	}

	public static Node flatten(BinaryTreeNode root) {
		Node ans = null;
		
		return ans;
	}
	
	
	public static void main(String[] args) {
		
		BinaryTreeNode tree = new BinaryTreeNode(1);
		tree.left = new BinaryTreeNode(2);
		tree.right = new BinaryTreeNode(3);
		
		
		

	}

}
