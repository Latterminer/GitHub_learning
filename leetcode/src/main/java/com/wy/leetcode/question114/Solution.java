package com.wy.leetcode.question114;

/**
 * @author wy
 * @date 2020/5/21
 * @description
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 */
public class Solution {
    public void flatten(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }












    public void flatten1(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                // 如果左子树不为null
                TreeNode pre = root.left;
                // 需要找到左子树最右边的节点
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 把根节点的右节点加到左子树最右节点的右节点
                pre.right = root.right;
                // root的左子树要置空
                root.left = null;
            }
            // 下一个节点
            root = root.right;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}