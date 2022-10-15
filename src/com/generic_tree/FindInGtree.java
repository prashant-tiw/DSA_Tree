package com.generic_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.generic_tree.ConstructAndDisplay.Node;

public class FindInGtree {
	static int count =0;
	static class Node {
		static Node root;
		int data;
		

		Node(int data) {
			this.data = data;

		}

		List<Node> children = new ArrayList();
		Stack<Node> st = new Stack();
	}

	static class GetBoolean {
		boolean result;

		public Boolean getResult() {
			return result;
		}

		public void setResult(Boolean result) {
			this.result = result;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int arr[] = { 10, 20, 30, -1, 40, 50, 60, -1, -1, 70, -1, -1 };

		int arr[] = { 10, 20, 30, -1, 40, 50, -1, -1, -1 };
		Node root = null;
		Stack<Node> st = new Stack();

		for (int i = 0; i < arr.length; i++) {
			Node n = new Node(arr[i]);
			if (arr[i] == -1) {
				st.pop();
			} else {
				if (st.size() > 0) {
					st.peek().children.add(n);
				} else {
					root = n;
				}
				st.push(n);
			}

		}

		System.out.println(ditanceBwNodes(root, 20,50));

	}

	static List<Integer> findInTree(Node node, int data) {

		if (node.data == data) {
			List<Integer> list = new ArrayList<>();
			list.add(node.data);
			return list;
		}

		for (Node child : node.children) {
			List<Integer> fic = findInTree(child, data);
			if (fic.size() > 0) {
				fic.add(node.data);
				return fic;
			}
		}

		return new ArrayList<>();
	}

	static List<Integer> findCommonAncestor(Node node, int data1, int data2) {

		if (node.data == data1) {
			List<Integer> list1 = new ArrayList<>();
			list1.add(node.data);
			return list1;
		} else if (node.data == data2) {
			List<Integer> list2 = new ArrayList<>();
			list2.add(node.data);
			return list2;
		}

		for (Node child : node.children) {
			List<Integer> fic = findCommonAncestor(child, data1, data2);
			if (fic.size() > 0) {
				fic.add(node.data);
				return fic;
			}
		}

		return new ArrayList<>();
	}
	
	static int ditanceBwNodes(Node node, int d1, int d2) {
		if(node.data == d1) {
		
		   ++count;
		}
		for(Node child : node.children) {
			 count = ditanceBwNodes(child, d1, d2);
			
			if(count>0 ) {
				count++;
				if(child.data == d2)
				return count;
			}
		}
		return count;
	}

}
