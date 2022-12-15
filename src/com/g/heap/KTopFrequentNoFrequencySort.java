package com.g.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class KTopFrequentNoFrequencySort {

	public static void main(String[] args) {
		int arr[] = { 1, 1, 1, 3, 2, 2, 4 };
		int n = arr.length;
		int k = 2;
		
		int nums[] = {-1,1,-6,4,5,-6,1,4,1};

//		{1,1,1,2,2,3,4}

		printTopKelements(arr, n, k);
//		frequencySort(arr, n);//O (n log n)
//		SortArraybyIncreasingFrequency(nums);
//		System.out.println("\n"+Arrays.toString(nums));
	}
	
	public static int[] SortArraybyIncreasingFrequency(int[] nums) {
        Map<Integer, Integer> hm = new TreeMap<>();
        
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
        
        System.out.print(hm);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((c1, c2) -> {
            //here comparator
            if(hm.get(c1) == hm.get(c2)){
                   return c2 - c1;
               }
            return hm.get(c1) - hm.get(c2);
        });
        
        for (Entry<Integer, Integer> entry : hm.entrySet()) {
			maxHeap.add(entry.getKey());
		}
        
        
        int index=0;
        while(maxHeap.size()>0){
            
            int element = maxHeap.peek();
            System.out.print(element+" ");
            
            for(int i =0;i<hm.get(element);i++){
                nums[index++] = element;
            }
            maxHeap.poll();
        }
        
        
        return nums;
    }

	private static void frequencySort(int[] arr, int n) {
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
		}
		System.out.println(hm);
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((c1, c2) -> {
			return hm.get(c2) - hm.get(c1);
		});

		for (Entry<Integer, Integer> entry : hm.entrySet()) {
			maxHeap.add(entry.getKey());
		}
		
		int index = 0;
		while(maxHeap.size()>0) {
			
			int element = maxHeap.peek();
			
			for(int i=0;i<hm.get(element);i++) {
				arr[index++] = element;
			}
			maxHeap.poll();
		}

		/*PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<Pair<Integer, Integer>>((c1, c2) -> {
			return hm.get(c1.getKey()) - hm.get(c2.getKey());
		});

		for (Entry<Integer, Integer> entry : hm.entrySet()) {
			maxHeap.add(new Pair<Integer, Integer>(entry.getValue(), entry.getKey()));
		}
		
		

		int index = 0;

		while (maxHeap.size() > 0) {

			int frequency = maxHeap.peek().key;
			int element = maxHeap.peek().value;

			System.out.println(frequency + " - " + element);
			for (int i = 0; i < frequency; i++) {
				arr[index++] = element;
			}

			maxHeap.poll();
		}*/

		System.out.println(Arrays.toString(arr));
	}

	private static void printTopKelements(int[] arr, int n, int k) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

//		PriorityQueue<SimpleEntry<Integer, Integer>> minHeaps = new PriorityQueue<>();

		PriorityQueue<Integer> minHeap = new PriorityQueue<>((key1, key2) -> {
			// comparing frquency
			return hm.get(key1) - hm.get(key2);
		});

		for (int i = 0; i < n; i++) {
//			if (hm.containsKey(arr[i])) {
//				
//			} else {
//				hm.put(arr[i], 1);
//			}
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
		}

		System.out.println(hm);

		for (Integer key : hm.keySet()) {
//			System.out.println(key+",");
			minHeap.add(key);

			if (minHeap.size() > k) {
				System.out.print(minHeap.peek()+" \n");
				minHeap.poll();
			}
		}
		while (minHeap.size() > 0) {
			System.out.print(minHeap.peek() + " ");
			minHeap.poll();
		}

	}

}
