package com.ds.hashAndHeap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.Map.Entry.*;
import static java.util.stream.Collectors.*;

public class HighestFrequencyCharacter {
static int max =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String st = "abrakadabra";
		Map<Character, Integer> map = new HashMap<>();	
		
		for(int i =0 ; i<st.length()-1;i++) {
	
		if(map.containsKey(st.charAt(i))) {
			int count = map.get(st.charAt(i));
		map.put(st.charAt(i), ++count);
		}
		else {
			map.put(st.charAt(i), 1);	
		}
		}
		// int max = 0;
		Map<Character, Integer> sorted = map.entrySet().stream().sorted(comparingByValue()).collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
//sorted.entrySet().stream().forEach(a->{if(max<sorted.entrySet().iterator().next().getValue()) {max = sorted.entrySet().iterator().next().getValue(); char maxChar=sorted.entrySet().iterator().next().getKey();System.out.println(maxChar);}});
		//System.out.println("max is "+ sorted.get());
		int max=0;
	    char maxCharacter = 'x';
		for(Map.Entry<Character, Integer> m : sorted.entrySet()) {
			  if(max<m.getValue()){
			max = m.getValue();
			maxCharacter = m.getKey();
			  }
		}
		 System.out.println("Max Character= " + maxCharacter +" " + "Max Count " + max);
		
	}

}
