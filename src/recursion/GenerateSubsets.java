package src.recursion;

public class GenerateSubsets {
	
	static void generateSubsets(String str, String current, int index) {	
		if(index == str.length()) {
			System.out.print(current +", ");
			return;
		}
		generateSubsets(str, current, index+1);
		generateSubsets(str, current+str.charAt(index), index+1);
		
	}
	
	public static void main(String[] args) {
		
		generateSubsets("ABC", "", 0);
	}

}
