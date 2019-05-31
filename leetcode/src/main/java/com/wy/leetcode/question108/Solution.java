package com.wy.leetcode.question108;

/**
 * @author wangyong
 * @date 2019/5/30
 * @description 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int lo = 0;
        int hi = nums.length;
        return buildTree(nums, 0, hi);
    }

    public TreeNode buildTree(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (lo + hi) / 2 - 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, lo, mid - 1);
        root.right = buildTree(nums, mid + 1, hi);
        return root;
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