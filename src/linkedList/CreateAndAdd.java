package linkedList;
import java.util.Scanner;

public class CreateAndAdd {
	int data;
	CreateAndAdd next;
	
	CreateAndAdd(int ndata)
	{
		this.data = ndata;
		this.next = null;
	}
	
	static void printList(CreateAndAdd head)
	{
		CreateAndAdd temp = head;
		while (temp != null)
		{
			System.out.print(temp.data + "  ");
			temp = temp.next;			
		}
	}
	
	static void addAtEnd(CreateAndAdd head , int ndata)
	{
		CreateAndAdd temp = head;
		CreateAndAdd newNode = new CreateAndAdd(ndata);
		
		while(temp != null)
			temp = temp.next;
		
		temp = newNode;
		
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		
		System.out.print("Enter nmbr to be added:");
		int data = in.nextInt();
		in.close();
		
		CreateAndAdd head = new CreateAndAdd(data);
		
		//addAtEnd(head, data);
		addAtEnd(head, 46);
		addAtEnd(head, 47);
		printList(head);
		addAtEnd(head,56);
		

	}

}
