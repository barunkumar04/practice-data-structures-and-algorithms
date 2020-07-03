package com.practice.tree;

public class TreeTraversal {

	public static void main(String[] args) {
		TreeNode rootNode = constructBinaryTree(); 
		
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

	private static TreeNode constructBinaryTree() {
		
		/**
		 *                   10
		 *                 /    \
		 *                5     15
		 *               / \      \
		 *              4   8      17
		 *                   \    /  \
		 *                    9  20  25
		 */
		
		
		TreeNode rootNode = new TreeNode(10);
		
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(9);
		
		TreeNode node5 = new TreeNode(15);
		TreeNode node6 = new TreeNode(20);
		TreeNode node7 = new TreeNode(17);
		TreeNode node8 = new TreeNode(25);
		
		
		node2.setLeftChild(node3);
		node1.setLeftChild(node2);
		node1.setRightChild(node4);
		
		rootNode.setLeftChild(node1);
			
		node6.setLeftChild(node7);
		node6.setRightChild(node8);
		node5.setRightChild(node6);
		
		rootNode.setRightChild(node5);
		
		return rootNode;
	}

}

class TreeNode{
	
	private TreeNode leftChild;
	private int value;
	private TreeNode rightChild;
	
	public TreeNode(int value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	
}