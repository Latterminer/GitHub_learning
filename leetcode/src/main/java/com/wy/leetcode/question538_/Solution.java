package com.wy.leetcode.question538_;

/**
 * @author wangyong
 * @date 2019/6/20
 * @description
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 */
public class Solution {
    private int sum = 0;

    /**
     * 逆中序遍历， 右 -> 中 -> 左， 也就是最靠左边的那个叶子是所有节点的和
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        sumRightTree(root);
        return root;
    }

    private void sumRightTree(TreeNode root) {
        if (root == null) {
            return ;
        }
        sumRightTree(root.right);
        root.val += sum;
        sum = root.val;
        sumRightTree(root.left);
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