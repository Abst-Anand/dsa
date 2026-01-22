package src.linkedList;

public class MergeTwoSortedLists {

	public static Node merge(Node head1, Node head2) {
		Node itr1 = head1;
		Node itr2 = head2;
	
		Node dummy = new Node(1);
		Node res = dummy;
		
		while(itr1 != null && itr2 != null) {
			if(itr1.data >= itr2.data) {
				res.next = itr2;
				itr2 = itr2.next;				
			}else {
				res.next = itr1;
				itr1 = itr1.next;
			}
			res = res.next;
			
		}
		if(itr1 != null) {
			res.next = itr1;
		}
		if(itr2 != null) {
			res.next = itr2;
		}
		return dummy.next;
	}
	
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		LinkedList list2= new LinkedList();
		
		
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(7);
		list.add(7);
		list.add(7);
		list.add(7);
		
		list2.add(2);
		list2.add(4);
		list2.add(4);
		list2.add(8);
		
		LinkedList res = new LinkedList();
		res.head = merge(list.head, list2.head);
		res.printList();

	}

}
