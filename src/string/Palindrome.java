package src.string;

public class Palindrome {
	
	static boolean isPal(String str) {
		int begin=0;
		int end = str.length()-1;
		
		while(begin < end) {
			if(str.charAt(begin) != str.charAt(end))
				return false;
			begin++;
			end--;
		}
		return true;
	}
	
	public static void main(String[]aa) {
		String s = "ABCXDCBA";
		System.out.println(isPal(s));
	}

}
