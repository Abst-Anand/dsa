package src.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class CoreValueTest {

	static int[] shuffle(int[] nums, int n) {

		ArrayList<Integer> firstHalf = new ArrayList<>();
		ArrayList<Integer> secondHalf = new ArrayList<>();

		int[] result = new int[nums.length];
		int index = 0;

		for (int i = 0; i < n; i++) {
			firstHalf.add(nums[i]);
		}

		for (int i = n; i < nums.length; i++) {
			secondHalf.add(nums[i]);
		}

//		System.out.println("X terms" + firstHalf);
//		System.out.println("Y terms" + secondHalf);

		for (int i = 0; i < firstHalf.size(); i++) {
			result[index++] = firstHalf.get(i);
			result[index++] = secondHalf.get(i);
		}

		return result;
	}

	static int countAnagramSteps(String s, String t) {
		HashMap<Character, Integer> freq1 = new HashMap<>();
		HashMap<Character, Integer> freq2 = new HashMap<>();

		for (char ch : s.toCharArray()) {

			if (!freq1.containsKey(ch)) {
				int occurance = 0;
				for (int i = 0; i < s.length(); i++) {
					if (ch == s.charAt(i)) {
						occurance++;
					}
				}

				freq1.put(ch, occurance);
			}
		}
//		System.out.println(freq1);

		for (char ch : t.toCharArray()) {

			if (!freq2.containsKey(ch)) {
				int occurance = 0;
				for (int i = 0; i < t.length(); i++) {
					if (ch == t.charAt(i)) {
						occurance++;
					}
				}

				freq2.put(ch, occurance);
			}
		}

//		System.out.println(freq2);
		int steps = -1;
		for(Entry<Character, Integer> ent : freq1.entrySet()) {
			Character ch1 = ent.getKey();
			int freq1Ch1 = ent.getValue();
			int freq2Ch1 = freq2.get(ch1);
			
			steps += Math.abs(freq2Ch1 - freq1Ch1); 
			
			
		}
		return steps;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("==========Q1===========");
		
		System.out.println("Enter Size of Array:");
		int arrSize = in.nextInt();
		
		int[] nums = new int[arrSize];
		System.out.println("Enter the array:");
		for(int i=0; i<arrSize; i++) {
			nums[i] = in.nextInt();
		}
		
		System.out.println("Enter n:");
		int n = in.nextInt();
		

		int[] res = shuffle(nums, n);

		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + ", ");
		}

		System.out.println("\n\n==========Q2===========");
		
		System.out.println("Enter String s:");
		String s = in.next();
		
		System.out.println("Enter String t:");
		String t = in.next();
		
		System.out.println("You have entered s and t as: " + s + ", " + t);

		int res2 = countAnagramSteps(s, t);
		System.out.println(res2);

	}

}
