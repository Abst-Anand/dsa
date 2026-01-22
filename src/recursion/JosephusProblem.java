package src.recursion;

public class JosephusProblem {
	
	static int josephus(int n, int k, int current, int count) {
		if(n == 0) return -1;
		
		if(n == 1) return current;
		
		if(count%k == 0) return josephus(n-1, k, (current+1)%(n-1), count+1);
		
		return josephus(n, k, (current+1)%n, count+1);
		
	}
	
	public static void main(String[] args) {
		int t = josephus(3, 2, 0, 1);
		System.out.println(t);
	}

}
