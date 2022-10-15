package com.dst.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class IsGraphCyclic_BFS {
	

	static class Edge {
		int src, nbr, wt;

		public Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	
	static class Pair {
		int vert; 
		String psf;

		public Pair(int vert, String psf) {
			this.vert = vert;
			this.psf = psf;
		}
	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		
		System.out.println("enter vtces no.");
		int vtces = in.nextInt();
		
		ArrayList<Edge>[] graph = new ArrayList[vtces];
		for (int i = 0; i < vtces; i++) {
			graph[i] = new ArrayList<>();
		}
		
		System.out.println("enter edges no.");
		int edges = in.nextInt();
		
		for (int i = 0; i < edges; i++) {
			System.out.println("enter v1");
			int v1 = in.nextInt();
			System.out.println("enter v2");
			int v2 = in.nextInt();
			System.out.println("enter wt");
			int wt = in.nextInt();
			
			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}
		
		System.out.println("enter src");
		int src = in.nextInt();
	
		boolean isVisited[] = new boolean[vtces];
		Queue queue = new ArrayDeque<>();
		
		System.out.println(isCyclic(graph, src, isVisited));

	}
	
	public static boolean isCyclic(ArrayList<Edge>[] graph, int src, boolean[] isVisited) {
	    ArrayDeque<Pair> queue = new ArrayDeque<>();
	    queue.add(new Pair(src,src+""));
		while(queue.size() > 0) {
			Pair rem  = queue.remove();
			
			if(isVisited[rem.vert]) {
				return  true;
			}
			
			isVisited[rem.vert] = true;
		
			for(Edge gr : graph[rem.vert]) {
				if(!isVisited[gr.nbr]) {
				
	
					queue.add(new Pair(gr.nbr, rem.psf+gr.nbr));
					
					
				}
			}
			
		}
		return false;
		
	}

}
