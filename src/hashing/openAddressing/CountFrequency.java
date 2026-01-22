package hashing.openAddressing;
import java.util.HashMap;
import java.util.Map;


public class CountFrequency {

	static void frequency(int[]arr) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int elem : arr) {
			map.put(elem, map.getOrDefault(elem, 0)+1);		
		}
		
		//print the map
		for(Map.Entry<Integer,Integer> ent : map.entrySet()) {
			System.out.println(ent.getKey() + "->" + ent.getValue());
		}
		
		//to print in the same order of insertion:
		for(int e : arr) {
			System.out.println(e +" "+map.get(e));
		}
		
	}
	
	public static void main(String[]aa) {
		int[] arr = {15,12,13,12,13,18,15};
		frequency(arr);
	}
}
