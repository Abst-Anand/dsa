package linkedList;

public class AddTwoNumbersL2 {
	
	public static int addTwoNumber(LinkedList list1, LinkedList list2) {
		
		Node head1 = list1.head;
		Node head2 = list2.head;
		
		int num1 = 0;
		int num2 = 0;
		
		while(head1 != null) {
			num1 = num1 * 10 +  head1.data;	
			head1 = head1.next;
		}
		
		while(head2 != null) {
			num2 = num2 * 10 +  head2.data;	
			head2 = head2.next;
		}
		
		int temp = num1;
		num1 = 0;
		while(temp != 0) {
			num1 = num1 * 10 + temp%10;
			temp = temp / 10;
		}
		
		temp = num2;
		num2 = 0;
		while(temp != 0) {
			num2 = num2 * 10 + temp%10;
			temp = temp / 10;
		}
		
		return num1 + num2;
	}
	
	

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		list1.add(5);
		list1.add(2);
		list1.add(8);		
		list1.printList();
		
		list2.add(9);
		list2.add(6);
		
		list2.printList();
		
		
		int res = addTwoNumber(list1, list2);
		System.out.println("Result:" + res);
		

	}

}
