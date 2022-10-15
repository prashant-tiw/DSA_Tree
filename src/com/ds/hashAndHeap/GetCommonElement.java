package com.ds.hashAndHeap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GetCommonElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int arr1[] = {1,1,2,5};
     int arr2[] = {1,1,2,3,4,5};
     
 	Map<Integer, Integer> map = new HashMap<>();	
 	  
 	 	Map<Integer, Integer> map2 = new HashMap<>();	
 	for(int i = 0; i<arr1.length; i++) {
 		map.put(i, arr1[i]);
 	}
 	
	for(int i = 0; i<arr2.length; i++) {
 		map2.put(i, arr2[i]);
 	}
	Set<Integer> list = new HashSet<>();
	for(Map.Entry<Integer, Integer> it : map2.entrySet()) {
	int f = it.getValue();
	if(map.containsValue(f)) {
		list.add(f);
	}
	}
	System.out.println(list);
	}

}
