package com.practice.tree;

public class NodeAtDistanceK {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.constructBinarySearchTree();

		printNodeAtDistanceK(root,3);

	}

	private static void printNodeAtDistanceK(TreeNode root, int k) {
		
		// saftey check
		if(root == null) {
			return;
		}
		
		//base case
		if(k == 0) {
			System.out.println(root.getValue());
		}else { // Recurrence relation
			printNodeAtDistanceK(root.getLeftChild(), k-1);
			printNodeAtDistanceK(root.getRightChild(), k-1);
		}
		
		
	}

}

/**
 *  Time complexity 
 *  	- Best case: We traverse every node and compare which is a constant work, hence time complexity is theta(1), for k=0
 *      - Worst case: O(n) 
 *  Space complexity
 *  	-  Top to tip can be there in function stack (i.e. height), hence space complexity O(h)
 *  
 */