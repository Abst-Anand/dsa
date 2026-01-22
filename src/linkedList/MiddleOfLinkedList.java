package src.linkedList;

public class MiddleOfLinkedList {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		list.printList();
		
		Node slow = list.head;
		Node fast = list.head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
//		System.out.println("Last Node: [data=" + fast.data + ", next=" + fast.next + "]");
		System.out.println("Mid Node: [data=" + slow.data + ", next=" + slow.next + "]");

		int a =5;
		int b =10;
		
		a = a+b - (b=a);
		
		System.out.println(a);
		System.out.println(b);

		
	}

}
