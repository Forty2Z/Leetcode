package com.forty2leetcode.oct2;

/*
* Leetcode 230 :Kth Smallest Element in a BST
*Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
*解法：BST inorder traversal: left->root->right
* recursion, 设置两个全局变量，一个count 当前树节点位置，一个记录element值
*
*
* */

public class KthSmallestElementInBST {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res;
    int count;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        if (root.left != null) helper(root.left);
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        if (root.right != null) helper(root.right);
    }
}
