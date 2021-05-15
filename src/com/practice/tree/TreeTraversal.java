package com.practice.tree;

public class TreeTraversal {

	public static void main(String[] args) {
		TreeNode rootNode = TreeUtil.constructBinaryTree(); 
		
		System.out.println("Printing inorder...");
		inorderTraverse(rootNode);
		
		System.out.println("\nPrinting preorder...");
		preorderTraverse(rootNode);
		
		System.out.println("\nPrinting postorder...");
		postorderTraverse(rootNode);
	}

	private static void preorderTraverse(TreeNode treeNode) {
		if(treeNode != null) {
			System.out.print(treeNode.getValue() +" ");
			preorderTraverse(treeNode.getLeftChild());
			preorderTraverse(treeNode.getRightChild());
		}
	}

	private static void postorderTraverse(TreeNode treeNode) {
		if(treeNode != null) {
			postorderTraverse(treeNode.getLeftChild());
			postorderTraverse(treeNode.getRightChild());
			System.out.print(treeNode.getValue() +" ");
		}
	}
	
	private static void inorderTraverse(TreeNode treeNode) {

		if(treeNode != null) {
			inorderTraverse(treeNode.getLeftChild());
			System.out.print(treeNode.getValue() +" ");
			inorderTraverse(treeNode.getRightChild());
		}
		
		
	}

	

}

