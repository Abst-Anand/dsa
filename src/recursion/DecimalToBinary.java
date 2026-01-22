package recursion;

public class DecimalToBinary {
	
	static long decimalToBinary(int num) {
		 
		if(num == 0)
			return 0;
		long res = decimalToBinary(num/2);		
		res = 10 * res;
		res += num%2;
		return res;
	}
	
	public static void main(String[] args) {
		long t = decimalToBinary(170000);
		System.out.println(t);		
	}
	

}
