package linkedList;

public class DetectCycle {
	
	public static boolean checkForCycle(Node head) {
		Node slow = head;
		Node fast = head;
		
		if(head == null)
			return false;
		
		while(slow != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast)
				return true;
		}
		
		return false;
	}
	
	public static void main(String[] aa) {
//		LinkedList list = new LinkedList();
//		
//		list.add(10);
//		list.add(20);
//		list.add(30);
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n1;
				
		
		boolean isCycled = checkForCycle(n1);
		System.out.println(isCycled);
		
	}

}
