package linkedList;

public class RemoveNthNodeFromEnd {
	
	public static Node removeNthNodeFromEnd(Node head, int n) {
		
		Node slow = head;
		Node fast = head;
		Node prev = slow;
		
		for(int i=0; i<n; i++) {
			if(fast.next == null) {
				System.out.println("List not long enough");
				return null;
			}
			fast = fast.next;
		}
		
		while(fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next;
		}
		System.out.println(slow.data);
		prev.next = slow.next;
		
		return head;
	}

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.printList();
		removeNthNodeFromEnd(list.head, 8);
		list.printList();

	}

}
