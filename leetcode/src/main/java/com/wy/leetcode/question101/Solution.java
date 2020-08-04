package com.wy.leetcode.question101;

import com.sun.javafx.logging.JFRInputEvent;

/**
 * @author wy
 * @date 2020/5/19
 * @description
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    private boolean dfs(TreeNode nodeLeft, TreeNode nodeRight) {
        if (nodeLeft == null && nodeRight == null) {
            return true;
        }
        if (nodeLeft == null || nodeRight == null) {
            return false;
        }
        if (nodeLeft.val == nodeRight.val) {
            return dfs(nodeLeft.left, nodeRight.right) && dfs(nodeLeft.right, nodeRight.left);
        }
        return false;
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