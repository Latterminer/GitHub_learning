package com.wy.leetcode.question938;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangyong
 * @date 2019/5/5
 * @description 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * <p>
 * 二叉搜索树保证具有唯一的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 * <p>
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 */
public class Solution {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        /*
        先写出树的中序遍历
         */
        ArrayList<Integer> midTree = new ArrayList<>();
        getMidTree(root, midTree);

        System.out.println(Arrays.toString(midTree.toArray()));
        return midTree.stream().filter(it -> L <= it && it <= R).mapToInt(it -> it).sum();
    }

    /**
     * 中序遍历
     */
    private void getMidTree(TreeNode root, List<Integer> result) {
        if (root != null) {
            getMidTree(root.left, result);
            result.add(root.val);
            getMidTree(root.right, result);
        }
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