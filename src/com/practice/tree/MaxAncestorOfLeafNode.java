package com.practice.tree;

public class MaxAncestorOfLeafNode {
    public static void main(String[] args) {
        System.out.println("First run - on a binary search tree ...");
        TreeNode rootOfABinarySearchTree = TreeUtil.constructBinarySearchTree();
        printMaxAncestorOfLeaf(rootOfABinarySearchTree, rootOfABinarySearchTree.getValue());

        System.out.println("\n\nFirst run - on a binary tree ...");
        TreeNode rootOfABinaryTree = TreeUtil.constructBinaryTree();
        printMaxAncestorOfLeaf(rootOfABinaryTree, rootOfABinaryTree.getValue());

    }

    private static void printMaxAncestorOfLeaf(TreeNode node, int maxValue) {
        maxValue = node.getValue() > maxValue ? node.getValue() : maxValue;

        // Base condition - leaf node check and print max ancestor
        if(node.getLeftChild() == null && node.getRightChild() == null){
            System.out.printf("Leaf %d -> Max Ancestor %d \n",node.getValue(), maxValue);
        }

        if(node.getLeftChild() != null)
            printMaxAncestorOfLeaf(node.getLeftChild(), maxValue);

        if(node.getRightChild() != null)
            printMaxAncestorOfLeaf(node.getRightChild(), maxValue);
    }
}
