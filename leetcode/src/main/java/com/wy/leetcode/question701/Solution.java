package com.wy.leetcode.question701;

/**
 * @author wangyong
 * @date 2019/5/30
 * @description 例如,
 * <p>
 * 给定二叉搜索树:
 * <p>
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   /
 * 1   3 5
 * 或者这个树也是有效的:
 * <p>
 * 5
 * /   \
 * 2     7
 * / \
 * 1   3
 * \
 * 4
 */
public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        insert(root, val);
        return root;
    }

    /**
     * 深度优先遍历
     *
     * @param root
     * @param val
     */
    public void insert(TreeNode root, int val) {
        if (val > root.val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            }
            insert(root.right, val);
        }
        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return;
            }
            insert(root.left, val);
        }

    }

    /**
     * 别人的解法
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        TreeNode y = null;
        TreeNode x = root;
        /*
        同样是深度优先遍历，找到合适的位置，x作为深度遍历的临时变量，y记录x的父节点
         */
        while (x != null) {
            y = x;
            if (val < x.val)
                x = x.left;
            else
                x = x.right;
        }
        TreeNode node = new TreeNode(val);
        /*
        把val插入到相对于y的合适的位置，如果y为null，则说明root为null
         */
        if (y == null)
            return node;
        else if (val < y.val)
            y.left = node;
        else
            y.right = node;
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
