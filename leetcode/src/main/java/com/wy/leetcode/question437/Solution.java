package com.wy.leetcode.question437;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyong
 * @date 2019/6/25
 * @description 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * <p>
 * 示例：
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * 返回 3。和等于 8 的路径有:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        int result = 0;
        if (root == null) {
            return result;
        }
        result += findPath(root, sum);
        result += pathSum(root.left, sum);
        result += pathSum(root.right, sum);
        return result;
    }

    private int findPath(TreeNode root, int sum) {
        int result = 0;
        if (root == null) {
            return result;
        }
        if (root.val == sum) {
            result += 1;
        }
        result += findPath(root.left, sum - root.val);
        result += findPath(root.right, sum - root.val);
        return result;
    }

    /**
     * 高手的解法，利用hashmap缓存一些节点的值
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum1(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        return helper(root, sum, 0, map);
    }

    public int helper(TreeNode root, int sum, int curSum, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        curSum += root.val;
        int cur = 0;
        if (map.containsKey(curSum - sum)) {
            cur = map.get(curSum - sum);
        }
        if (!map.containsKey(curSum)) {
            map.put(curSum, 1);
        } else {
            map.put(curSum, map.get(curSum) + 1);
        }
        int res = cur + helper(root.left, sum, curSum, map) + helper(root.right, sum, curSum, map);
        map.put(curSum, map.get(curSum) - 1);
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}