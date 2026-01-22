package etc;

public class MaxDiiference {
	static int maxDiffG(int[] arr) {
		int minElem = arr[0];
		int diff = arr[1] - arr[0];
		for(int i=0;i<arr.length;i++) {
			if( (arr[i] - minElem) > diff) {
				diff = arr[i] - minElem;
			}
			if(arr[i] < minElem) {
				minElem = arr[i];
				
			}
			
			
		}
		return diff;
	}
	public static void main(String[] args) {
		
		int[] arr = {2,3,10,6,4,8,1};
		
		int maxDiff = arr[1] - arr[0];
		
		for(int i=0;i<arr.length;i++) {
			
			for(int j= i+1;j<arr.length;j++) {
				if( (arr[j] - arr[i]) > maxDiff)
					maxDiff = arr[j] - arr[i];
			}
		}
		
		System.out.println(maxDiffG(arr));
	}

}
