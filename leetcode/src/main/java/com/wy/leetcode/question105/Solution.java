package com.wy.leetcode.question105;

/**
 * @author wy
 * @date 2020/5/20
 * @description
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return subTree(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode subTree(int[] preorder,
                             int preorderStart,
                             int[] inorder,
                             int inorderStart,
                             int inorderEnd) {
        if (inorderEnd < inorderStart) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderStart]);
        int inorderRootIndex = inorderStart;
        for (; inorderRootIndex < inorder.length; inorderRootIndex++) {
            if (inorder[inorderRootIndex] == preorder[preorderStart]) {
                break;
            }
        }

        int leftLen = inorderRootIndex - inorderStart;

        root.left = subTree(preorder,
                preorderStart + 1,
                inorder,
                inorderStart,
                inorderRootIndex - 1);

        root.right = subTree(preorder,
                preorderStart + leftLen + 1,
                inorder,
                inorderRootIndex + 1,
                inorderEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        Solution solution = new Solution();
        final TreeNode treeNode = solution.buildTree(preorder, inorder);
        System.out.println(treeNode);
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