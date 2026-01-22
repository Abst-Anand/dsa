package hashing.openAddressing;
import java.util.HashMap;
import java.util.Map;


public class Hashmap {
	
	public static void main(String[]aa) {
		
		HashMap<String,Integer> map = new HashMap<>();
		
		map.put("gg", 1);
		map.put("br", 23);
		
		
		System.out.println(map);
		
		for(Map.Entry<String, Integer> e : map.entrySet()) {
			
			String key = e.getKey();
			Integer i = e.getValue();
			System.out.println(key +" " + i);
			
		}
		
	}

}
