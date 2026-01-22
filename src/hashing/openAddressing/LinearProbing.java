package src.hashing.openAddressing;


class HashTable{
	int size;
	int m;
	int[] table;
	int init = -1;
	
	public HashTable(int n){
		size = n;
		m = n;
		table = new int[n];
		for(int i=0; i<n;i++){
			table[i] = init;
		}
	}
	
	int hash(int key) {
		return key % m;
	}
	
	int linearProbe(int index) {
		 
		int i = index;
		
		while(table[i] != -1) { //linear probing
			i = (i+1) % m;
		}
		return i;
	}
	
	public boolean insert(int key) {
		int h = hash(key);
		int i = h;
		
		
		i = linearProbe(i);
		
		if(i < size) {
			table[i] = key;
			return true;
		}
		
		return false;
	}
	
	boolean erase(int key) {
		int h = hash(key);
		int i = h;
		
		
		while(table[i] != key) {
			i = (i+1) % m;
			if(i == h) //if again reaches the same place then not present 
				break;
		}
		
		if(i < size && table[i] == key) {
			table[i] = init;
			return true;
		}
		
		return false;
	}
	
	boolean search(int key) {
		int h = hash(key);
		int i = h;
		
		while(table[i] != key) {
			i = (i+1) % m;
			if(i == h)
				break;
		}
		if(i < size && table[i] == key) {
			System.out.println("Found");
			return true;
		}
		
		System.out.println("Not Found");
		return false;
	}
	
	void print() {
		for(int i:table) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
public class LinearProbing {
	
	public static void main(String[] aa) {
		
		HashTable tbl = new HashTable(7);
		
		tbl.insert(49);
		tbl.print();
		tbl.insert(56);
		tbl.print();
		tbl.insert(57);
		tbl.print();
		tbl.insert(55);
		tbl.print();
		tbl.erase(45);
		tbl.print();
		tbl.search(25);
	}
	
	
	

}
