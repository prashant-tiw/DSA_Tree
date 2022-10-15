package com.ds.bst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructAndOtherOperations {

	static class Node {
		int data;
		Node left, right;

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;

		}
	}

	static Node construct(int[] arr, int low, int high) {
		if(low>high) {
			return null;
		}
		
		int mid = (low + high) / 2;
		int root = arr[mid];
		
		Node lc= construct(arr, low, mid-1);
		Node rc = construct(arr, mid+1, high);
		
		Node node = new Node(root, lc, rc);
		return node;
		

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
	
	static Node addNode(Node node, int dataToAdd) {
		if(node == null) {
			return new Node(dataToAdd, null, null);
		}
		
		if(node.data > dataToAdd) {
			node.left = addNode(node.left, dataToAdd);
			
		
		}
		else if(node.data < dataToAdd) {
			node.right = addNode(node.right, dataToAdd);
			
		
		}
		return node;
		
	}
	static int sum = 0;
	public static void replaceWithSumOfLarger(Node node) {
		if(node == null){return;}
		replaceWithSumOfLarger(node.right);
		
		int temp = node.data ;
		node.data = sum;
		sum += temp;
		System.out.print(" "+ node.data);
		
	   replaceWithSumOfLarger(node.left);
		
	}

	  public static int lca(Node node, int d1, int d2) {
		    if (d1 < node.data && d2 < node.data) {
		      return lca(node.left, d1, d2);
		    } else if (d1 > node.data && d2 > node.data) {
		      return lca(node.right, d1, d2);
		    } else {
		      return node.data;
		    }
		  }
	  

	  public static void pir(Node node, int d1, int d2) {
	    // write your code here
	    if(node == null){return;}
	    
	    pir(node.left, d1, d2);
	   
	    if(node.data>=d1 && node.data <= d2){
	        System.out.print("In range "+ node.data+", ");
	    }
	    
	    pir(node.right, d1, d2);
	  }
	  
	  
	    static Map<Integer, Integer> map = new HashMap<>();
	    static List<Integer> list = new ArrayList();
	    
	public  static Node targetSumPair(Node node) {
		    if(node == null){return null;}
		    int sum = 80;
		    
	    targetSumPair(node.left);
		   map.put(node.data, 1);
		 
		   list.add(node.data);
		targetSumPair(node.right);
		    
		   // map.put(node.data, 1);
		    int n = map.keySet().stream().findAny().get();
		    if((sum-node.data) == map.keySet().stream().findAny().get()) 
		    {System.out.println("hello pairs "+ node.data + "," + map.keySet().stream().iterator().next());}
		    
		    pairedElements(list, 80);
		    
		  return null;
	  }
	
	 public static void pairedElements(List<Integer> list, int sum)
	    {
	        int low = 0;
	        int high = list.size() - 1;
	 
	        while (low < high) {
	            if (list.get(low) + list.get(high) == sum) {
	                System.out.println("The pair is : ("
	                                   + list.get(low) + ", " + list.get(high) + ")");
	            }
	            if (list.get(low) + list.get(high) > sum) {
	                high--;
	            }
	            else {
	                low++;
	            }
	        }
	    }
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 12,20, 25,30, 37, 50, 62, 75, 87, 90, 95 };
		Node node = construct(arr, 0, arr.length-1);
		
		System.out.println(addNode(node,10));
		System.out.println(size(node));
		//replaceWithSumOfLarger(node);
		System.out.println(lca(node,12,30));
		pir(node, 28, 91);
		targetSumPair(node);
	}

}
