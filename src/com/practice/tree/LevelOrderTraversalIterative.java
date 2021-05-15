package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Approach
 *  - This uses a queue and solved iteratively
 *  - Each node is put in to queue
 *  - And while taking out from queue, push left and right child to the queue
 * 
 * @author Barun
 *
 */

public class LevelOrderTraversalIterative {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.constructBinaryTree();
		
		printLevelOrder(root);

	}

	private static void printLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node.getLeftChild() != null) queue.add(node.getLeftChild());
			if(node.getRightChild() != null) queue.add(node.getRightChild());
			System.out.print(node.getValue()+" ");
			
		}

		
	}

}


/**
 *  Time complexity 
 *  	- Each node is visited and processed, hence theeta(n)
 *  Space complexity
 *  	- Maximum number of children are at last level, and that can be 2^height
 * 		- Hence, space complexity is O(2^height) or O(width of binary tree)
 *  
 */


/***
 * Another approach 
 * 	- This is an in-efficient approach, as it takes more time, which is O(n*h)
 *  - Find how many levels, height of the tree, lets say h. takes O(n) time
 *  - Iterate from 0 to h, say k - This takes O(h) time
 *  	- 	print nodes as distance k
 *  - Hence total time is O(n*h)
 * 
 */

