package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Approach
 *  - This uses a queue and solved iteratively
 *  - Each node is put in to queue and add a null. Null denotes it end of a level
 *  - And while taking out from queue, push left and right child to the queue
 *  - When a null is encountered, add another null and continue
 * 
 * @author Barun
 *
 */

public class LevelOrderTraversalLineByLineIterative {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.constructBinarySearchTree();
		
		printLevelOrder(root);

	}

	private static void printLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		queue.add(null);
		
		
		
		while(queue.size() > 1) {
			TreeNode node = queue.poll();
			if(node == null) {
				System.out.println();
				queue.add(null);
				continue;
				
			}
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


