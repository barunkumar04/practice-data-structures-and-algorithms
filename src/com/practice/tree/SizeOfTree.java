package com.practice.tree;

public class SizeOfTree {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.constructBinarySearchTree();

		System.out.println(size(root));

	}

	private static int size(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + size(root.getLeftChild()) + size(root.getRightChild());
	}

}
