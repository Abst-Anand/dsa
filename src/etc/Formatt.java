package src.etc;

import java.text.DecimalFormat;

public class Formatt {
	private static final DecimalFormat decFormat = new DecimalFormat("##,##,##0");
	
	public static String format(double num) {
		
	//	int len = (int) Math.floor(Math.log10(num)+1);
		
		String str = String.valueOf(num);
		StringBuilder formatted = new StringBuilder();
		int len = str.length();
		int group=0;
		for(int i = len-1; i>=0; i--) {
			
			formatted.insert(0, str.charAt(i));
			group++;
			
			if(group==3 && i>0) {
				formatted.insert(0,",");
				group=0;
			}
//			else if(group==2 && i>0) {
//				formatted.insert(0, ",");
//			}
			
		}
		return formatted.toString();
	}
	
	public static void main(String[] aa) {
		double price = 12314;
		
		String formattedPrice = format(price);
		
		double len = Math.floor(Math.log10(price));
		System.out.println(formattedPrice);
		System.out.println( (343)%26);
	}

}
