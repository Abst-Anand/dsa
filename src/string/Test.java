package src.string;

public class Test {

	public static void main(String[] aa) {
		
		
		for (int i = 0; i < 8; i++) {
		  for (int j = 0; j < 8; j++) {
              // Generate a unique ID for each cell
              String cellId = Character.toString((char)('a' + j)) + i;
              System.out.print(cellId + "  ");
		  }
		  System.out.println();
		  
		}

	}

}
