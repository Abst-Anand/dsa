package src.hashing.openAddressing;
import java.util.HashSet;
import java.util.Iterator;

public class Hashset {
	public static void main(String[]aa) {
		
		HashSet<Integer> h = new HashSet<Integer>();
		//order of traversal may differ as that of insertion
		
		h.add(12);
		h.add(56);
		h.add(789);
		
		System.out.println(h);
		System.out.println(h.size());
		
		//h.remove(56);
		System.out.println(h.remove(56));
		System.out.println(h.size());
		
		for(int n : h) {
			System.out.print(n + " ");
		}
		System.out.println();
		System.out.println(h.isEmpty());
		
		//h.clear();
		HashSet hc = (HashSet)h.clone();
		System.out.println(hc);
		
		Iterator<Integer> it = h.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	
	}

}
