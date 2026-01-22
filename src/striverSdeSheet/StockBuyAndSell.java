package striverSdeSheet;

public class StockBuyAndSell {

	static int maxProfitAfterSelling(int[] prices) {
		int max = 0;
		int currMax = -1;
		
		for(int i = prices.length -1; i>=0; i--) {
			if(prices[i] >  currMax) {
				currMax = prices[i];
			}
			
			int currProfit = currMax - prices[i];
			
			if(currProfit > max) {
				max = currProfit;
			}
		}
		
		System.out.println(max);
		return max;		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {7,6,4,3,1};
		maxProfitAfterSelling(arr);
	}

}
