package striverSdeSheet;

public class SearchInSorted2DMatrix {
	
	static boolean search(int[][] mat, int n, int m, int target) {
		int low = 0;
		int high = (n * m) - 1;
		
		while(low <= high) {

			int mid = (low + high) / 2;
			int r = mid / m;
			int c = mid - (r * mat[r].length);
			System.out.println(mid + "=> (" + r + "," + c + ")");
			if(mat[r][c] == target) {
				return true;
			}
			
			if(mat[r][c] < target) {
				low = mid + 1;
			}
			
			else {
				high = mid - 1;
			}
			
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		int n = 3;
		int m = 4;
		int target = 12;
//		int[][] mat = new int[n][m];
		int[][] mat = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};

		System.out.println(search(mat, n, m, target));
	}

}
