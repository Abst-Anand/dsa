package string;

public class Basics {

	public static void main(String[] args) {
		
		String s1 = "geeks";
		String s2 = "geeks";
		
		if(s1 == s2) 
			System.out.println("Y");
		else
			System.out.println("N");
		
		//s1 = s1 + "forgeeks";
		if(s1 == s2)
			System.out.println("Y");
		else
			System.out.println("N");
		
		String str = new String("geeks");
		
		if(s1 == str)
			System.out.println("Y");
		else
			System.out.println("N");

	}

}
