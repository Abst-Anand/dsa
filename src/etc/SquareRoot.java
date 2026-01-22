package etc;

public class SquareRoot {
	static double getSquareRoot(double num) {
	    double left = 0, right = num;
	    double epsilon = 1e-6;  // precision level

	    while ((right - left) > epsilon) {
	        double mid = (left + right) / 2;
	        double midSquared = mid * mid;

	        if (Math.abs(midSquared - num) < epsilon) {
	            return mid;
	        } else if (midSquared < num) {
	            left = mid;
	        } else {
	            right = mid;
	        }
	    }

	    return (left + right) / 2;  // final approximation
	}


	public static void main(String[] args) {


		double sqrt = getSquareRoot(16);
		System.out.println(sqrt);

	}

}
