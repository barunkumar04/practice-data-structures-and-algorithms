package com.practice.tree;

import java.util.Stack;

/**
 * 
 * Approach
 * 	- Two stacks would be required here
 * 	- Stack1 will be
 * 		- containing nodes on level 0, 2, 3 and so on
 * 		- nodes will be pushed right to left
 * 	- Stack2 will be
 * 		- containing nodes on level 1, 3, 5 and so on
 * 		- nodes will be pushed left to right
 * 	
 *  - Iterate will either of these stacks has nodes //Note, either of one will have nodes at a time
 *  	- Loop till stack1 is not empty
 *  		- Pop from stack1
 *  		- print it
 *  		- push its child from left to right in stack2
 *  	- Loop till stack2 is not empty
 *  		- Pop from stack2
 *  		- print it
 *  		- push its child from right to left in stack1
 *  
 * 
 * @author Barun
 *
 */

public class SpiralTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.constructBinaryTree();
		
		printSpiral(root);
		

	}

	private static void printSpiral(TreeNode root) {
		
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		
		stack1.push(root);
		boolean flipStack1 = true;
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			
			if(flipStack1) {
				while(!stack1.isEmpty()) {
					TreeNode node = stack1.pop();
					System.out.print(node.getValue()+" ");
					if(node.getLeftChild()!= null) 
						stack2.add(node.getLeftChild());
					if(node.getRightChild()!= null) 
						stack2.add(node.getRightChild());
					
				}
			}else {
				while(!stack2.isEmpty()) {
					TreeNode node = stack2.pop();
					System.out.print(node.getValue()+" ");
					if(node.getRightChild()!= null) 
						stack1.add(node.getRightChild());
					if(node.getLeftChild()!= null) 
						stack1.add(node.getLeftChild());
					
				}

			}
			
			flipStack1 = !flipStack1;
			System.out.println();
		}
		
	}

}
