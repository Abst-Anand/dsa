package src.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex01GenerateNumbers {

	public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter num:");
        int num = in.nextInt();
        in.close();
        
        queue.add(5);
        queue.add(6);
        
        for(int i=0; i< num; i++) {
        	int temp = queue.poll();
        	System.out.print(temp + "\t");
        	temp = temp * 10;
        	
        	queue.add(temp+5);
        	queue.add(temp+6);
        }
		
		
	}

}
