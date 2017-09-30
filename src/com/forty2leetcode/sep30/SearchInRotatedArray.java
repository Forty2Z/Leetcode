package com.forty2leetcode.sep30;


/*
* Leetcode: 33: Search in Rotated Sorted Array
*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
*
*二分查找，中点和either start 或者 end point是ordered
*
* */
public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[start]) {
                if (nums[start] <= target && nums[mid] >= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            if (nums[mid] < nums[end]) {
                if (nums[end] >= target && nums[mid] <= target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
