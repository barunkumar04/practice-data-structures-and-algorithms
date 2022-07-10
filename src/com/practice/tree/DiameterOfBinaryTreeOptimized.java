package com.practice.tree;


/**
 * 
 * Diameter - Max number of nodes between two leafs
 * 
 * Approach 
 * 	- Height calculation logic can be leverage here.
 * 	- Height of a tree is calculated as max height of left subtree and right subtree plus 1
 * 	- In height function when have height of left and height of right child. adding 1 into these will give us diameter.
 * 	- We just need to take maximum diameter
 *  - A static variable can be used for tracking the diameter
 *  - In this logic, # of nodes is treated as diameter count
 * 
 * @author Barun
 *
 */

public class DiameterOfBinaryTreeOptimized {
	
	private static int diameter = 0;
	public static void main(String[] args) {
		TreeNode root = TreeUtil.constructBinarySearchTree();
		height(root);
		System.out.println(diameter);

	}


	private static int height(TreeNode node) {
		// Base case
		if (node == null) {
			return 0;
		}
		int leftHeight = height(node.getLeftChild());
		int rightHeight = height(node.getRightChild());
		int currentDiameter = leftHeight + rightHeight+1;
		
		diameter = Math.max(diameter,  currentDiameter);
		
		return Math.max(leftHeight, rightHeight) + 1;

	}
}

/**
 *  Time complexity 
 *  	- Each node is visited only once as for every node height and diameter is calculated same time, hence O(n)
 *  Space complexity
 * 		- Hence, space complexity is O(height) as at max height of the tree frames can be available at max.
 *  
 */