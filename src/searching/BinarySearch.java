package src.searching;

public class BinarySearch {

	// normal iterative BS
	public static int binarySearchIterative(int[] arr, int value) {
		int low = 0, high = arr.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == value)
				return mid;
			if (arr[mid] > value)
				high = mid - 1;
			if (arr[mid] < value)
				low = mid + 1;
		}
		return -1;
	}

	// first occurence iterative BS
	public static int binarySearchItrFirst(int[] arr, int value) {
		int low = 0, high = arr.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] > value)
				high = mid - 1;
			if (arr[mid] < value)
				low = mid + 1;

			if (arr[mid] == value) {
				if (mid == 0 || arr[mid - 1] != arr[mid])
					return mid;
				else
					// high= mid-1; actual
					return mid - 1;

			}
		}
		return -1;
	}

	// last occurance iterative BS
	public static int binarySearchItrLast(int[] arr, int value) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;

			if (arr[mid] > value)
				high = mid - 1;
			if (arr[mid] < value)
				low = mid + 1;
			if (arr[mid] == value) {
				if ( mid == arr.length - 1 || arr[mid + 1] != arr[mid] )
					return mid;
				else
					low =  mid+1;
			}

		}
		return -1;
	}

	public static int binarySearchRecursive(int[] arr, int low, int high, int value) {
		int mid = (low + high) / 2;

		if (low > high)
			return -1;

		if (arr[mid] == value)
			return mid;
		else if (arr[mid] < value)
			return binarySearchRecursive(arr, mid + 1, high, value);
		else
			return binarySearchRecursive(arr, low, mid - 1, value);
	}

	public static void main(String[] aa) {
		int[] arr = { 1, 2, 3, 4, 5, 5, 5,5,5,5,5,5 }; // 1 2 3 4 5 5 5
		int val = 5;							 // 0 1 2 3 4 5 6
		// System.out.println(binarySearchRecursive(arr, 0, arr.length - 1, val));
		System.out.println(binarySearchItrLast(arr, val));
	}

}
