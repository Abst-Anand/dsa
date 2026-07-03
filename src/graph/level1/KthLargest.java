package src.graph.level1;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {

    // for largest, we have to eliminate the smallest so far => need min heap
    static int findKthLargest(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;

        for(int i=0; i<k; i++){
            pq.add(arr[i]);
        }

        for(int i=k; i< arr.length; i++){
            if(arr[i] > pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }

        res = pq.peek();

        return res;
    }

    // for smallest, we have to eliminate the largest so far => need max heap
    static int findKthSmallest(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<k; i++){
            pq.add(arr[i]);
        }

        for(int i=k; i< arr.length; i++){
            if(pq.peek() > arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {

        int[] arr = {10, -9, 89, 7, 554};
        int k = 4;
        int res = findKthLargest(arr, k);
        System.out.println(res);

        res = findKthSmallest(arr, k);
        System.out.println(res);

    }
}
