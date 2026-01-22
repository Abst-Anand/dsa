package src.hashing.openAddressing;

public class LongestCommonSpanWithSameSum {
	
	static void naiveLongestSpan(int[]arr,int[]brr) {
		
		int s=10000, e = -1, len=0;
		
		for(int i=0;i<arr.length;i++) {
			int sum1=0,sum2=0;
			for(int j=i;j<arr.length;j++) {
				sum1 += arr[j];
				sum2 += brr[j];
				if(sum1 == sum2) {
					len = Math.max(len, j-i+1);
					e = Math.max(e, j);
					s = j-len+1;
				}
			}
		}
		
		System.out.println(s + " " + e);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {0,1,0,1,1,1,1};
		int[] b = {1,1,1,1,1,0,1};
		
		naiveLongestSpan(a, b);

	}

}
