package com.practice.tree;

/*
 * 
 * Children sum property - For all node, If sum of left and right child is equal to root node, then the binary tree follow children sum property
 * 
 */

public class ChildrenSumTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.setLeftChild(new TreeNode(7));
		root.setRightChild(new TreeNode(3));
		
		boolean isChildrenSum = isChildrenSum(root);
		System.out.println(isChildrenSum);
	}

	private static boolean isChildrenSum(TreeNode node) {
		
		if(node == null) { // An empty node is considered as valid children sum
			return true;
		}else if(isLeafNode(node)) {
			return true;
		}
		
		int leftChildValue = node.getLeftChild() == null ? 0: node.getLeftChild().getValue();
		int rightChildValue = node.getLeftChild() == null ? 0: node.getRightChild().getValue();

		if((leftChildValue + rightChildValue ) == node.getValue()) {
			return isChildrenSum(node.getLeftChild()) && isChildrenSum(node.getRightChild());
		}else {
			return false;
		}
	}

	private static boolean isLeafNode(TreeNode node) {
		return node.getLeftChild() == null && node.getRightChild() == null ;
	}

}

/**
 *  Time complexity 
 *  	- Each node is visited and processed, hence theeta(n)
 *  Space complexity
 *  	- Maximum number of children are at last level, and that can be 2^height
 * 		- Hence, space complexity is O(Height)
 *  
 */
