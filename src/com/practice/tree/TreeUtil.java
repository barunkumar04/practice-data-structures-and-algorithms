package com.practice.tree;

public class TreeUtil {

public static TreeNode constructBinaryTree() {
		
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
		
		
		rootNode.setLeftChild(node2);
		rootNode.setRightChild(node5);
		
		node2.setLeftChild(node3);
		node2.setRightChild(node1);
		
		node1.setRightChild(node4);
		
		node5.setRightChild(node7);
		
		node7.setLeftChild(node6);
		node7.setRightChild(node8);
		
		
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

	@Override
	public String toString() {
		return "TreeNode [leftChild=" + leftChild + ", value=" + value + ", rightChild=" + rightChild + "]";
	}
	
	
}