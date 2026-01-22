package src.graph;

public class CountCoinCombinations {
	static int callCount = 0;
	
	static int countCoincombinationsNaive(int[] coins, int n, int sum) {
		/* arr = {1, 2, 3} and sum = 4
		 * result = 4 as total 4 combinations are possible using given coins with infinite supply
		 * */
		callCount++;
		System.out.println(callCount +":arr, " + n +", " + sum);
		if (sum == 0)
			return 1;
		
		if(n == 0)
			return 0;
		
		int result = countCoincombinationsNaive(coins, n-1, sum);
		
		if(coins[n-1] <= sum) {
			result = result + countCoincombinationsNaive(coins, n, sum- coins[n-1]);
		}
		
		System.out.println(callCount + ": returning=" + result);
		
		return result;		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1};
		int sum = 4;
		
		System.out.println(countCoincombinationsNaive(arr, arr.length, sum));
		System.out.println(callCount);
		
	}

}
