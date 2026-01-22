package src.striverSdeSheet;

import java.util.ArrayList;
import java.util.List;

public class MergeOverlappingSubIntervals {
	
	static void swapTwoIntervals(ArrayList<ArrayList<Integer>> intervals, int i, int j) {
		ArrayList<Integer> temp = intervals.get(i);
		intervals.set(i, intervals.get(j));
		intervals.set(j, temp);
	}
	
	static void sortIntervals(ArrayList<ArrayList<Integer>> intervals) {
		for(int i=0; i<intervals.size(); i++) {
			int start = intervals.get(i).get(0);
			int end = intervals.get(i).get(1);
			
			for(int j=i+1; j<intervals.size(); j++) {
				int currentStart = intervals.get(j).get(0);
				int currentEnd = intervals.get(j).get(1);
				
				if(start > currentStart) {
					swapTwoIntervals(intervals, i, j);
				}
				else if(start == currentStart) {
					if(end > currentEnd) {
						swapTwoIntervals(intervals, i, j);
					}
				}
			}
		}
		
	}
	
	static ArrayList<ArrayList<Integer>> mergeOverlaps(ArrayList<ArrayList<Integer>> intervals) {
		sortIntervals(intervals);
		System.out.println("Sorted:" + intervals);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ans.add(intervals.get(0));
		
		for(int i=1; i<intervals.size(); i++) {
			int start = intervals.get(i).get(0);
			int end = intervals.get(i).get(1);
			
			if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)) {
				continue;
			}
			
			if(start <= ans.get(ans.size()-1).get(1)) {
				int max = Math.max(end, ans.get(ans.size()-1).get(1));
				ans.get(ans.size()-1).set(1, max);
			}else {
				ans.add(new ArrayList<>(List.of(start,end)));

			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();
		ArrayList<Integer> t1 = new ArrayList<>();
		ArrayList<Integer> t2 = new ArrayList<>();
		ArrayList<Integer> t3 = new ArrayList<>();
		ArrayList<Integer> t4 = new ArrayList<>();
		ArrayList<Integer> t5 = new ArrayList<>();
		ArrayList<Integer> t6 = new ArrayList<>();
		ArrayList<Integer> t7 = new ArrayList<>();
		ArrayList<Integer> t8 = new ArrayList<>();
		t1.add(1);
		t1.add(3);
		
		t2.add(2);
		t2.add(6);
		
		t3.add(8);
		t3.add(9);
		
		t4.add(9);
		t4.add(11);
		
		t5.add(8);
		t5.add(10);
		
		t6.add(2);
		t6.add(4);
		
		t7.add(15);
		t7.add(18);
		
		t8.add(16);
		t8.add(17);
	
		intervals.add(t1);
		intervals.add(t2);
		intervals.add(t3);
		intervals.add(t4);
		intervals.add(t5);
		intervals.add(t6);
		intervals.add(t7);
		intervals.add(t8);

		System.out.println(intervals);
//		swapTwoIntervals(intervals, 0, 1);
//		System.out.println(intervals);
		
//		sortIntervals(intervals);
//		System.out.println(intervals);
		
		System.out.println(mergeOverlaps(intervals));
		
	}

}

/*[[1, 3], [2, 6], [8, 9], [9, 11], [8, 10], [2, 4], [15, 18], [16, 17]]
  [[1, 3], [2, 4], [2, 6], [8, 9], [8, 10], [9, 11], [15, 18], [16, 17]]
 * 
 * */
