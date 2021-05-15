package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Approach
 *  - This uses a queue and solved iteratively
 *  - Loop till queue is not empty
 *  	- Again iterate till queue size, doing we are visiting elements at that level
 *  		- Pop from queue
 *  		- if its first element in queue, print element
 *  		- With a null check, add left and right child to queue
 *  	- Print a line break
 * 
 * @author Barun
 *
 */

public class LeftViewOfBinaryTreeIterative {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.constructBinaryTree();
		
		printLevelOrder(root);

	}

	private static void printLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		
		while(queue.isEmpty() ==  false) {
			int size = queue.size(); // Imp - size should be out side and must not be in i<queue.size() as size changes.
			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				if(i==0)
					System.out.print(node.getValue()+" ");
				if(node.getLeftChild() != null) queue.add(node.getLeftChild());
				if(node.getRightChild() != null) queue.add(node.getRightChild());
				
			}
			System.out.println();
			
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


