package striverSdeSheet;

public class Power {
	
	static double powBrute(double x, int n) {
		double ans = x;
		
		int positiveN = n;
		if(n < 0) positiveN = -1 * n;
		
		for(int i=2; i<=positiveN; i++) {
			ans = ans * x;
		}
		
		if(n < 0) ans = 1 / ans;
		return ans;
	}

	static double pow(double x, int n) {
		
		double ans = 1.0;
		long positiveN = n;
		
		if(n < 0) positiveN = -1 * n;
		
		while(positiveN > 0) {
			//odd
			if(positiveN % 2 == 1) {
				ans = ans * x;
				positiveN--;
			}
			//even
			else {
				x = x * x;
				positiveN /= 2;
			}
		}
		
		if(n<0) ans = 1.0 / ans;		
		
		return ans;		
	}
	
	public static void main(String[] args) {
		
		double x = -2;
		int n = 4;

		System.out.println(powBrute(x, n));
		
		System.out.println(pow(x, n));
	}

}
