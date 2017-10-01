package com.forty2leetcode.sep30;

/*
* Leetcode 530: MinimumAbsoluteDifference in BST
* Given a binary search tree with non-negative values,
* find the minimum absolute difference between values of any two nodes.
*解法：in order traversal of BST, BST in order traversal 是递增的
* left->root->right
* 记录之前的节点prev = root
* 初始值设为Integer.MAX_VALUE
* */
public class MinumumAbsoluteDifferenceInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode prev = null;
    int dif = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return dif;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (prev != null) {
            dif = Math.min(Math.abs(root.val - prev.val), dif);
        }
        prev = root;
        helper(root.right);
    }
}
