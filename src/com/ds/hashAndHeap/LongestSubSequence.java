package com.ds.hashAndHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 2, 3, 4, 8, 9, 17, 11, 15, 12, 19, 16 };

		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(8);
		list.add(9);
		list.add(17);
		list.add(11);
		list.add(15);
		list.add(19);
		list.add(16);
		// list = Arrays.asList(arr);
		Map<Integer, Boolean> map = new HashMap<>();

		for (int l : list) {
			if (map.containsKey(l - 1)) {
				map.put(l, false);
			} else
				map.put(l, true);
		}
		int msp = 0;
		int ml = 0;
		for (int l : list) {
			if (map.get(l) == true) {
				int tsp = l;
				int tl = 1;

				while (map.containsKey(tsp + tl)) {
					tl++;
				}
				if (tl > ml) {
					ml = tl;
					msp = tsp;
				}
			}
		}
		
		for(int i = 0 ; i<= ml; i++) {
			System.out.println(msp+i);
		}

	}

}
