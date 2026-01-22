package recursion;

public class SumOfSubsets {
	
	
	static void sumOfSubsets(int[] arr, int sum, int index, int current) {
		
		if(index == arr.length) {
			System.out.println(current);
			return;
		}
		sumOfSubsets(arr, sum, index+1, current);
		sumOfSubsets(arr, sum, index+1, arr[index]);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 5, 2, 3, 6};
		int sum = 8;
		System.out.println();
		sumOfSubsets(arr, sum, 0, 0);

	}

}
