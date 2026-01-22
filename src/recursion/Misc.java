package recursion;

public class Misc {
	
	static void printTill1(int num) {
		if(num == 0) return;
		System.out.print(num + "\t");
		printTill1(num-1);
	}
	
	static void printTillN(int num) {
		if(num == 0) return;
		printTillN(num - 1);
		System.out.print(num + "\t");
	}
	
	static int factorial(int num) {
		if(num == 0) return 1;
		return num * factorial(num-1);
	}
	
	static int fibonacci(int n) {
		
		if(n < 0) return -1;
		if(n <= 1) return n;
		if(n == 2) return 1;
		
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	static int sumUptoN(int n) {
		if(n <=1) return n;
		return n + sumUptoN(n-1);
	}
	public static void main(String[] args) {
//		printTill1(5);
//		System.out.println();
//		printTillN(5);
//		
//		System.out.println();
//		System.out.println(factorial(5));
//		System.out.println(fibonacci(10));
//		
		System.out.println(sumUptoN(-1));
	}

}
