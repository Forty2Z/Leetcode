package com.forty2leetcode.oct2;

/*
* Leetcode 55: Jump game
*Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.
*解法：设置变量为i点的能走出的最大步长，max = Math.max(num[i] + i, max)
* 如果说之前的max值走不到index i 返回false i > max
*
*
* */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}
