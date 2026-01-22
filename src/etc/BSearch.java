package etc;

public class BSearch {
	public static int bs(int[] arr, int num) {
		int low=0, high = arr.length-1;
		
		while(low <= high ) {
			int mid = (low + high)/2;
			
			if(arr[mid] == num) {
				return mid;
			}
			
			else if(arr[mid] > num) {
				high = mid - 1;
			}
			else if(arr[mid] < num) {
				low = mid + 1;
			}
		}
			
		
		return -1;
	}
	
	public static int bsfirst(int[] arr, int num) {
		
		int low =0, high = arr.length-1;
		
		while(low <= high) {
			int mid = (low + high)/2;
			
			if(arr[mid] > num)
				high = mid - 1;
			if(arr[mid] < num)
				low = mid + 1;
			
			else {
				if(mid == 0 || arr[mid] != arr[mid-1])
					return mid;
				high = mid - 1;
			}
		}
		
		return -1;
	}
	public static int bslast(int[] arr,int num) {
		int low=0,high=arr.length-1;
		
		while(low <= high) {
			int mid = (low + high)/2;
			if(arr[mid] > num)
				high = mid - 1;
			if(arr[mid] < num)
				low = mid + 1;
			else {
				if(mid == arr.length || arr[mid] != arr[mid+1])
					return mid;
				low = mid + 1;
			}
		}
		return -1;
		
	}
	
	public static void main(String[] aa) {
		
		int[] arr = {1,2,5,74,74,74,85};
		
		//neither first nor last
		int n = bs(arr,74);
		
		if(n != bsfirst(arr,74) && n != bslast(arr,74))
			System.out.println(n);
		
		
	}
	


}
