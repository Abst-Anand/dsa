package src.recursion;

public class LogCalculator {
	
	static float log(int base, float num) {
		if(num < base)
			return 0;
		
		return 1 + log(base, num/base);
	}
	
	static int log2(int num) {
		if(num == 1)
			return 0;
		return 1 + log2(num/2);
	}
	
	public static void main(String[] args) {
		
		System.out.println(log2(32));
	}

}
