package com.wy.leetcode.question46;

import java.util.*;

/**
 * @author wy
 * @date 2020/5/7
 * @description 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        final int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        if (length == 0) {
            return result;
        }
        dfs(nums, 0, path, result);
        return result;
    }

    private void dfs(int[] nums, int depth, Deque<Integer> path, List<List<Integer>> result) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(path));
        }
        for (int num : nums) {
            if (path.contains(num)) {
                continue;
            }
            path.addLast(num);
            dfs(nums, depth + 1, path, result);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        final List<List<Integer>> result = solution.permute(new int[]{1});
        System.out.println(result);
    }
}
