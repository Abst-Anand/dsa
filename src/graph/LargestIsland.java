//695
package src.graph;

public class LargestIsland {
	
	static int dfs(int[][] arr, int i, int j, boolean[][] visited) {
		int rows = arr.length;
		int cols = arr[0].length;
		if(i<0 || j<0 || i>= rows || j>= cols || visited[i][j] || arr[i][j] == 0) {
			return 0;
		}
		
		visited[i][j] = true;
		int count = 1;
		count += dfs(arr, i-1, j, visited);
		count += dfs(arr, i+1, j, visited);
		count += dfs(arr, i, j+1, visited);
		count += dfs(arr, i, j-1, visited);
		
		
		return count;
	}
	
	static int maxConnecteds(int[][] arr, boolean[][] visited) {
		int maxCount = -99;
		
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j< arr[i].length; j++) {
				if(arr[i][j] == 1) {
					int currentCount = dfs(arr, i, j, visited);
					maxCount = Math.max(maxCount, currentCount);					
				}
			}	
		}
		
		return maxCount;
	}

	static int countMaxConnectedIslands(int[][] arr, int i, int j, int maxCount, boolean[][] visited) {
		int res = 1;
	
		int n = arr.length; // rows
		int m = arr[0].length; // cols
		if(i<0 || j<0 || i>=n || j>=m) {
			return 0;
		}
//		System.out.println(i + " , " + j);
		if(arr[i][j] == 1 && !visited[i][j]) {
			visited[i][j] = true;
			res += countMaxConnectedIslands(arr, i+1, j, maxCount, visited);
			res += countMaxConnectedIslands(arr, i-1, j, maxCount, visited);
			res += countMaxConnectedIslands(arr, i, j+1, maxCount, visited);
			res += countMaxConnectedIslands(arr, i, j-1, maxCount, visited);
		}else {
			return 0;
		}
		maxCount = Math.max(maxCount, res);
		
		
		return maxCount;
	}
	
	public static void main(String[] args) {
		
		int[][] arr = {{1,1,0}, {1,0,0}};
		boolean[][] visited = new boolean[arr.length][arr[0].length];
//		int t = maxConnecteds(arr, visited);
//		System.out.println(t);
		
		int r = countMaxConnectedIslands(arr, 0, 0, -99, visited);
		System.out.println(r);
		

	}

}
