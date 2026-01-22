package sorting;

public class Insertion {
	
	static int[] insertionSort(int[] arr) {
		
		for(int i=1; i<arr.length;i++) {
			
			int current = arr[i];
			int j = i-1;
			while(j>=0 && current < arr[j] ) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = current;
		}
		
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {12,8,5,16,565,-789};
		
		arr = insertionSort(arr);
		
		for(int e : arr)
			System.out.print(e + " ");
	}

}
