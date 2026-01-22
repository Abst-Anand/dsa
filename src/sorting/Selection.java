package sorting;

public class Selection {
	// less memory writes 
	static int[] selectionSort(int[] arr) {
		
		for(int i = 0;i<arr.length;i++) {
			int min = arr[i];
			int ind=i;
			for(int j = i; j<arr.length;j++) {
				if(arr[j] < min) {
					min = arr[j];
					ind = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[ind];
			arr[ind] = temp;
		}
		return arr;
	}
	
	public static void main(String[] aa) {
		int arr[] = {12,8,5,16,565,-789};
		
		arr = selectionSort(arr);
		
		for(int e : arr)
			System.out.print(e + " ");
	}

}
