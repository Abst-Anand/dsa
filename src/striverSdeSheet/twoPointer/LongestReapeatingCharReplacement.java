package src.striverSdeSheet.twoPointer;

// TODO given a string, find the longest substring with same letter and you are allowed to change any k letters.

public class LongestReapeatingCharReplacement {

	static int getLongestSubstringWithKCharFlips(String str, int k) {
		int maxLen = 0;
		int start = 0;
		int end = 0;
		
		for(int i=0; i<str.length(); i++) {
			int[] freq = new int[26];
			int maxFreq = 0;
			
			for(int j=i; j<str.length(); j++) {
				freq[str.charAt(j) - 'A']++;
				maxFreq = Math.max(maxFreq, freq[str.charAt(j)-'A']);
				int len = j - i + 1;
				if(len - maxFreq <= k) {
					if(len > maxLen) {
						maxLen = len;
						start = i;
						end = j;
					}
				}else {
					break;
				}
			}
		}
		System.out.println(start + ", " + end);
		System.out.println(str.substring(start, end+1));
		System.out.println(maxLen);
		return maxLen;
	}
	
	static int getLongestSubstringWithKCharFlipsOptimal(String str, int k) {
		int maxLen = 0;
		int start = 0;
		int end = 0;
		int left = 0;
		int right = 0;
		
		int[] freq = new int[26];
		int maxFreq = 0;
		while(right < str.length()) {
			int index = str.charAt(right) - 'A';
			freq[index]++;
			maxFreq = Math.max(maxFreq, freq[index]);
			
			int change = (right - left + 1) - maxFreq;
			
			if(change <= k) {
				if(right - left +1 > maxLen) {
					maxLen = right - left + 1;
					start = left;
					end = right;
				}
			}else {
				freq[str.charAt(left)-'A']--;
				left++;
				maxFreq = 0;
				for(int i=0; i<freq.length; i++) {
					maxFreq = Math.max(maxFreq, freq[i]);
				}
			}
			right++;
		}
		System.out.println(start + ", " + end);
		System.out.println(str.substring(start, end+1));
		System.out.println("optimal:"+maxLen);
		return maxLen;
	}
	
	public static void main(String[] args) {
		String str = "BAAAABBAAAAD";
		int k = 1;
		getLongestSubstringWithKCharFlips(str, k);
		getLongestSubstringWithKCharFlipsOptimal(str, k);
	}
}
