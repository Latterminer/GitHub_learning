package com.wy.leetcode.question39;

import java.util.*;

/**
 * @author wy
 * @date 2020/4/27
 * @description 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序是为了剪枝
        Arrays.sort(candidates);
        search(candidates, target, 0, result, new ArrayDeque<>());
        return result;
    }

    /**
     * @param candidates 数组输入
     * @param target     剩余数值
     * @param begin      本轮搜索的起点下标
     * @param deque      从根结点到任意结点的路径
     * @param result     结果集变量
     */
    public void search(int[] candidates, int target, int begin, List<List<Integer>> result, Deque<Integer> deque) {
        if (target == 0) {
            result.add(new ArrayList<>(deque));
            return;
        }
        // 因为数组是排序过的，所以只需要从当前位置开始找，否则会重复
        for (int i = begin; i < candidates.length - 1; i++) {
            int newTarget = target - candidates[i];
            // 如果一个数已经超出target，那比它大的数必然也是超出target，这时候可以剪掉
            if (newTarget < 0) {
                break;
            }
            deque.add(candidates[i]);
            search(candidates, newTarget, i, result, deque);
            deque.removeLast();
        }
    }
}
