package linkedList;

public class ReverseNodesInKGroups {
	
	public static Node reverse(Node head) {
		if(head == null) {
			return null;
		}
		Node previous = null;
		Node current = head;
		
		while(current != null) {
			Node temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		System.out.println("Reversed head:" + previous);
		return previous;
	}
	
	public static Node reverseInGroups(Node head, int k) {
		Node current = head;
		Node ans = null;
		
		for(int i=0; i<k; i++) {
			System.out.println(i);
			int count = 0;
			Node temp = null;
			while(count <= k && current != null) {
				temp = current;
				current = current.next;
				System.out.println(count);
				count++;
			}
			
			if(ans == null) {
				ans = reverse(head);
			}
				else {
				while(ans.next != null) {
					ans = ans.next;
				}
				ans.next = reverse(temp);
			}
		}
		
		return ans;
	}
	
	public static Node test(Node node, int k) {
		Node temp = node;
		Node ans = null;
		
		while(temp != null) {
			int count = 0;
			Node ptr = temp;
			while(count <k && ptr != null) {
				count++;
				temp = ptr;
				ptr = ptr.next;
			}
			System.out.println(count);
			Node t = temp;
			if(temp.next != null) {
				t= temp.next;
			}

			if(count == k) {
				temp.next = null;
				if(ans == null) {
					ans = reverse(node);
					node.next = t;
				}else {
					Node y = reverse(node.next);
					node.next = y;	
					node = y;
				}			
				if(temp != t)
				temp = t;
			}else {
				node.next = t;
				temp = temp.next;
			}
		}
		return ans;
		
	}

	public static Node newTest(Node head, int k) {
		if(head == null || k <=1) return head;
		
		Node dummy = new Node(1);
		dummy.next = head;
		Node current = head;
		Node prevGroupEnd = dummy;
		
		while(current!=null) {
			int count = 1;
			Node ptr = current;
			
			while(count <k && ptr.next != null) {
				count++;
				ptr= ptr.next;
			}
			
			if(count < k) break;
			
			Node nextGroupStart = ptr.next;
			ptr.next = null;
			
			Node reversedHead = reverse(current);
			
			prevGroupEnd.next = reversedHead;
			
			prevGroupEnd = current;
			
			current = nextGroupStart;
			
		}
		
		prevGroupEnd.next = current;
		return dummy.next;
	}
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
//		list.add(70);
		
		list.head = newTest(list.head, 2);
		list.printList();
//		list.head = reverse(list.head);
//		list.printList();

//		list.head = reverseInGroups(list.head, 2);
//		list.printList();
	}

}
