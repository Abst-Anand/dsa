package etc;
import java.util.ArrayList;

public class StocksBuyAndSell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {100, 180, 260, 310, 40, 535, 695};
		int curr = arr[1] - arr[0];
		
		ArrayList<Integer> breakPoints = new ArrayList<>();
		
		for(int i = 1 ; i<arr.length; i++) {
			
			if(arr[i] < arr[i-1]) {
				breakPoints.add(i);
			}
		}
		
		if(breakPoints.isEmpty()) {
			System.out.println(0 + " " + (arr.length-1) );
			return;
		}
		
		ArrayList<Integer> pts = new ArrayList<>();
		for(int i=0; i < breakPoints.size(); i++) {
			
			
			
			if(i == 0) {
				pts.add(0);
				pts.add( breakPoints.get(i)-1 );
				pts.add(breakPoints.get(i));
				pts.add(arr.length-1);
			}
			else {
				pts.add(breakPoints.get(i-1));
				pts.add(breakPoints.get(i));
			}
			
			
		}
		//System.out.println(pts.size());
		
		for(int i=1; i < pts.size();i+=2) {
			System.out.println(pts.get(i-1) + " " + pts.get(i));
		}
		

		
		
	}
}
