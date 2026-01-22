package src.etc;

public class MaxSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {3,8,2,4,5,6};
		
		int n = arr.length;
		
		int prevMax = arr[0];
		int res = arr[0];
		
		for(int i=1; i < arr.length; i++) {
			
			prevMax = Math.max(arr[i] , prevMax + arr[i]);
			res = Math.max(prevMax, res);
			
		}
		System.out.println(prevMax);
		System.out.println(res);
		
//		int sum =0;
//		
//		for(int i=0; i<arr.length; i++) {
//			int crr=0;
//			for(int j=i;j<arr.length;j++) {
//				crr += arr[j];
//				System.out.print(arr[j]+" ");
//			}
//			System.out.println();
//			if(crr > sum)
//				sum = crr;
//		}
		//System.out.println(sum);

	}

}
