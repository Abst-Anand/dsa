package src.string;

public class SubSequence {
	
	static boolean isSubSequence(String str, String s1) {
		
		int j=0;
		for(int i=0;i<str.length() && j<s1.length();i++) {
			if(str.charAt(i) == s1.charAt(j))
				j++;
		}
		
		return (j==s1.length());
	}

	public static void main(String[]aa) {
		String s = "ABCDE";
		String sub = "ADA";
		
		System.out.println(isSubSequence(s, sub));
	}
}
