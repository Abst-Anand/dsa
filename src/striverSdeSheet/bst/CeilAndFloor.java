package src.striverSdeSheet.bst;

public class CeilAndFloor {

	// return the smallest value which is greater than or equal to key
	static int ceil(Node root, int key) {
		int ceil = root.value;
		
		while(root != null) {
			
			if(root.value == key)
				return root.value;
			
			if(root.value < key) {
				root = root.right;
			}else {
				ceil = root.value;
				root = root.left;
			}
		}
		return ceil;
	}
	
	// return the largest value which is lesser than or equal to key
	static int floor(Node root, int key) {
		int floor = -1;
		
		while(root != null) {
			if(root.value == key)
				return root.value;
			
			if(root.value < key) {				
				floor = root.value;
				root = root.right;
			}
			else {
				root = root.left;
			}
		}
		
		return floor;
	}

}
