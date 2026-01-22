package src.sorting;

public class Bubble {
	static void bubbleSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			
			boolean swapped = false; //for optimization
			
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if(swapped == false) {
				//System.out.println("Already Sorted Array");
				break;
			}
		}

		//return arr;
	}

	public static void main(String[] aa) {
		int arr[] = {12,5,8,16,-789};
		
		 bubbleSort(arr);
		
		for(int e : arr)
			System.out.print(e + " ");

	}

}
