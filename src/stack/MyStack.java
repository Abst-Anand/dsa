package stack;

import java.util.ArrayList;

public class MyStack<T> {
	private ArrayList<T> arr = new ArrayList<T>();	
	private int TOP;
	
	MyStack(){
		TOP = -1;
	}
	
	int push(T newData) {
		
		try {
			TOP++;
			arr.add(newData);
			System.out.println("Pushed -> " + newData);
			return 1;
		}catch(Exception e) {
			System.out.println(e);
			return -1;
		}
	}
	
	T pop() {
		if(arr.isEmpty()) {
			System.out.println("Stack UnderFlow");
			return null;
		}
		System.out.println("Popped");
		return arr.get(TOP--);
	}

	boolean isEmpty() {
		return arr.isEmpty();
	}
	
	int getSize() {
		return TOP+1;
	}

	void printArray() {
		for(int i=TOP; i>=0; i--) {
			System.out.print(arr.get(i) + "\t");
		}
		System.out.println();
//		System.out.println(arr);
	}
	public static void main(String[] aa) {
		MyStack<Integer> stk = new MyStack<>();
		stk.printArray();
		stk.push(51);
		stk.push(50);
	    stk.push(100);
	    stk.push(200);
	    stk.push(300);
	    stk.push(400);
	    stk.push(101);
	    stk.pop();
	    stk.printArray();
	    int res = stk.pop();
	    System.out.println(res);
	    stk.printArray();
	    
	    MyStack<Character> chrStk = new MyStack<>();
	    chrStk.push('A');
	    chrStk.push('B');
	    chrStk.printArray();
	}
}
