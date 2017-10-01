package com.forty2leetcode.oct1;

/*
* Leetcode 152: MaximumProductSubarray
* Find the contiguous subarray within an array (containing at least one number) which has the largest product.
For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*解法：这道题比较有意思，可以用DP来做，每次乘以nums[i]需要记录当前的两个值，最小值和最大值，因为负数的最小值也许会变成最大值
*
*
*
* */

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(min * nums[i], max * nums[i]), nums[i]);
            min = Math.min(Math.min(min * nums[i], temp * nums[i]), nums[i]);
            if (max > result) {
                result = max;
            }
        }

        return result;
    }
}
