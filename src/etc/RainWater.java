package etc;

public class RainWater {

	static void water(int[] arr) {
		int n = arr.length;
		int lmax[] = new int[n];
		int rmax[] = new int[n];

		int res = 0;

		lmax[0] = arr[0];

		for (int i = 1; i < n; i++) {
			lmax[i] = Math.max(arr[i], lmax[i - 1]);
		}

		rmax[n - 1] = arr[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			rmax[i] = Math.max(arr[i], rmax[i + 1]);
		}

		for (int i = 1; i < n - 1; i++) {
			res += (Math.min(lmax[i], rmax[i]) - arr[i]);

		}
		
		System.out.println(res);

	}

	public static void main(String[] args) {

		int arr[] = { 5,0,6, 2, 3 };

		int n = arr.length;

		int wid = n - 2;
		int height = Math.min(arr[0], arr[n - 1]);
		int area = wid * height;
		// System.out.println(area);

		int sum = 0;
		for (int i = 1; i < n - 1; i++) {
			if (arr[i] >= height)
				sum += height;
			else
				sum += arr[i];
		}

		int res = area - sum;

		if (res > 0)
			System.out.println(res);
		else
			System.out.println(0);

		water(arr);

	}

}
