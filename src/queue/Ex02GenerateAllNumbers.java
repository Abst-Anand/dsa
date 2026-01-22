package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex02GenerateAllNumbers {

	public static void main(String[] args) {


        Queue<Integer> numberQueue = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter num:");
        int num = in.nextInt();
        in.close();
        
        numberQueue.add(0);
        for(int i = 1; i < 10; ++i) {
        	queue.add(i);
        	numberQueue.add(i);
        }
        
        for(int i=1; i<=num; ++i) {
        	int temp = queue.poll();
        	System.out.print(temp + "\t");
        	
        	temp = temp * 10;
        	
//        	int digit = numberQueue.poll();
//        	queue.add(temp + digit);
//        	numberQueue.add(digit);
        	queue.add(temp + 0);
        	queue.add(temp + 1);
        	queue.add(temp + 2);
        	queue.add(temp + 3);
        	queue.add(temp + 4);
        	queue.add(temp + 5);
        	queue.add(temp + 6);
        	queue.add(temp + 7);
        	queue.add(temp + 8);
        	queue.add(temp + 9);
        	if(i%10 == 0) System.out.println();
        	
        }
	
	}

}
