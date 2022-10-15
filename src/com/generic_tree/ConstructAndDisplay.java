package com.generic_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ConstructAndDisplay {

	static class Node {
		static Node root;
		int data;

		Node(int data) {
			this.data = data;

		}

		List<Node> list = new ArrayList();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[] = { 10, 20, 30, -1, 40, 50, 60, -1, -1, 70, -1, -1 };
		int arr[] = { 10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1 };
		Node root = null;
		Stack<Node> st = new Stack();

		for (int i = 0; i < arr.length; i++) {
			Node n = new Node(arr[i]);
			if (arr[i] == -1) {
				st.pop();
			} else {
				if (st.size() > 0) {
					st.peek().list.add(n);
				} else {
					root = n;
				}
				st.push(n);
			}

		}

		display(root);
	System.out.println("Maximum of all is "+	findMax(root, root.data));
		System.out.println(size(root));
	}

	static void display(Node n) {
		String str = n.data + "->";
		int count = 1;
		for (Node n2 : n.list) {
			str += n2.data + " ";
			//count++;
		}

		System.out.println(str);
		for (Node n2 : n.list) {
			display(n2);
		}
		 //System.out.println("len is " + count);

	}
	
	  public static int size(Node node) {
		    if (node == null) {
		      return 0;
		    }

		    int sz = 1;
		    for (Node child : node.list) {
		      sz += size(child);
		    }
		    return sz;
		  }
	
	static int findMax(Node n, int max) {
		for(int i = 0; i< n.list.size(); i++) {
			if(n.list.get(i).data > max  ) {
				max = n.list.get(i).data;
			}
			/*
			 * n.list.stream().forEach(a->{ for(int i = 0; i< n.list.size(); i++) {
			 * if(n.list.get(i).data > max ) { max = n.list.get(i).data; }} });
			 */
		}
		for (Node n2 : n.list) {
			findMax(n2, max);
		}
		System.out.println("max "+ max);
		return max;
	}
}
