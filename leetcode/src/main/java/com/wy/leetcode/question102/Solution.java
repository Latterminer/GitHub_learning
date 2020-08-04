package com.wy.leetcode.question102;

import java.util.*;

/**
 * @author wy
 * @date 2020/5/19
 * @description
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            // 每一层的长度
            final int size = deque.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                final TreeNode node = deque.pollFirst();
                layer.add(node.val);
                final TreeNode left = node.left;
                if (left != null) {
                    deque.addLast(left);
                }
                final TreeNode right = node.right;
                if (right != null) {
                    deque.addLast(right);
                }
            }
            result.add(layer);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        Solution solution = new Solution();
        final List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists.toString());
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