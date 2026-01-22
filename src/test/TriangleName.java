package src.test;

public class TriangleName {
	
	public static void main(String[]aa) {
		
		
	
		
		String fname = "Ananda";
		String lname = "Rajqw";
		String side3="Silicon";
		
		int len = fname.length();
		int ind=0;
		int rlen=1;
		int i2=0;
		
		int remp=2;
		for(int i=len;i>=0 && ind<len;i--) {
			
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}
			
			
			System.out.print(fname.charAt(ind));
			ind++;
			
			
			
			if(i!=len) {
				for(int j=1;j<remp;j++) {
					System.out.print(" ");
					//System.out.print(lname.charAt(j));
				}
				if(i2<lname.length())
				System.out.print(lname.charAt(i2++));
			}
			remp+=2;
				
			
			System.out.println();
			
			
		}
		
		for(int i=0;i<side3.length();i++) {
			System.out.print(""+side3.charAt(i) + " ");
		}
	}
			
	
}
