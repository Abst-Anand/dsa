package src.striverSdeSheet;

import java.util.Arrays;

public class SetZeroMatrix {
	
	
	static int[][] makeZero(int[][] mat, int i, int j) {
		
		int rows = mat.length;
		int cols = mat[0].length;
		System.out.println(rows + " ," + cols);
		//moving along column 
		for(int x=0; x<rows; x++) {
			mat[x][j] = 0;
		}
		
		//moving along row
		for(int x=0; x<cols; x++) {
			mat[i][x] = 0;
		}
		
		
		return mat;
	}

	public static void main(String[] args) {
		
		int[][] mat = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
		System.out.println(Arrays.deepToString(mat));
		
		int[][] res = new int[mat.length][mat[0].length];
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[0].length; j++) {
				res[i][j] = mat[i][j];
			}
		}
		
		
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[0].length; j++) {
				if(mat[i][j] == 0) {
					res = makeZero(res, i, j);
				}
			}
		}
		System.out.println(Arrays.deepToString(res));
		

	}

}
