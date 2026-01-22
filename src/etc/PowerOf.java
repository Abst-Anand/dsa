package src.etc;

import java.text.DecimalFormat;

public class PowerOf {
	
	
	public static double powerOf(double a, int n) {
		if(n==1) {
			return a;
		}
		return a* powerOf(a,n-1);
	}
	
	public static void main(String[] a) {
		
		
		double p = powerOf(2.2,2);
		
		System.out.println(p);
		
		System.out.printf("%.2f",p); // prints upto two decimal places
	}

}
