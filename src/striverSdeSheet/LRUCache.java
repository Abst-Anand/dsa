package src.striverSdeSheet;

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

class Node{
	Node previousAddress;
	int key;
	int value;
	Node nextAddress;
	
	public Node(int key, int value){
		this.key = key;
		this.value = value;
		nextAddress = null;
		previousAddress = null;
	}

	@Override
	public String toString() {
	    String prev = (previousAddress != null) ? "Node@" + Integer.toHexString(previousAddress.hashCode()) : "null";
	    String next = (nextAddress != null) ? "Node@" + Integer.toHexString(nextAddress.hashCode()) : "null";

	    return "Node [previousAddress=" + prev + ", key=" + key + ", value=" + value + ", nextAddress=" + next + "]";
	}

	public static Node insert(Node head, int key, int value) {
		Node newNode = new Node(key, value);
		newNode.nextAddress = head.nextAddress;
		newNode.previousAddress = head;
		head.nextAddress.previousAddress = newNode;
		head.nextAddress = newNode;
		
		return newNode;
	}
	
//	public static void delete(Node tail) {
//		Node temp = tail.previousAddress;
//		tail.previousAddress = temp.previousAddress;
//		temp.previousAddress.nextAddress = tail;
//	}
	
	public static void deleteNode(Node node) {
		node.previousAddress.nextAddress = node.nextAddress;
		node.nextAddress.previousAddress = node.previousAddress;
	}
	
	public static void displayList(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp);
			temp = temp.nextAddress;
		}
	}
		
}

public class LRUCache {
	
	int CAPACITY;
	Node head;
	Node tail;
	Map<Integer, Node> cache;
	
	public LRUCache(int capacity) {
		this.CAPACITY = capacity;
		cache = new HashMap<Integer, Node>(capacity);
	}
	
	int get(int key) {
		if(!cache.containsKey(key)) return -1;
		Node node = cache.get(key);
		Node.deleteNode(node);
		Node temp = Node.insert(head, node.key, node.value);
		cache.put(temp.key, temp);
		return temp.value;
	}
	
	void put(int key, int value) {
		System.out.println("CACHE SIZE: " + cache.size());
		if(cache.containsKey(key)) {
			Node existing = cache.get(key);
			Node.deleteNode(existing);
			cache.remove(key);
		}
		else if(cache.size() >= CAPACITY) {
			cache.remove(tail.previousAddress.key);
			Node.deleteNode(tail.previousAddress);
		}
		
		
		Node newNode = Node.insert(head, key, value);
		cache.put(key, newNode);
	}
	
	public void printMap() {
		
		for(Entry<Integer, Node> ent : cache.entrySet()) {
			System.out.println(ent.getKey() + ", " + ent.getValue());
		}
	}

	public static void main(String[] args) {
		Node head = new Node(-1,-1);
		Node tail = new Node(-1,-1);
		System.out.println("Head Address=" + Integer.toHexString(head.hashCode()));
		System.out.println("Tail Address=" + Integer.toHexString(tail.hashCode()));
		head.nextAddress = tail;
		tail.previousAddress = head;
		
		LRUCache cache = new LRUCache(3);
		cache.head = head;
		cache.tail = tail;
		
		cache.put(1, 10);
		cache.put(2, 20);
		cache.put(3, 30);
		
		Node.displayList(head);
		
		cache.put(4, 40);
		Node.displayList(head);

		int temp = cache.get(3);
		System.out.println(temp);
		
		Node.displayList(head);
		
		cache.put(4, 500);
		Node.displayList(head);
		
		cache.printMap();
		

//		Node.displayList(head);
//		
//		Node.insert(head, 10, 20);
//		Node.insert(head, -20, 90);
//		Node.insert(head, 100, 200);
//		
//		Node.displayList(head);
//		
//		Node temp = tail.previousAddress.previousAddress;
//		Node.deleteNode(temp);
//		Node.insert(head, temp.key, temp.value);
//		System.out.println();
//		Node.displayList(head);

	}

}
