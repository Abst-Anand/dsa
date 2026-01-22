package dp;

public class Lcs {
	static int[][] memo;
	static StringBuilder lcs = new StringBuilder();
	
	static int lcs(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		
		System.out.println("s1:" + m + " , " + "s2:" + n);
		int min = Math.min(m, n);
		double time = Math.pow(2, min);
		System.out.println("Operations for naive 2^"+ min + "= " + time);
		System.out.println("Operations for memoized" + "= " + (m*n));

//		int res = lcsNaive(s1.toCharArray(), s2.toCharArray(), m, n);
		
		memo = new int[m+1][n+1];
		for(int i=0; i<m+1; i++) {
			for(int j=0; j<n+1; j++) {
				memo[i][j] = -1;
			}
		}
		long startTime = System.currentTimeMillis(); // Start time
		int res = lcsMemoized(s1.toCharArray(), s2.toCharArray(), m, n);
		long endTime = System.currentTimeMillis(); // End time

        long executionTime = endTime - startTime; // Calculate the execution time
        System.out.println("Execution time in milliseconds: " + executionTime + " ms OR " + (executionTime/1000) + " sec");
  
        return res;
	}
	
	static int lcsNaive(char[] s1, char[] s2, int m, int n) {
	
		if(m==0 || n==0)
			return 0;
		
		if(s1[m-1] == s2[n-1])
			return 1 + lcsNaive(s1, s2, m-1, n-1);
		else
			return Math.max(lcsNaive(s1, s2, m-1, n), lcsNaive(s1, s2, m, n-1));
	}
	
	static int lcsMemoized(char[] s1, char[] s2, int m, int n) {
		
		if(memo[m][n] != -1)
			return memo[m][n];
		
		if(m == 0 || n==0)
			memo[m][n] = 0;
		else {
			if(s1[m-1] == s2[n-1]) {
				memo[m][n] = 1 + lcsMemoized(s1, s2, m-1, n-1);
			}
			else {
				memo[m][n] = Math.max(lcsMemoized(s1, s2, m-1, n), lcsMemoized(s1, s2, m, n-1));
			}
		}
		
		return memo[m][n];
	}
	
	public static void main(String[] args) {
		
//		String s1 = "ABCDABEFGHIJKLMNOPQRSTUVWXYYZABCDEFABCDABEFGHIJKLMNOPQRSTUVWXYYZABCDEFABCDABEFGHIJKLMNOPQRSTUVWXYYZABCDEFABCDABEFGHIJKLMNOPQRSTUVWXYYZABCDEFABCDABEFGHIJKLMNOPQRSTUVWXYYZABCDEFABCDABEFGHIJKLMNOPQRSTUVWXYYZABCDEF";
//		String s2 = "YZABCDEFHIJKLMNOABCDABCDJKLQRSTUVWXYYZABCDYZABCDEFABCDABEFGHIJKLMNOPQRSTUVWXYYZABCDEFHIJKLMNOABCDABCDEFABCDYZABCDEFHIJKLMNOABCDABCDJKLQRSTUVWXYYZABCDYZABCDEFABCDABEFGHIJKLMNOPQRSTUVWXYYZABCDEFHIJKLMNOABCDABCDEFABCD";
		
		String s1 = "XMJYAUZ";
		String s2 = "MZJAWXU";
		
		int res = lcs(s1, s2);
		System.out.println(res);
		
	}

}
