package com.practice.tree;


public class HeightOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.constructBinarySearchTree();

		int height = findHeightOfTree(root);
		System.out.println(height);
	}

	private static int findHeightOfTree(TreeNode node) {
		//Base case
		if(node == null ) {
			return 0;
		}
		
		return 1 + (Math.max(findHeightOfTree(node.getLeftChild()), findHeightOfTree(node.getRightChild())));
		
	}

}

/**
 *  Time complexity 
 *  	- We traverse every node and compare which is a constant work, hence time complexity is O(n)
 *  Space complexity
 *  	-  Top to tip can be there in function stack (i.e. height), hence space complexity O(h)
 *  
 */

