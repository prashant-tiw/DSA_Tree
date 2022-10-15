package com.generic_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.generic_tree.ConstructAndDisplay.Node;


public class LevelwiseTraversals {

	static class Node {
		static Node root;
		int data;

		Node(int data) {
			this.data = data;

		}

		List<Node> child = new ArrayList();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1 };
		Node root = null;
		Stack<Node> st = new Stack();

		for (int i = 0; i < arr.length; i++) {
			Node n = new Node(arr[i]);
			if (arr[i] == -1) {
				st.pop();
			} else {
				if (st.size() > 0) {
					st.peek().child.add(n);
				} else {
					root = n;
				}
				st.push(n);
			}

		}
		//leveLinewiseTraversal(root);
		mirrorImage(root);
		display(root);
	
	}
	
	static void display(Node n) {
		String str = n.data + "->";
		int count = 1;
		for (Node n2 : n.child) {
			str += n2.data + " ";
			//count++;
		}

		System.out.println(str);
		for (Node n2 : n.child) {
			display(n2);
		}
		 //System.out.println("len is " + count);

	}
	 // remove,print add algorithm
	static void leveLinewiseTraversal(Node node) {
		Queue<Node> qu = new ArrayDeque<>();
		qu.add(node);
		
		while(qu.size()>0) {
			node = qu.remove();
			System.out.print(node.data+" ");
			for(Node child : node.child) {
				qu.add(child);
				//System.out.println(" ");
			}
			
		
		}
	}
	
	static void mirrorImage(Node node) {
		Collections.reverse(node.child);
		for(Node chi: node.child) {
			mirrorImage(chi);
		}
	}
	
	static void removeLeaf(Node node) {
		if(node.child.size() == 0) {
		node.child.re
		}
	}
	/*
	 * static void levelOrderZigZag(Node node) { Stack<Node> st = new Stack<>();
	 * Stack<Node> childSt = new Stack<>(); st.push(node);
	 * 
	 * while(st.size()>0) { st.pop(); System.out.println(node.data + " ");
	 * 
	 * for(Node child: node.child) { childSt.push(child); } if(st.size() == 0) {
	 * while(childSt.size() > 0) { System.out.print(childSt.peek().data + " ");
	 * st.push(childSt.peek()); childSt.pop();
	 * 
	 * } } } levelOrderZigZag(st.peek()); }
	 * 
	 */
}
