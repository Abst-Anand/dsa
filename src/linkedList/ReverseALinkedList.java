package linkedList;

public class ReverseALinkedList {
	
	public static LinkedList reverseList(LinkedList list) {
		
		LinkedList ans = new LinkedList();
		
		Node previous = null;
		Node current = list.head;
		Node temp = null;
		
		while(current.next != null) {
			temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;	
		}
		temp.next = previous;
		
		ans.head = temp;
		return ans;
		
	}

	public static void main(String[] args) {


		LinkedList list = new LinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.printList();
		list = reverseList(list);
		list.printList();

	}

}
