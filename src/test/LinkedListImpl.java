package src.test;

class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList{
	private Node head;
	
	void add(int value) {
		if(head== null) {
			head = new Node(value);
			return;
		}
		Node newNode = new Node(value);
		
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}
	
	void display() {
		
		if(head == null) {
			System.out.println("Empty List");
			return;
		}
		Node current = head;
		while(current != null) {
			System.out.print(current.data + " => ");
			current = current.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	int size() {
		if(head == null)
			return 0;

		int count = 0;
		Node current = head;
		while(current != null) {
			count++;
			current = current.next;
		}
		
		return count;
	}
	
	public boolean remove(int data) {
		if(head == null) {
			return false;
		}
		
		if(head.data == data) {
			head = head.next;
			return true;
		}
		
		Node current = head;
		while(current.next != null && current.next.data != data) {
			current = current.next;
		}
		if(current.next == null) {
			return false;
		}
		
		current.next = current.next.next;
		return true;
	}
	
	public boolean hasCycle() {
		Node fast = head;
		Node slow = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		
		return false;
	}
}
public class LinkedListImpl {
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		
		list.display();
		
		System.out.println(list.size());
		
		list.remove(300);
		list.display();
		
	}

	
}
