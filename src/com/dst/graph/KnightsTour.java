package com.dst.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class KnightsTour {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      int m = Integer.parseInt(br.readLine());
	      int n = Integer.parseInt(br.readLine());
	      Integer[][] arr = new Integer[m][n];     
          Set<Integer[][]> visited = new HashSet<>();
          boolean[][] isVisited = new boolean[arr.length][arr[0].length];
         int startI = 3;
         int startJ = 2;
          countOfKnightsTour(arr, startI, startJ, isVisited);

	}
	
	public static void countOfKnightsTour(Integer[][] arr, int startI, int startJ, boolean[][] isVisited) {
		
		isVisited[startI][startJ] = true;
		countOfKnightsTour(arr,startI-2,startJ+1,isVisited);
		countOfKnightsTour(arr,startI-2,startJ-1,isVisited);
		countOfKnightsTour(arr,startI-2,startJ-1,isVisited);
		countOfKnightsTour(arr,startI,startJ-1,isVisited);
	
	}

}
