package src.pepcoding.hashmapheapsl2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    //Q1: Find number of employees under every employee
    static void findEmployees(HashMap<Character, Character> hierarchyMap){

        HashMap<Character, ArrayList<Character>> treeMap = new HashMap<>();
        Character root = null;
        for(Character emp : hierarchyMap.keySet()){
            Character manager = hierarchyMap.get(emp);

            if(emp == manager){
                root = emp;
                continue;
            }

            if(treeMap.containsKey(manager)){
                treeMap.get(manager).add(emp);
            }else{
                ArrayList<Character> tempList = new ArrayList<>();
                tempList.add(emp);
                treeMap.put(manager, tempList);
            }
        }

        printEmployeeDfs(root, treeMap);
    }
    // Q1 dfs helper
    private static int printEmployeeDfs(Character ch, HashMap<Character, ArrayList<Character>> tree){
        ArrayList<Character> employees = tree.getOrDefault(ch, new ArrayList<>());

        int curr = 0;
        for(Character emp : employees){
            curr += printEmployeeDfs(emp, tree);
        }

        System.out.println(ch + " " + curr);

        return curr+1;
    }


    // Q2: Re-Construct Itinerary
    static void reconstructItinerary(HashMap<String, String> visits){

        HashMap<String, Boolean> sourceCheckMap = new HashMap<>();

        String source = "";
        for(String src : visits.keySet()){
            sourceCheckMap.put(src, true);
        }

        for(String dest : visits.values()){
            sourceCheckMap.put(dest, false);
        }

        for(String src : sourceCheckMap.keySet()){
            if(sourceCheckMap.get(src)){
                source = src;
            }
        }

        System.out.print(source);
        while (true){
            String dest = visits.get(source);

            if(dest == null){
                break;
            }

            System.out.print(" -> " + dest);
            source = dest;
        }
    }
    static void reconstructItineraryOptimal(HashMap<String, String> visits){
        System.out.println();

        HashSet<String> destinations = new HashSet<>(visits.values());

        String source = "";
        for(String src : visits.keySet()){
            if(!destinations.contains(src)){
                source = src;
                break;
            }
        }

        System.out.print(source);

        while(visits.containsKey(source)){
            String dest = visits.get(source);
            System.out.print(" -> " + dest);
            source = dest;
        }
    }

    // Q3: Check if an array can be divided into pairs whose sum is divisible by k
    static void isPairDivisible(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : arr){
            int rem = ele % k;
            if(rem < 0){
                rem += k;
            }
            map.put(rem, map.getOrDefault(rem, 0) +1);
        }

        for(int rem : map.keySet()){

            int freq = map.get(rem);

            if(rem == 0){
                if(freq % 2 != 0){
                    System.out.println("No");
                    return;
                }
            } else if (2 * rem == k) {
                if(freq % 2 != 0){
                    System.out.println("No");
                    return;
                }
            } else{
                int complementFreq = map.getOrDefault(k-rem, -1);
                if(freq != complementFreq){
                    System.out.println("No");
                    return;
                }

            }

        }

        System.out.println("yes");
    }

    // Q4: Print number of distinct elements in a window of size k
    static void findDistinctInWindowOfSizeK(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<k; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
        }

        int i=k;
        int j=0;
        ans.add(map.size());

        while(i<arr.length){
            map.put(arr[i], map.getOrDefault(arr[i],0) +1);
            if(map.get(arr[j]) == 1){
                map.remove(arr[j]);
            }else{
                map.put(arr[j], map.get(arr[j]) -1);
            }
            i++;
            j++;
            ans.add(map.size());
        }

        System.out.println(ans);
    }

    // Q5: Longest subarray with sum as zero
    static void longestSubarraySumZero(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = Integer.MIN_VALUE; // length of the longest subarray
        int startIdx = -1; // start index of the longest subarray
        int endIdx = -1; // end index of the longest subarray

        map.put(0, -1);

        for(int i=0; i< arr.length; i++){
            sum += arr[i];

            if(map.containsKey(sum)){
                int len = i - map.get(sum);
                if(len > maxLen){
                    maxLen = len;
                    startIdx = map.get(sum) + 1;
                    endIdx = i;
                }

            }else{
                map.put(sum, i);
            }
        }
        System.out.println("Longest Subarray with sum 0 Length: " + maxLen);
        System.out.println("Start Idx: " + startIdx);
        System.out.println("End Idx: " + endIdx);
    }
    static void longestSubarraySumK(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = Integer.MIN_VALUE;
        int startIdx = -1;
        int endIdx = -1;

        map.put(0, -1);

        for(int i=0; i< arr.length; i++){
            sum += arr[i];

            if(map.containsKey(sum - k)){
                int len = i - map.get(sum - k);
                if(len > maxLen){
                    maxLen = len;
                    startIdx = map.get(sum - k) + 1;
                    endIdx = i;
                }
            }else{
                map.put(sum, i);
            }
            // TODO why this else is wrong and can we add this sum in map if not present
        }

        System.out.println("Longest Subarray with sum k Length: " + maxLen);
        System.out.println("Start Idx: " + startIdx);
        System.out.println("End Idx: " + endIdx);
    }

    // Q6: Count subarray with sum as zero
    static void countSubarraySumZero(int[] arr){
        HashMap<Integer, Integer> map = new HashMap();
        int sum = 0;
        int count = 0;

        map.put(0, 1);

        for(int i=0; i<arr.length; i++){
            sum += arr[i];

            if(map.containsKey(sum)){
                count += map.get(sum);
                map.put(sum, map.get(sum)+1);
            }else{
                map.put(sum, 1);
            }
        }

        System.out.println("Count: " + count);
    }


    public static void main(String[] args) {

        System.out.println("===Q1===================================================================================");
        HashMap<Character, Character> q1Map = new HashMap<>();
        q1Map.put('A', 'C');
        q1Map.put('B', 'C');
        q1Map.put('C', 'F');
        q1Map.put('D', 'E');
        q1Map.put('E', 'F');
        q1Map.put('F', 'F');

        findEmployees(q1Map);
//===========================================================================================================================================================================
        System.out.println("===Q2===================================================================================");
        HashMap<String, String> itinerary = new HashMap<>();
        itinerary.put("Chennai","Banglore");
        itinerary.put("Bombay","Delhi");
        itinerary.put("Goa","Chennai");
        itinerary.put("Delhi","Goa");

        reconstructItinerary(itinerary);
        reconstructItineraryOptimal(itinerary);
//===========================================================================================================================================================================
        System.out.println("\n===Q3===================================================================================");

        int[] arr3 = {1,1};
        int k3 = 5;
        isPairDivisible(arr3, k3);
//===========================================================================================================================================================================
        System.out.println("\n===Q4===================================================================================");

        int[] arr4 = {10, 20, 5, 6, 67, 7, 5, 44, 44, 5};
        // 4, 4, 4, 4, 4, 3, 2
        int k4 = 4;
        findDistinctInWindowOfSizeK(arr4, k4);
//===========================================================================================================================================================================
        System.out.println("\n===Q5===================================================================================");

        int[] arr5 = {3,2,1};
        longestSubarraySumZero(arr5);
        System.out.println();
        longestSubarraySumK(arr5, 3);
//===========================================================================================================================================================================
        System.out.println("\n===Q6===================================================================================");

        int[] arr6 = {3,-2,-1, 0 , 5, -5};
        countSubarraySumZero(arr6);

    }
}
