package striverSdeSheet;

public class LongestSubStringWithoutRepeatingChar {
	
	static void maxLenNaive(String str) {
		int left = 0, right = 0;
		int max = -1;
		
		for(int i=0; i<str.length(); i++) {
			int[] freq = new int[256];			
			
			for(int j=i; j<str.length(); j++) {
				if(freq[str.charAt(j)] >= 1) break;
				
				freq[str.charAt(j)]++;
				
				if(j-i+1 > max) {
					max = j - i + 1;
					right = j;
					left = i;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(left + ", " + right);
		System.out.println(str.substring(left, right+1));
		
	}

	static String getLongestSubStringWithoutRepeatation(String str) {
			
		int left = 0;
		int right = 0;
		int maxLen = 0;
		int s=-1, e=-1;
		int[] hash = new int[256];
		
		for(int i=0; i<hash.length; i++) {
			hash[i] = -1;
		}
		
		while(right < str.length()) {
			if(hash[str.charAt(right)] >= left) {
				left = hash[str.charAt(right)] + 1;					
			}
			hash[str.charAt(right)] = right;
		
			if(right - left + 1 > maxLen) {
				maxLen = right - left + 1;
				s=left;
				e=right;
			}
			hash[str.charAt(right)] = right;
			right++;
		}
		System.out.println(maxLen);
		System.out.println(s + ", " + e);
		System.out.println(str.substring(s,e+1));
		return str.substring(s, e+1);
	}
	
	public static void main(String[] args) {

		String str = "abcabcbb";
		maxLenNaive(str);
		System.out.println("======");
		getLongestSubStringWithoutRepeatation(str);


	}

}
