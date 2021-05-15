package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Approach 
 * 	- This can be solved iteratively, using queue.
 * 	- Add root to queue
 * 	- Iterate till queue is not empty
 * 		- keep track of max queue size - as max queue size (i.e. maximum # of nodes in a level)
 * 		- Iterate queue
 * 			- With null check, add child of each node in queue	
 * 	- max is the answer	
 * 
 * @author Barun
 *
 */
public class MaximumWidth {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.constructBinaryTree();
		
		System.out.println(maxWidth(root));

	}

	private static int maxWidth(TreeNode root) {
		if(root == null)
			return 0;	
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		int maxWidth = 0;
		
		while(queue.size() > 0) {
			
			int currentQueueSize = queue.size();
			
			if(currentQueueSize > maxWidth)
				maxWidth = currentQueueSize;
			
			while(currentQueueSize > 0) {
				TreeNode node = queue.poll();
				if(node.getLeftChild() != null)
					queue.add(node.getLeftChild());
				if(node.getRightChild() != null)
					queue.add(node.getRightChild());
				currentQueueSize--;
			}
			
			
			
		}
		
		return maxWidth;
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
