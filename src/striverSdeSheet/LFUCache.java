package striverSdeSheet;

import java.util.Map;
import java.util.HashMap;

class NodeLFU{
	NodeLFU previousNode;
	int key;
	int value;
	int frequency;
	NodeLFU nextNode;
	
	public NodeLFU(int key, int value) {
		previousNode = null;
		this.key = key;
		this.value = value;
		frequency = 0;
		nextNode = null;
	}
	
	public static NodeLFU insert(NodeLFU head, int key, int value, int frequency) {
		// create a new node for given key, value pair
		NodeLFU newNode = new NodeLFU(key, value);
		newNode.frequency = frequency;
		
		// set the new node next to head
		newNode.nextNode = head.nextNode;
		newNode.previousNode = head;
		
		newNode.nextNode.previousNode = newNode;

		// update head's next pointer
		head.nextNode = newNode;
		
		return newNode;
	}
	
	public static void display(NodeLFU head) {
	    NodeLFU temp = head.nextNode;
	    while(temp.nextNode != null) {
	        System.out.print("[" + temp.key + ":" + temp.value + "|f:" + temp.frequency + "] -> ");
	        temp = temp.nextNode;
	    }
	    System.out.println("null");
	}

	
	public static void deleteNode(NodeLFU node) {
		node.previousNode.nextNode = node.nextNode;
		node.nextNode.previousNode = node.previousNode;
	}
	
	public static NodeLFU getNodeWithLowestFrequency(NodeLFU head) {
		NodeLFU temp = head.nextNode;
		int min = Integer.MAX_VALUE;
		NodeLFU node = null;
		
		while(temp.nextNode != null) {
			if(temp.frequency <= min) {
				min = temp.frequency;
				node = temp;
			}
			temp = temp.nextNode;
		}
		return node;
	}
	
	public static NodeLFU deleteNodeWithLowestFrequency(NodeLFU head) {
		NodeLFU node = getNodeWithLowestFrequency(head);
		NodeLFU.deleteNode(node);
		return node;
	}
	
	@Override
	public String toString() {
		String prev = (previousNode == null) ? "null" : Integer.toHexString(previousNode.hashCode());
		String next = (nextNode == null) ? "null" : Integer.toHexString(nextNode.hashCode());
		
		return "NodeLFU [previousNode=" + prev + ", key=" + key + ", value=" + value + ", frequency=" + frequency + ", nextNode=" + next +"]";
	}
	
}

public class LFUCache {
	int capacity;
	Map<Integer, NodeLFU> map;
	NodeLFU head;
	NodeLFU tail;
	
	public LFUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		head = new NodeLFU(-1, -1);
		tail = new NodeLFU(-1, -1);
		head.nextNode = tail;
		tail.previousNode = head;
	}
	
	public int get(int key) {
		if(!map.containsKey(key)) return -1;
		
		NodeLFU node = map.get(key);
		
		NodeLFU.deleteNode(node);
		NodeLFU temp = NodeLFU.insert(head, key, node.value, ++node.frequency);
		
		map.remove(key);
		map.put(key, temp);
		return node.value;
	}
	
	public void put(int key, int value) {
		if(capacity == 0) return;
		int freq = -1;
		if(map.containsKey(key)) {
			NodeLFU existing = map.get(key);
			freq = existing.frequency;
			NodeLFU.deleteNode(existing);
			map.remove(key);
		}else if(map.size() >= capacity) {
			NodeLFU node = NodeLFU.deleteNodeWithLowestFrequency(head);
			map.remove(node.key);
			System.out.println("Evicted: " + node);
		}
		NodeLFU newNode;
		if(freq == -1)
			newNode = NodeLFU.insert(head, key, value, 0);
		else
			newNode = NodeLFU.insert(head, key, value, freq+1);
		
		map.put(key, newNode);
	}
	
	public static void main(String[] args) {
		
		LFUCache cache = new LFUCache(2);

		cache.put(1, 10); 
		NodeLFU.display(cache.head);
		System.out.println();
		
		cache.put(2, 20); 
		NodeLFU.display(cache.head);
		System.out.println();

	}

}
