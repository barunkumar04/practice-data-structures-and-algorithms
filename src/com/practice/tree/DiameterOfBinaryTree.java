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
 * 
 * @author Barun
 *
 */

public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.constructBinaryTree();
		System.out.println(diameterOfBinaryTree(root));

	}

	public static int diameterOfBinaryTree(TreeNode root) {
		// Base case
		if (root == null) {
			return 0;
		}

		int leftHeight = height(root.getLeftChild());
		int rightHeight = height(root.getRightChild());

		// get the diameter of left and right sub-trees
		int ldiameter = diameterOfBinaryTree(root.getLeftChild());
		int rdiameter = diameterOfBinaryTree(root.getRightChild());

		/*
		 * Return max of following three 1) Diameter of left subtree 2) Diameter of
		 * right subtree 3) Height of left subtree + height of right subtree + 1
		 */
		return Math.max(leftHeight + rightHeight, Math.max(ldiameter, rdiameter));

	}

	private static int height(TreeNode node) {
		// Base case
		if (node == null) {
			return 0;
		}

		return Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1;

	}
}

/**
 *  Time complexity 
 *  	- Each node is visited twice as for every node height and diameter are calculated , hence O(n^2)
 *  Space complexity
 * 		- Hence, space complexity is O(height) as at max height of the tree frames can be available at max.
 */