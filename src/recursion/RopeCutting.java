package recursion;

public class RopeCutting {
	
	static int max(int a, int b, int c) {
		int t1 = a>=b ? a : b;
		return t1 >= c ? t1 : c;
	}
	
	static int cutRope(int len, int a, int b, int c) {
		if(len == 0) return 0;
		
		if(len < 0) return -1;
		
		int res = max(cutRope(len-a, a, b, c), cutRope(len-b, a, b, c), cutRope(len-c, a, b, c));
		
		if(res == -1) return -1;
		return 1 + res;			
	}
	
	public static void main(String[] args) {
		System.out.println(cutRope(9,2,2,2));
	}

}
