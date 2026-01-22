package etc;

public class ZigZag {

	

	public static void main(String[] args) {


		int[] arr = {11,12,13,14,15,45,78};
		
		int[] b = new int[arr.length];
		int c=0;
		
		for(int i=arr.length/2,j=1; c < arr.length;i = i+(int)Math.pow(-1, j+1)*j,j++) {
			b[i] = arr[c];
			c++;
			
		}
		
		for(int e:b) {
			System.out.print(e + " ");
		}
	}

}
