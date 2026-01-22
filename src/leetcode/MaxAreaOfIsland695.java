package leetcode;

public class MaxAreaOfIsland695 {
	
	static void findMaxArea(int[][] grid) {
		
//		System.out.println(grid.length);
//		System.out.println(grid[0].length);
		
		int m = grid.length;
		int n = grid[0].length;
		int maxArea = 0;
		
		
		boolean[][] isVisited = new boolean[m][n];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				
				if(!isVisited[i][j]) {
					int area = dfs(grid,i ,j, isVisited);
					maxArea = Math.max(maxArea, area);
				
				}
			}
		}
		
		System.out.println("Maximun Island Area" + maxArea);
		
	}
	
	static int dfs(int[][] grid,int i ,int j, boolean[][] isVisited) {
		if(i<0 || i >= grid.length || j<0 || j>=grid[i].length || grid[i][j] == 0 || isVisited[i][j])
			return 0;
		
		isVisited[i][j] = true;
		int area = 1;
		area += dfs(grid, i+1, j  , isVisited);
		area += dfs(grid, i-1, j  , isVisited);
		area += dfs(grid, i  , j+1, isVisited);
		area += dfs(grid, i  , j-1, isVisited);
		
		return area;
		
	}
	
	

	public static void main(String[] args) {
		
		int m=8, n=13;
		
		int[][] grid = new int[m][n];

		
		grid[0][2] = 1;
		grid[0][7] = 1;
		
		grid[1][7] = 1;
		grid[1][8] = 1;
		grid[1][9] = 1;
		
		grid[2][1] = 1;
		grid[2][2] = 1;
		grid[2][4] = 1;

		grid[3][1] = 1;
		grid[3][4] = 1;
		grid[3][5] = 1;
		grid[3][8] = 1;
		grid[3][10] = 1;

		grid[4][1] = 1;
		grid[4][4] = 1;
		grid[4][5] = 1;
		grid[4][8] = 1;
		grid[4][9] = 1;
		grid[4][10] = 1;

		grid[5][10] = 1;
		
		grid[6][7] = 1;
		grid[6][8] = 1;
		grid[6][9] = 1;

		grid[7][7] = 1;
		grid[7][8] = 1;
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] == 1)
					System.out.print("|=|");
				else
					System.out.print(" " + "  ");
			}
			System.out.println("\n");
		}
		
		findMaxArea(grid);

		

		
	}

}
