package com.ds.binary;

import java.lang.invoke.VolatileCallSite;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConstructAndDisplay {

	static class Node {
		int root;
		Node left, right;

		public Node(int root, Node left, Node right) {
			this.root = root;
			this.left = left;
			this.right = right;

		}
	}

	static class Pair {
		Node node;
		int level;

		Pair(Node node, int level) {
			this.node = node;
			this.level = level;

		}
	}

	static void display(Node node) {
		if (node == null) {
			return;
		}

		display(node.left);
		display(node.right);

	}

	static int size(Node node) {
		if (node == null) {
			return 0;
		}
		int size = 1;
		size += size(node.left);
		size += size(node.right);
		return size;

	}

	static int max(Node node) {
		if (node == null) {
			return 0;
		}
		int max = node.root;
		if (node.right != null) {
			max = node.right.root;
			return max(node.right);
		}

		return max;

	}

	static int sum(Node node) {
		if (node == null) {
			return 0;
		}
		int sum = node.root;
		sum += sum(node.left);
		sum += sum(node.right);
		return sum;

	}

	static int height(Node node) {
		if (node == null) {
			return 0;
		}
		int height = 1;
		int heightLeft = 1;
		int heightRight = 1;
		if (node.left != null) {
			heightLeft += 1;
			height(node.left);
		}

		if (node.right != null) {
			heightRight += 1;
			height(node.right);
		}

		return heightRight > heightLeft ? heightRight + 1 : heightLeft + 1;

	}

	public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
		if (node == null) {
			return new ArrayList<>();
		}

		if (node.root == data) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(node.root);
			return list;
		}

		ArrayList<Integer> llist = nodeToRootPath(node.left, data);
		if (llist.size() > 0) {
			llist.add(node.root);
			return llist;
		}

		ArrayList<Integer> rlist = nodeToRootPath(node.right, data);
		if (rlist.size() > 0) {
			rlist.add(node.root);
			return rlist;
		}
		return new ArrayList<>();
	}

	public static void printKLevelsDown(Node node, int k) {
		if (node == null || k < 0) {
			return;
		}

		if (k == 0) {
			System.out.print(node.root + " ");
			return;
		}

		printKLevelsDown(node.left, k - 1);
		printKLevelsDown(node.right, k - 1);
		System.out.println();
	}

	/*
	 * public static void printKDisatnceAway(Node node, int data , int k) { if (node
	 * == null || k < 0) { return; }
	 * 
	 * if (k == 0 && node.root == data) { System.out.print(node.root+" "); return; }
	 * 
	 * if(node.left != null) { printKDisatnceAway(node.left, data, k - 1); }
	 * if(node.right != null) { printKDisatnceAway(node.right, data, k - 1); } }
	 */

	/*
	 * static ArrayList<Integer> rootToLeaf(Node node){ if(node == null) { return
	 * new ArrayList<>(); }
	 * 
	 * if(node != null) { ArrayList<Integer> list = new ArrayList<>();
	 * list.add(node.root); return list; } ArrayList<Integer> llist =
	 * rootToLeaf(node.left); ArrayList<Integer> rlist = rootToLeaf(node.right);
	 * 
	 * return new ArrayList<>();
	 * 
	 * }
	 */

	/*
	 * static void leftClonedTree(Node node) { if(node == null || node.left == null
	 * || node.right == null) { return; }
	 * 
	 * int temp = node.left.root; node.left.root = node.root; node.left.left.root =
	 * temp; leftClonedTree(node.left.left);
	 * 
	 * int temp2 = node.right.root; node.right.root = node.root;
	 * node.right.right.root = temp; leftClonedTree(node.right.right);
	 * 
	 * 
	 * }
	 */

	static void printSingleChild(Node node) {
		if (node == null) {
			return;
		}

		if (node.right != null || node.left != null) {
			if (node.right == null || node.left == null) {
				System.out.print(
						"Single child nodes " + node.left != null ? node.left.root + " " : node.right.root + " ");
			}
		}

		printSingleChild(node.left);
		printSingleChild(node.right);
		// System.out.println();
	}

	static boolean isBST(Node node) {
		if (node == null) {
			return false;
		}
		boolean result = false;
		if (node.left != null && node.left.root < node.root) {
			result = true;

		}

		if (result) {
			result = isBST(node.left);
		}

		if (node.right != null && node.right.root > node.root) {
			result = true;

		}

		if (result) {
			result = isBST(node.right);
		}
		return result;
	}

	static class BalancedPair {
		int bc;
		boolean isB;
	}

	static BalancedPair isBalanced(Node node) {
		BalancedPair blp = new BalancedPair();
		if (node.left != null) {
			blp = isBalanced(node.left);
		}
		if (node.right != null) {
			blp = isBalanced(node.right);
		}

		if (node.left == null && node.right == null) {
			blp.bc = 0;
			blp.isB = true;

		}

		if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
			if (blp.bc == 0) {
				blp.bc = 1;
				blp.isB = true;
			} else if (blp.bc >= 1) {
				blp.bc += 1;
				blp.isB = false;
				// return false;

			}

		}

		return blp;

	}

	public static void main(String[] args) {
		// Integer[] arr = { 50, 25, 12, null, null, 37, null, null, 75, null, null };
		// Integer[] arr = { 50, 25, 12, 10, null, null, 37,35, null, null, 38, null,
		// null, 75, null, null };
		// Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62,
		// null, 70, null, null, 87, null, null };

		// Integer[] arr = { 50, 25, 12, 12, null, null, null, null, 75, null, 87, null,
		// 87, null, null };

		// Integer[] arr = { 50, 25, 12, null, null, null, 75, null, 87, null, null };

		Integer[] arr = { 1, null, 2, 3, null, null, null };

		Node rootNode = new Node(arr[0], null, null);

		Stack<Pair> st = new Stack();

		Pair rootPair = new Pair(rootNode, 1);

		st.push(rootPair);

		int index = 1;

		while (st.size() > 0) {
			Pair top = st.peek();
			if (top.level == 1) {
				if (arr[index] != null) {
					Node ln = new Node(arr[index], null, null);
					top.node.left = ln;
					Pair lp = new Pair(ln, 1);
					st.push(lp);
				}
				top.level++;
				index++;
			}

			else if (top.level == 2) {

				if (arr[index] != null) {
					Node rn = new Node(arr[index], null, null);
					top.node.right = rn;
					Pair rp = new Pair(rn, 1);
					st.push(rp);
				}
				top.level++;
				index++;
			} else {
				st.pop();
			}
		}

		// leftClonedTree(rootNode);
		System.out.println("size is " + size(rootNode));
		System.out.println("max is " + max(rootNode));
		System.out.println("sum is " + sum(rootNode));
		System.out.println("height is " + height(rootNode));
		System.out.println("node to root path " + nodeToRootPath(rootNode, 37));
		printKLevelsDown(rootNode, 1);
		// printKDisatnceAway(rootNode, 37, 2);

		// System.out.println("leaf "+ rootToLeaf(rootNode));

		// printSingleChild(rootNode);

		// System.out.println("Is Binary "+ isBST(rootNode));

		System.out.println("Is Balanced " + isBalanced(rootNode).isB);

		System.out.println(deepestLeavesSum(rootNode));

		/*
		 * List<Integer> list_ = inorderTraversal(rootNode); for(Integer l : list_) {
		 * System.out.println(l); }
		 */

	}

	static List<Integer> list = new ArrayList<>();

	public static List<Integer> inorderTraversal(Node node) {

		return null;
	}

	private static int maxLevel = 0;
	private static int sum = 0;

	public static int deepestLeavesSum(Node root) {
		if (root == null)
			return 0;
		calculateSumAtLevel(root, 0);
		return sum;

	}

	private static void calculateSumAtLevel(Node root, int level) {

		if (root == null)
			return;
		if (level > maxLevel) {
			sum = 0;
			maxLevel = level;
		}
		if (level == maxLevel) {
			sum = sum + root.root;
		}
		calculateSumAtLevel(root.left, level + 1);
		calculateSumAtLevel(root.right, level + 1);
	}
}
