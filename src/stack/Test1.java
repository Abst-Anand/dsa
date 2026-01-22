package stack;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
	
	 public static void addToMap(HashMap<Integer, List<Integer>> map, Integer key, Integer value) {
	        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
	    }
	
	public static int[] findPair(int input1, int[] input2) {
		int[] res = new int[2];		

		HashMap<Integer, List<Integer>> map = new HashMap<>();
		
		for(int i=0; i< input2.length; i++) {
			for(int j=0; j<input2.length; j++) {
				if(input2[i] + input2[j] == 18) {
		
					map.computeIfAbsent(input2[i], k -> new ArrayList<>()).add(input2[j]);
				}
			}
		}
		int maxProduct = Integer.MIN_VALUE;
		int maxKey = 0;
		int maxValue = 0;
		
		for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			int key = entry.getKey();
            List<Integer> values = entry.getValue();

            for (int value : values) {
                if (key > value) {
                    int product = key * value;
                    if (product > maxProduct) {
                        maxProduct = product;
                        maxKey = key;
                        maxValue = value;
                    }
                }
            }
		}
		res[0] = maxKey;
		res[1] = maxValue;
		
		System.out.println(map);
		return res;
	}
	
	public static void main(String[] args) {
		
		int n =8;
		int[] arr = {20, 16, 2, 1,5};
		
		findPair(n, arr);
		
	}

}
