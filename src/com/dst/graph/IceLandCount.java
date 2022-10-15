package com.dst.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IceLandCount {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//int n = 2;
		/*
		 * int [][] arr = new int[n][n]; Scanner in = new Scanner(System.in); for(int i
		 * = 0 ; i<n; i++) { for(int j = 0; j<arr[0].length; j++) { arr[i][j] =
		 * in.nextInt(); } }
		 */
		//////////////
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      int m = Integer.parseInt(br.readLine());
	      int n = Integer.parseInt(br.readLine());
	      int[][] arr = new int[m][n];

	      for (int i = 0; i < arr.length; i++) {
	       //  String parts = br.readLine();
	         for (int j = 0; j < arr[0].length; j++) {
	            arr[i][j] = Integer.parseInt(br.readLine());
	         }
	      }
		
		
		////////////////
		int count = 0 ;
		boolean [][] visited = new boolean[arr.length][arr[0].length];
		for(int i = 0 ; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
			if(arr[i][j] == 0 && visited[i][j] == false) {
				drawTreeForComponent(arr, i , j , visited);
				count++;
			}
			}
		}
		System.out.println("iceland count is " + count);
	}

	private static void drawTreeForComponent(int[][] arr, int i, int j, boolean[][] visited) {
		// TODO Auto-generated method stub
		if(i< 0 || j< 0 || i >= arr.length || j >= arr[0].length || visited[i][j] == true || arr[i][j] == 1) {
			return;
		}
		 visited[i][j] = true;
		drawTreeForComponent(arr, i-1, j, visited);
		
		drawTreeForComponent(arr, i, j-1, visited);
		drawTreeForComponent(arr, i, j+1, visited);
		drawTreeForComponent(arr, i+1, j, visited);
	}

}
