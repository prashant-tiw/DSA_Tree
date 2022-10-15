package com.generic_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Traversal {
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
		preTraversals(root);
		
	//System.out.println("Maximum of all is "+	findMax(root, root.data));
	}
	
	public static void traversals(Node node) {

		  //Euler's Left/ Node Pre/ Into the recursion
		  System.out.println("Node Pre " + node.data);


		  for (Node child : node.child)
		  {
		    //Edge Pre
		    System.out.println("Edge Pre " + node.data + "--" + child.data);
		    traversals(child);
		    System.out.println("Edge Post " + node.data + "--" + child.data);
		    //Edge Post
		  }
		  System.out.println("Node Post " + node.data);
		  //Euler's right/Node Post/on the way out of recursion


		}
	
	public static void preTraversals(Node node) {

		  for (Node child : node.child)
		  {
		   System.out.println(child.data);
		    preTraversals(child);
		   
		  }
		

		}

}
