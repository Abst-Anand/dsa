package src.striverSdeSheet.bst;

public class Insert {

	static Node inser(Node root, int val) {
		if(root == null) return new Node(val);
		
		Node curr = root;
		
		while(true) {
			
			if(curr.value <= val) {
				if(curr.right != null) {
					curr = curr.right;					
				}
				else {
					curr.right = new Node(val);
					break;
				}
				
			}else {
				if(curr.left != null) {
					curr = curr.left;
				}
				else {
					curr.left = new Node(val);
					break;
				}
				
			}
			
		}
		return root;
	}
	
	void display(Node root) {
		
	}
}
