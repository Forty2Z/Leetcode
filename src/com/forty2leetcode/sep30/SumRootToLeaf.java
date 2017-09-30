package com.forty2leetcode.sep30;


/*
* Leetcode 129: Sum Root to Leaf Numbers
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.
*
*解法： DFS，preorder traversal(root->left->right)
* 找到path from root to leaf(root.left == null & root.right == null)
* add to total and return.
*
*
* */

public class SumRootToLeaf {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int total;

    public int sumNumbers(TreeNode root) {
        total = 0;
        helper(root, 0);
        return total;
    }

    private void helper(TreeNode root, int temp) {
        if (root == null) return;

        temp = temp * 10 + root.val;

        if (root.left == null && root.right == null) {
            total += temp;
            return;
        }
        helper(root.left, temp);
        helper(root.right, temp);


    }
}
