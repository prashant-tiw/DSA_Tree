package com.dst.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.dst.graph.HasPath.Edge;

public class HamiltonianPathAndCycle {
	
	static class Edge {
		int src, nbr, wt;

		public Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
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
		int src = in.nextInt();
		int dest = in.nextInt();
	//	boolean isVisited[] = new boolean[vtces];
		Set<Integer> isVisited = new HashSet<>();
		checkHamiltonianPathAndCircle(graph,0,0,isVisited, src+"");

	}
	
	public static void checkHamiltonianPathAndCircle(ArrayList<Edge>[] graph, int src, int osrc, Set<Integer> isVisited, String psf) {
		
		if(isVisited.size() == graph.length-1) {
			System.out.print(psf);
			boolean circleFound = false;
			for(Edge e : graph[src]) {
				if(e.nbr == osrc) {
					circleFound = true;
					break;
				}
			}
			if(circleFound) {
				System.out.println("*");
			}
			else
				System.out.println(".");
				
			return;
		}
		
		isVisited.add(src);
		for(Edge gr: graph[src]) {
		  if(isVisited.contains(gr.nbr) == false) {
			  checkHamiltonianPathAndCircle(graph, gr.nbr, osrc, isVisited, psf+gr.nbr);
			}
		}
		isVisited.remove(src);
		
		
		
	}

}
