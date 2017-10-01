package com.forty2leetcode.oct1;
/*
* Leetcode 78： Subsets
*Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.
*
*解法： DFS， 先sort 数组， 然后从[]开始往里面加[]->[1]->[1,2]->[1,2,3]->[1,3]每次加一个数进去recursion再把原来那个数去掉
*
*
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> array = new ArrayList<>();
        helper(nums, array, new ArrayList<>(), 0);
        return array;

    }

    private void helper(int[] nums, List<List<Integer>> array, List<Integer> temp, int index) {
        array.add(new ArrayList(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, array, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
        return;
    }
}
