package striverSdeSheet;

import java.util.ArrayList;

public class PascalTriangle {
	
	private static long findNcR(int n, int r) {
		long ans = 1L;
		
		for(int i=0; i<r; i++) {
			ans = ans * (n-i);
			ans = ans / (i+1);
		}
		
		return ans;
	}
	
	//variation 1: given row number(r) and col number(c), print the element at position (r, c)
	static long printAnElement(int row, int col) {
		return findNcR(row-1, col-1);
	}
	
	//variation 2: given row number(N), print entire Nth row
	static ArrayList<Long> printNthRow(int n){
		if(n == 0) return null;
		
		ArrayList<Long> ans = new ArrayList<>();
		long currentElement = 1L;
		ans.add(currentElement);
		
		for(int col=1; col<=n-2; col++) {
			currentElement = currentElement * (n - col);
			currentElement = currentElement / col;
			ans.add(currentElement);
		}
		if(n != 1) ans.add(1L);
		
		return ans;
	}
	
	//variation 3: given number of rows(n), print first n rows of Pascal's Triangle
	static ArrayList<ArrayList<Long>> printFirstNRows(int n){
		ArrayList<ArrayList<Long>> ans = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			ans.add(printNthRow(i));
		}
		
		return ans;
	}

	public static void main(String[] args) {
		
		
		System.out.println(printAnElement(8, 3));
		
		System.out.println(printNthRow(3));
		
		System.out.println(printFirstNRows(8));

	}

}
