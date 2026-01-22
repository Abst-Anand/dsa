package striverSdeSheet.bst;

public class Search {
	
	static Node search(Node root, int target) {
		
		while(root != null) {
			if(root.value == target)
				return root;
			
			if(root.value < target)
				root = root.right;
			
			else
				root = root.left;
			
		}
		return null;
	}

}
