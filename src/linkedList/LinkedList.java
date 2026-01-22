package linkedList;

class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
		System.out.println(this.data + "- " + this);
	}
	
}

public class LinkedList {
	Node head;
	int size;
	
	public LinkedList() {
		
	}
	public LinkedList(int data) {
		head = new Node(data);
	}
	
	public int add(int data) {
		if(head == null) {
			head = new Node(data);
			return 1;
		}
		
		Node newNode = new Node(data);
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		return 2;
	}
	
	public void printList() {
		if(head == null) {
			System.out.println("List is Empty");
			return;
		}
		
		Node temp = head;
//		System.out.print("head=" + temp);
		while(temp != null) {
			System.out.print("[data=" + temp.data + ", next=" + temp.next +"] =>");
			temp = temp.next;
		}
		System.out.println();
	}


}
