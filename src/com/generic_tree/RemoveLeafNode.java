package com.generic_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.generic_tree.Traversal.Node;

public class RemoveLeafNode {

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
		removeLeaf(root);
		display(root);

		// System.out.println("Maximum of all is "+ findMax(root, root.data));
	}

	private static void removeLeaf(Node root) {
		// TODO Auto-generated method stub
		Stack<Node> mainSt = new Stack<>();
		Stack<Node> childSt = new Stack<>();
		mainSt.add(root);
		for (Node chld : root.child) {
			if (root.child != null) {
				// chld.child.add(e)
				childSt.add(root);
				mainSt.add(childSt.pop());
			}
		}

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

}
