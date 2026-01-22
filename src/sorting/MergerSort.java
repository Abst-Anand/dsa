package sorting;

public class MergerSort {
	
	
	public static int[] merger(int[] arr, int low,int mid, int high) {
		int[] result = new int[arr.length];
		int ind=0;
		int i,j;
		for(i=0,j=mid+1; i<=mid && j<=high;) {
			
			if(arr[i] <= arr[j]) {
				result[ind++] = arr[i];
				i++;
			}
			else {
				result[ind++] = arr[j];
				j++;
			}
		}
		while(i<=mid)
			result[ind++] = arr[i++];
		while(j<=high)
			result[ind++] = arr[j++];
			
		return result;
	}
	public static void merge(int[] arr, int low, int mid, int high) {
		
		int n1 = mid - low + 1; //number of elements in left array including the mid 
		int n2 = high - mid;    //number of elements in right array from mid+1 to last 
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		
		for(int i=0; i<n1; i++) 
			left[i] = arr[low + i];
		
		for(int i=0; i<n2; i++)
			right[i] = arr[n1+i];
		
		int i=0,j=0,k=0;
		
		while(i<n1 && j<n2){
			if(left[i] <= right[j]) {
				arr[k] = left[i];
				k++;
				i++;
			}
			else {
				arr[k] = right[j];
				k++;
				j++;
			}
			
		}
		while(i<n1)
			arr[k++] = left[i++];
		while(j<n2)
			arr[k++] = right[j++];
			
	}

	public static void main(String[] args) {
		int[] arr = {10,20,50,5,50,50};
		merge(arr,0,2,5);
		
		for( int e : arr) {
			System.out.print(e+ " ");
		}
		
		

	}

}
