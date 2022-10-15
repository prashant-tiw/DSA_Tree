package com.dst.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HasPath {

	static class Edge {
		int src, nbr, wt;

		public Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		boolean isVisited[] = new boolean[vtces];
		hasPath(graph, src, dest, isVisited);

	}

	static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean[] isVisited) {
		if (src == dest) {
			return true;
		}
		isVisited[src] = true;
		for (Edge edge : graph[src]) {
			if (isVisited[edge.nbr] == false) {
				boolean hasPath = hasPath(graph, edge.nbr, dest, isVisited);
				if (hasPath) {
					return true;
				}

			}
		}

		return false;

	}

}
